package com.hackerrank.github.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.hackerrank.github.listner.TaskListner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.infoedge.constant.TestStatus;
import com.infoedge.dao.LabDao;
import com.infoedge.dao.LabHospitalDao;
import com.infoedge.dao.TestDao;
import com.infoedge.model.Lab;
import com.infoedge.model.LabHospital;
import com.infoedge.model.Test;

@Component
public class TestProcessor {


  public static final long FIVE_HOURS = 18000000;
  @Autowired
  private TestDao testDao;

  @Autowired
  private LabDao labDao;
  
  
  @Autowired
  private  LabHospitalDao labHospitalDao;
  


  private PriorityBlockingQueue<Test> queue = new PriorityBlockingQueue<>();

  @PostConstruct
  public void taskProcessor() {
    TaskListner taskListner = new TaskListner(queue, this);
    taskListner.run();
  }

  @Transactional
  public void notify(Test test) {

    Test t = testDao.getOne(test.getId());
    t.setStatus(TestStatus.COMPLETED.name());

    testDao.save(t);

    Test t2 = testDao.getByLabIdAndStatus(t.getLabId(), TestStatus.WAITING.name());

    if (t2 != null) {
      t2.setStatus(TestStatus.RUNNING.name());
      testDao.save(t2);
      queue.put(t2);
    } else {
      Lab lab = labDao.getOne(t.getLabId());
      lab.setActiveTest(lab.getActiveTest() - 1);
      labDao.save(lab);

    }



  }

  @Transactional
  public void addTest(Integer labId, Integer hospitalId) throws Exception {

    
    LabHospital labHospitals = labHospitalDao.getLabsByHospitalIdAndLabId(hospitalId,labId);

    Test t = new Test();
    t.setCreated(new Date());
    t.setHospitalId(hospitalId);
    t.setLabId(labId);

    Optional<Lab> l = labDao.findById(labId);
    if (!l.isPresent()) {
      throw new Exception();
    } else {

      Lab lab = l.get();
      int max = lab.getMaxCapacity();
      int active = lab.getActiveTest();



      if (max * 10 < active) {

        throw new Exception();
      }
      if (max > active) {
        t.setStatus(TestStatus.RUNNING.name());
        t.setEndTime(System.currentTimeMillis()+labHospitals.getTime() + FIVE_HOURS+labHospitals.getTime());
        testDao.save(t);
        lab.setActiveTest(active + 1);
        labDao.save(lab);
        queue.put(t);

      } else {
        List<Test> testList = testDao.getByLabId(labId);
        if (!CollectionUtils.isEmpty(testList)) {

          List<Test> runningTestList = testList.stream().filter(tl -> tl.getStatus().equals(TestStatus.RUNNING.name())).collect(Collectors.toList());
          List<Test> waitingTestList = testList.stream().filter(tl -> tl.getStatus().equals(TestStatus.WAITING.name())).collect(Collectors.toList());
          Test t3;
          if (runningTestList.size() > waitingTestList.size()) {
            t3 = runningTestList.get(waitingTestList.size() + 1);

          } else {


            t3 = waitingTestList.get(waitingTestList.size() - runningTestList.size() + 1);



          }
          t.setStatus(TestStatus.WAITING.name());

          t.setEndTime( t3.getEndTime() - System.currentTimeMillis() + FIVE_HOURS+ labHospitals.getTime());

          lab.setActiveTest(active + 1);
          labDao.save(lab);

        }


      }


    }



  }



}



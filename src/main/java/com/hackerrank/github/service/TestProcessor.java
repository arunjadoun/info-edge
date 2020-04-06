package com.hackerrank.github.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hackerrank.github.constant.TestStatus;
import com.hackerrank.github.model.Lab;
import com.hackerrank.github.model.Test;
import com.infoedge.dao.LabDao;
import com.infoedge.dao.TestDao;

@Component
public class TestProcessor {


  @Autowired
  private TestDao testDao;

  @Autowired
  private LabDao labDao;

  public void taskProcessor(PriorityBlockingQueue<Test> queue) {


    while (true) {
      Test test = queue.peek();
      if (test.getEndTime() > System.currentTimeMillis()) {
        queue.poll();
        notify(test, queue);
      }
    }



  }

  @Transactional
  public void notify(Test test, PriorityBlockingQueue<Test> queue) {

    Test t = testDao.getOne(test.getId());
    t.setStatus(TestStatus.COMPLETED.name());

    testDao.save(t);

    Test t2 = testDao.findByStatusByCredated(t.getLabId(), TestStatus.WAITING.name());
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
  public void addTest(Integer labId, Integer hospitalId, PriorityBlockingQueue<Test> queue) throws Exception {

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
        t.setEndTime(System.currentTimeMillis() + 18000000);
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

          t.setEndTime(System.currentTimeMillis() - t3.getEndTime() + 18000000);

          lab.setActiveTest(active + 1);
          labDao.save(lab);

        }


      }


    }



  }



}


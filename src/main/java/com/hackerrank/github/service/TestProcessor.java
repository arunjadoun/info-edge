package com.hackerrank.github.service;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.PriorityBlockingQueue;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    t.setStatus("COMPLETED");

    testDao.save(t);

    Test t2 = testDao.findByStatusByCredated(t.getLabId(), "WAITING");
    if (t2 != null) {
      t2.setStatus("RUNNING");
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

    Optional<Lab> lab = labDao.findById(labId);
    if (!lab.isPresent()) {
      throw new Exception();
    } else {
      int max = lab.get().getMaxCapacity();
      int active = lab.get().getActiveTest();
      Test t2 = testDao.getByLabStatus(labId);
      if (max > active) {
        t.setStatus("RUNNING");
        t.setEndTime(System.currentTimeMillis()+18000000);
        testDao.save(t);
        queue.put(t);

      }
      else {
        
      }


    }





  }



}



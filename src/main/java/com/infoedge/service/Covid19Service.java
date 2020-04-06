package com.infoedge.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoedge.dao.LabDao;
import com.infoedge.dao.LabHospitalDao;
import com.infoedge.dao.TestDao;
import com.infoedge.model.Lab;
import com.infoedge.model.LabHospital;
import com.infoedge.model.Test;
import com.infoedge.request.AddTestRequest;

@Service
public class Covid19Service {

     
   
    @Autowired
    private LabDao labDao;
    @Autowired
    private LabHospitalDao labHospitalDao;
    @Autowired
    private TestDao testDao;
    
    
    @Autowired
    private TestProcessor testProcessor;

    public Lab getNearByLab(Integer hospitalId){
        List<LabHospital> labHospitals = labHospitalDao.getLabsByHospitalId(hospitalId);
        List<Test> tests = new ArrayList<>();
        for(LabHospital labHospital : labHospitals){
            List<Test> testList = testDao.getByLabId(labHospital.getLabId());
            tests.add(testList.get(testList.size()-1));
        }
        Collections.sort(tests);
        return labDao.findById(tests.get(0).getLabId()).get();
    }

    public boolean addTest(AddTestRequest request) throws Exception {
       boolean isSuccess=  testProcessor.addTest(request.getLabId(), request.getHospitalId());
      return isSuccess;
    }

}

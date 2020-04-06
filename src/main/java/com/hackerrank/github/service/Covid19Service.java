package com.hackerrank.github.service;

import com.hackerrank.github.model.Lab;
import com.hackerrank.github.model.LabHospital;
import com.infoedge.dao.HospitalDao;
import com.infoedge.dao.LabDao;
import com.infoedge.dao.LabHospitalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Covid19Service {

    @Autowired
    private HospitalDao hospitalDao;
    @Autowired
    private LabDao labDao;
    @Autowired
    private LabHospitalDao labHospitalDao;

    public Lab getNearByLab(Long hospitalId){
        List<Integer> labList = labHospitalDao.getLabsByHospital(hospitalId);
        labDao.findAll(labList.iterator());
        return new Lab();
    }

}

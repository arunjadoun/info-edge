package com.hackerrank.github.service;

import com.hackerrank.github.model.Lab;
import com.hackerrank.github.model.LabHospital;
import com.hackerrank.github.model.Test;
import com.infoedge.dao.HospitalDao;
import com.infoedge.dao.LabDao;
import com.infoedge.dao.LabHospitalDao;
import com.infoedge.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Covid19Service {

    @Autowired
    private HospitalDao hospitalDao;
    @Autowired
    private LabDao labDao;
    @Autowired
    private LabHospitalDao labHospitalDao;
    @Autowired
    private TestDao testDao;

    public Lab getNearByLab(Long hospitalId){
        List<Integer> labList = labHospitalDao.getLabsByHospitalId(hospitalId);
        List<Test> testList = labList.stream().map(integer -> testDao.getByLabId(integer)).collect(Collectors.toList());
        Collections.sort(testList);
        return labDao.findById(testList.get(0).getLabId()).get();
    }

}

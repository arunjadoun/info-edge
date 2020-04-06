package com.hackerrank.github.service;

import com.hackerrank.github.model.Lab;
import com.infoedge.dao.HospitalDao;
import com.infoedge.dao.LabDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Covid19Service {

    @Autowired
    private HospitalDao hospitalDao;
    @Autowired
    private LabDao labDao;

    public Lab getNearByLab(Long hospitalId){
        return new Lab();
    }

}

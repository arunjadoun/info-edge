package com.infoedge.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infoedge.model.Test;


public interface TestDao extends JpaRepository<Test, Integer>  {
    @Query(name = "select t from Test t where t.labId = ?1 order by t.endTime desc")
    public List<Test> getByLabId(Integer labId);

    @Query(name = "select t from Test t where t.labId = ?1 and t.hospitalId = ?2 order by t.endTime desc")
    public List<Test> getByLabIdAndHospitalId(Integer labId, Integer hId);



    @Query(name = "select t from test t where t.lab_id = ?1 and t.status = 'RUNNING' order by t.endTime desc limit 1", nativeQuery = true)
    public Test getById(Integer lId);


    
    @Query(name = "select t from test t where t.lab_id = ?1 and t.status =?2 order by t.created asc limit 1", nativeQuery = true)
    public Test getByLabIdAndStatus(Integer ll, String status);





}

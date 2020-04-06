package com.infoedge.dao;

import com.hackerrank.github.model.LabHospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LabHospitalDao   extends JpaRepository<LabHospital, Integer> {
    @Query(name = "select lh.labId from LabHospital lh, Lab l, Test t where lh.hospitalId = ?1 and lh.labId = l.id and t.status <> 'COMPLETED' and t.labId = l.id having count(t.id) < l.maxCapacity*10")
    public List<LabHospital> getLabsByHospitalId(Integer id);
}

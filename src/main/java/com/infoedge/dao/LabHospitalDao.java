package com.infoedge.dao;

import com.hackerrank.github.model.LabHospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LabHospitalDao   extends JpaRepository<LabHospital, Integer> {
    @Query(name = "select labId from LabHospital where hospitalId = ?1")
    public List<Integer> getLabsByHospital(Long id);
}

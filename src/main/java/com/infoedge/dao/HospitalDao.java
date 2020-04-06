package com.infoedge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackerrank.github.model.Hospital;


public interface HospitalDao  extends JpaRepository<Hospital, Integer>  {

}

package com.infoedge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infoedge.model.Hospital;


public interface HospitalDao  extends JpaRepository<Hospital, Integer>  {

}

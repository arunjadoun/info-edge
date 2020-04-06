package com.infoedge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackerrank.github.model.Lab;


public interface LabDao  extends JpaRepository<Lab, Integer>  {

}

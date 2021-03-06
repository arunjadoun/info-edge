package com.infoedge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lab_hospital")
public class LabHospital {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "lab_id")
  private Integer labId;

  
  @Column(name = "hospital_id")
  private Integer hospitalId;

  @Column(name = "time")
  private long time;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getLabId() {
    return labId;
  }

  public void setLabId(Integer labId) {
    this.labId = labId;
  }

  public Integer getHospitalId() {
    return hospitalId;
  }

  public void setHospitalId(Integer hospitalId) {
    this.hospitalId = hospitalId;
  }

  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
  }



}

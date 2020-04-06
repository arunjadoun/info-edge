package com.hackerrank.github.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the city_state database table.
 * 
 */
@Entity
@Table(name = "test", catalog = "test")
public class Test implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -1447585156625212640L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;


  @Column(name = "lab_id")
  private Integer labId;

  @Column(name = "hospital_id")
  private Integer hospitalId;

  @Column(name = "result")
  private int result;


  @Temporal(TemporalType.TIMESTAMP)
  private Date created;



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



  public int getResult() {
    return result;
  }



  public void setResult(int result) {
    this.result = result;
  }



  public Date getCreated() {
    return created;
  }



  public void setCreated(Date created) {
    this.created = created;
  }



}
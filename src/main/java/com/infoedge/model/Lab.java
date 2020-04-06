package com.infoedge.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the city_state database table.
 * 
 */
@Entity
@Table(name = "lab")
public class Lab implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -1447585156625212640L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "latitude")
  private Double latitude;

  @Column(name = "longitude")
  private Double longitude;
  



  @Column(name = "max_capacity")
  private int maxCapacity;
  
  
  

  @Column(name = "active_test")
  private int activeTest;



  @Temporal(TemporalType.TIMESTAMP)
  private Date created;



  public Integer getId() {
    return id;
  }



  public void setId(Integer id) {
    this.id = id;
  }



  public String getName() {
    return name;
  }



  public void setName(String name) {
    this.name = name;
  }



  public Double getLatitude() {
    return latitude;
  }



  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }



  public Double getLongitude() {
    return longitude;
  }



  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }



  public int getMaxCapacity() {
    return maxCapacity;
  }



  public void setMaxCapacity(int maxCapacity) {
    this.maxCapacity = maxCapacity;
  }

  
  


  public int getActiveTest() {
    return activeTest;
  }



  public void setActiveTest(int activeTest) {
    this.activeTest = activeTest;
  }



  public Date getCreated() {
    return created;
  }



  public void setCreated(Date created) {
    this.created = created;
  }



}

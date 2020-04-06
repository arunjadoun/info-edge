package com.hackerrank.github.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the city_state database table.
 * 
 */
@Entity
@Table(name = "hospital", catalog = "test")
public class Hospital implements Serializable {

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
  private Long latitude;

  @Column(name = "longitude")
  private Long longitude;



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



  public Long getLatitude() {
    return latitude;
  }



  public void setLatitude(Long latitude) {
    this.latitude = latitude;
  }



  public Long getLongitude() {
    return longitude;
  }



  public void setLongitude(Long longitude) {
    this.longitude = longitude;
  }



  public Date getCreated() {
    return created;
  }



  public void setCreated(Date created) {
    this.created = created;
  }

  
  


}

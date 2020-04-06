package com.infoedge.dto;

import java.util.PriorityQueue;

public class LabDTO {

  public String getLabName() {
    return labName;
  }

  public void setLabName(String labName) {
    this.labName = labName;
  }

  public PriorityQueue<Long> getLocalQ() {
    return localQ;
  }

  public void setLocalQ(PriorityQueue<Long> localQ) {
    this.localQ = localQ;
  }

  private String labName;
  
  private int size; 
  

  private PriorityQueue<Long> localQ = new PriorityQueue<>(size);


}

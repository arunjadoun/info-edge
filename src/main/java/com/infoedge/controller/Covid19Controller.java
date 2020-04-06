package com.infoedge.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infoedge.model.Lab;
import com.infoedge.request.AddTestRequest;
import com.infoedge.response.AddTestRespose;
import com.infoedge.service.Covid19Service;

@RestController
public class Covid19Controller {

  @Autowired
  private Covid19Service covid19Service;

  @GetMapping("/getLab/{hospitalID}")
  public Lab getAllEvents(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable int hospitalID) {
    return covid19Service.getNearByLab(hospitalID);
  }



  @PostMapping(value = "/addTest")
  public AddTestRespose fetchAdmin(@RequestBody AddTestRequest request, HttpServletRequest httpServletRequest) throws Exception {

    AddTestRespose response = new AddTestRespose();
    if (covid19Service.addTest(request)) {
      response.setMessage("Success");
      return response;
    }
    response.setMessage("Failed");
    return response;
  }

}

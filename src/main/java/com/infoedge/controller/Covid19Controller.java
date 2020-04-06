package com.infoedge.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infoedge.model.Lab;
import com.infoedge.service.Covid19Service;

@RestController
public class Covid19Controller {

    @Autowired
    private Covid19Service covid19Service;

    @GetMapping("/events/actor/{hospitalID}")
    public Lab getAllEvents(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable int hospitalID){
        return covid19Service.getNearByLab(hospitalID);
    }

}

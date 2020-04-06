package com.hackerrank.github.controller;

import com.hackerrank.github.dto.RepoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Covid19Controller {

    @GetMapping("/events/actor/{hospitalID}")
    public List<RepoDTO> getAllEvents(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable int hospitalID){
        //Event event = gson.fromJson(body, Event.class);
        List<RepoDTO> r = new ArrayList<>();
        return r;
        //eventRepository.save(event);

    }

}

/*
package com.hackerrank.github.controller;

import com.google.gson.Gson;
import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.ActorRepository;
import com.hackerrank.github.repository.EventRepository;
import com.hackerrank.github.service.ActorService;
import com.hackerrank.github.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class GithubApiRestController {

    @Autowired
    EventService eventService;

    @Autowired
    ActorService actorService;

    private Gson gson = new Gson();

    @PostMapping("/events")
    public String addEvent(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String body){
        EventDTO event = gson.fromJson(body, EventDTO.class);
//        validateEvent()
        eventService.save(event);
        return "success";
    }

    @PutMapping("/actors")
    public String updateAvatarUrl(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String body){
        Actor actor = gson.fromJson(body, Actor.class);
        if(!StringUtils.isEmpty(actor.getLogin())){
            //TODO Through error
        }else {
            actorService.save(actor);
        }
        return "success";
    }

    //@PostMapping("/events")
    @DeleteMapping("/erase")
    public String deleteAllEvents(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse){
        //Event event = gson.fromJson(body, Event.class);
        eventService.deleteAll();
        //eventRepository.save(event);
        return "success";
    }

    //@PostMapping("/events")
    @GetMapping("/events")
    public List<Event> getAllEvents(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse){
        //Event event = gson.fromJson(body, Event.class);
        return eventService.getAllEvents();
        //eventRepository.save(event);

    }

    @GetMapping("/events/actor/{actorID}")
    public List<Event> getAllEvents(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable int actorID){
        //Event event = gson.fromJson(body, Event.class);
        return eventService.getAllEventsbyActorID(actorID);
        //eventRepository.save(event);

    }

    @GetMapping("/actors")
    public List<Event> getAllEventhhs(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse){
        //Event event = gson.fromJson(body, Event.class);
//        return eventRepository.getAllEventsbyActorID(actorID);
        //eventRepository.save(event);
return null;
    }

}
*/

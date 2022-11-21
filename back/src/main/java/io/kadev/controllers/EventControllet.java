package io.kadev.controllers;

import Dto.EventDto;
import io.kadev.models.Event;
import io.kadev.models.User;
import io.kadev.services.EventService;
import io.kadev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventControllet {
    @Autowired
    EventService eventService;

    @PostMapping("/add-event")
    public ResponseEntity<Event> addEvent(@RequestParam EventDto eventDto){
        Event event = new Event();
        event.setDescription(eventDto.getDescription());
        event.setTitle(eventDto.getTitle());
        event.setAddress_of_location(eventDto.getAddress_of_location());
        return ResponseEntity.ok().body(eventService.addEvent(event));
    }

    @GetMapping("/events")
    public List<Event> getAllEvents(){
        return eventService.getAllEvent();
    }

    @GetMapping("/events/{id}")
    public Event getEventById(@PathVariable Long id){
        return eventService.getEvent(id);
    }



}

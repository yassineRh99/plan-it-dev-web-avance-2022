package io.kadev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Dto.EventDto;
import io.kadev.models.Event;
import io.kadev.services.EventService;

@RestController
public class EventControllet {
    @Autowired
    EventService eventService;

    @PostMapping("/add-event")
    public ResponseEntity<Event> addEvent(@RequestBody EventDto eventDto){
        Event event = new Event();
        event.setDescription(eventDto.getDescription());
        event.setTitle(eventDto.getTitle());
        event.setAddress_of_location(eventDto.getAddress_of_location());
        event.setEventDates((eventDto.getEventDates()));
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

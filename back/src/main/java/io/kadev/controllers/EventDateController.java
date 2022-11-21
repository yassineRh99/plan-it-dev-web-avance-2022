package io.kadev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Dto.EventDateDto;
import io.kadev.models.EventDate;
import io.kadev.services.EventDateService;

@RestController
public class EventDateController {
    @Autowired
    EventDateService eventDateService;

    @PostMapping("/add-event-date")
    public ResponseEntity<EventDate> addEventDate(@RequestBody EventDateDto eventDateDto){
        EventDate eventDate = new EventDate();
        eventDate.setDate_of_event(eventDateDto.getValue());
        return ResponseEntity.ok().body(eventDateService.addEventDate(eventDate));
    }
}

package io.kadev.controllers;

import Dto.EventDateDto;
import Dto.EventDto;
import io.kadev.models.Event;
import io.kadev.models.EventDate;
import io.kadev.services.EventDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

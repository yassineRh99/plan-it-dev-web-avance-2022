package io.kadev.services;

import io.kadev.models.EventDate;

import java.util.List;

public interface EventDateService {
    EventDate addEventDate(EventDate eventDate);
    EventDate getEventDate(int eventId);
    List<EventDate> getAllEventDate();
}

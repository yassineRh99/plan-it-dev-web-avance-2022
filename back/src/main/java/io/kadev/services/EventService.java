package io.kadev.services;

import java.util.List;

import io.kadev.models.Event;

public interface EventService {
    Event addEvent(Event event);
    Event getEvent(Long eventId);
    List<Event> getAllEvent();
}

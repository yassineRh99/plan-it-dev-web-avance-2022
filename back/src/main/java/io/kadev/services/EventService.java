package io.kadev.services;

import io.kadev.models.Event;


import java.util.List;

public interface EventService {
    Event addEvent(Event event);
    Event getEvent(int eventId);
    List<Event> getAllEvent();
}

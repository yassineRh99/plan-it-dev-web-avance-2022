package io.kadev.services;

import io.kadev.models.Event;
import io.kadev.repositories.EventRepository;
import io.kadev.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event addEvent(Event event){
        log.info("Adding new event");
        return eventRepository.save(event);
    }

    @Override
    public Event getEvent(int eventId){ return eventRepository.findById(eventId); }

    @Override
    public List<Event> getAllEvent(){ return eventRepository.findAll();
    }

}

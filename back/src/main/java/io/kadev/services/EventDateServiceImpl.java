package io.kadev.services;

import io.kadev.models.EventDate;
import io.kadev.repositories.EventDateRepository;
import io.kadev.repositories.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class EventDateServiceImpl implements EventDateService{
    @Autowired
    private EventDateRepository eventDateRepository;

    @Override
    public EventDate addEventDate(EventDate eventDate){
        log.info("Adding new event date");
        return eventDateRepository.save(eventDate);
    }
    @Override
    public EventDate getEventDate(int eventId){ return eventDateRepository.findById(eventId); }

    @Override
    public List<EventDate> getAllEventDate(){ return eventDateRepository.findAll(); }


}

package io.kadev.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kadev.models.EventDate;
import io.kadev.repositories.EventDateRepository;
import lombok.extern.slf4j.Slf4j;

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

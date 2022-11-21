package io.kadev.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kadev.models.Event;
import io.kadev.repositories.EventRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class EventServiceImpl implements EventService {
	@Autowired
	private EventRepository eventRepository;

	@Override
	public Event addEvent(Event event) {
		log.info("Adding new event");
		return eventRepository.save(event);

	}

	@Override
	public Event getEvent(Long eventId) {
		return eventRepository.findById(eventId).orElseThrow();
	}

	@Override
	public List<Event> getAllEvent() {
		return eventRepository.findAll();
	}

}

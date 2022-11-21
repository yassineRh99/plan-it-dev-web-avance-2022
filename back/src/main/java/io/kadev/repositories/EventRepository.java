package io.kadev.repositories;

import io.kadev.models.Event;
import io.kadev.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository  extends JpaRepository<Event, Long> {
    Event findById(int id);
    List <Event> findAll();
}

package io.kadev.repositories;

import io.kadev.models.Event;
import io.kadev.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository  extends JpaRepository<Event, Long> {
    Optional<Event> findById(Long id);
    List <Event> findAll();
}

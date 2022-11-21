package io.kadev.repositories;

import io.kadev.models.EventDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventDateRepository extends JpaRepository<EventDate, Long> {
    EventDate findById(int id);
    List<EventDate> findAll();
}

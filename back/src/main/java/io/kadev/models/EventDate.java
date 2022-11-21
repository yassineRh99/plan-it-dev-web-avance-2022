package io.kadev.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Event event = new Event();
    private Date date_of_event;

}
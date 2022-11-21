package io.kadev.models;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String address_of_location;
    private String description;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<EventDate> eventDates = Arrays.asList();
    
    public Event(String t,String aol,String d){
    	this.title = t;
    	this.address_of_location = aol;
    	this.description = d;
    }
}

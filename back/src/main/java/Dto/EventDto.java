package Dto;

import io.kadev.models.EventDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class EventDto {
    private String title;
    private String address_of_location;
    private String description;
    private List<EventDate> eventDates;
}

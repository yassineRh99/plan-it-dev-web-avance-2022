import { Component, OnInit } from '@angular/core';
import { EventService } from 'src/app/core/services/event.service';


@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss']
})
export class EventsComponent implements OnInit {

  allEvents: any
  decoded: any = {}

  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    
    this.eventService.getAllEvents().subscribe(
      data => {
        this.allEvents = data
      }
    )
  }

}

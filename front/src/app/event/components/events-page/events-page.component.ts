import { Component, OnInit } from '@angular/core';
import { EventService } from 'src/app/core/services/event.service';

@Component({
  selector: 'app-events-page',
  templateUrl: './events-page.component.html',
  styleUrls: ['./events-page.component.scss']
})
export class EventsPageComponent implements OnInit {

  allEvents: any

  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    this.eventService.getAllEvents().subscribe(
      data => {
        this.allEvents = data
      },
    )
  }

}

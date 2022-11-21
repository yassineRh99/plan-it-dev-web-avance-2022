import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventRoutingModule } from './event-routing.module';
import { EventsPageComponent } from './components/events-page/events-page.component';



@NgModule({
  declarations: [
    EventsPageComponent
  ],
  imports: [
    CommonModule,
    EventRoutingModule
  ],
  exports: [
  ]
})

export class EventModule { }

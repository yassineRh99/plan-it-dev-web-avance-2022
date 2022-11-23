import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { EventsComponent } from './components/dashboard/events/events.component';
import { UsersComponent } from './components/dashboard/users/users.component';
import { AddEventComponent } from './components/dashboard/add-event/add-event.component';



@NgModule({
  declarations: [
    DashboardComponent,
    EventsComponent,
    UsersComponent,
    AddEventComponent  ],
  imports: [
    CommonModule,
    DashboardRoutingModule
  ],
  exports: [
  ]
})

export class DashboardModule { }

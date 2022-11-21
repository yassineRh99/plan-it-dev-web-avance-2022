import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { EventsComponent } from './components/dashboard/events/events.component';
import { UsersComponent } from './components/dashboard/users/users.component';



@NgModule({
  declarations: [
    DashboardComponent,
    EventsComponent,
    UsersComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule
  ],
  exports: [
  ]
})

export class DashboardModule { }

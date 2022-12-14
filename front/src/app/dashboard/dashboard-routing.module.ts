import { NgModule } from '@angular/core';

import { Routes } from '@angular/router';
import { RouterModule } from '@angular/router';
import { AuthGuard } from '../core/guards/auth.guard';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { EventsComponent } from './components/dashboard/events/events.component';
import { UsersComponent } from './components/dashboard/users/users.component';
import { AddEventComponent } from './components/dashboard/add-event/add-event.component';

const routes: Routes = [
    { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard],
    children:[
        {path: 'events', component: EventsComponent }, 
        {path: 'users', component: UsersComponent }, 
        {path: 'add-event', component: AddEventComponent }, 
      ] }
]

@NgModule({
    imports: [
        RouterModule.forChild(routes)
    ],
    exports: [
        RouterModule
    ]
})
export class DashboardRoutingModule { }

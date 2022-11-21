import { NgModule } from '@angular/core';

import { Routes } from '@angular/router';
import { RouterModule } from '@angular/router';
import { AuthGuard } from '../core/guards/auth.guard';
import { EventsPageComponent } from './components/events-page/events-page.component';

const routes: Routes = [
    { path: 'events', component: EventsPageComponent, canActivate: [AuthGuard] }
]

@NgModule({
    imports: [
        RouterModule.forChild(routes)
    ],
    exports: [
        RouterModule
    ]
})
export class EventRoutingModule { }

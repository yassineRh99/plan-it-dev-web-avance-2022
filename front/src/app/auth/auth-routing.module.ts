import { NgModule } from '@angular/core';

import { Routes } from '@angular/router';
import { RouterModule } from '@angular/router';
import { LoginRegisterGuard } from '../core/guards/login-register.guard';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
    { path: 'login', component: LoginComponent, canActivate: [LoginRegisterGuard] }
]

@NgModule({
    imports: [
        RouterModule.forChild(routes)
    ],
    exports: [
        RouterModule
    ]
})
export class AuthRoutingModule { }

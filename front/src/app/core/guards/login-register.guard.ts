import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { TokenService } from './../services/token.service';

@Injectable({providedIn: 'root'})
export class LoginRegisterGuard implements CanActivate {

    constructor(
        private router: Router,
        private tokenService: TokenService
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if(!this.tokenService.isLogged()){
            return true;
        }
        return this.router.navigateByUrl('/dashboard');
    }
}
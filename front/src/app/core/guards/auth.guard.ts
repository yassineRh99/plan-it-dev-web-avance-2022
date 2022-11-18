import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { AuthService } from './../services/auth.service';
import { TokenService } from './../services/token.service';

@Injectable({providedIn: 'root'})
export class AuthGuard implements CanActivate {

    constructor(
        private router: Router,
        private tokenService: TokenService
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if(this.tokenService.isLogged()){
            return true;
        }
        //ajouter la route du formulaire d'authentification
        return this.router.navigateByUrl('login');
    }
}
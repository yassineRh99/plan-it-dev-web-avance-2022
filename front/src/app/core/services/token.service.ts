import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  saveToken(token: string): void {
    localStorage.setItem("planit_jwt",token);
  }

  isLogged(): boolean{
    const token = localStorage.getItem("access_token");
    return !!token
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from './../../../environments/environment';
import { Observable } from 'rxjs';
import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient,private tokenService: TokenService) { }

  login(username: string, password: string): Observable<any>{
    return this.httpClient.post<string>(`${environment.baseUrl}/login?username=${username}&password=${password}`, null);
  }

  register(formValue: {username: string, email: string, age: number, gender: string, password: string}): Observable<any>{
    console.log(formValue);
    return this.httpClient.post<any>(`${environment.baseUrl}/register`,formValue);
  }

  logout(): void{
    this.tokenService.deleteToken();
    window.location.reload();
  }

}

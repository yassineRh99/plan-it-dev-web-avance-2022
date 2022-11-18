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

  logout(): void{
    this.tokenService.deleteToken();
  }

}

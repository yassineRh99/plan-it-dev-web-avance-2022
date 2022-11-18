import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from './../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private jwt!:string;

  constructor(private httpClient: HttpClient) { }

  login(username: string, password: string): boolean{
    this.httpClient.post<string>(`${environment.baseUrl}/login?username=${username}&password=${password}`,null)
        .subscribe((data)=>this.jwt=data);
    if(this.jwt.length==0){
      return false;
    }else{
      return true;
    }
  }

  getToken(): string{
    return this.jwt;
  }

}

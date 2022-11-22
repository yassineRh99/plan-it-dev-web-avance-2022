import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private httpClient: HttpClient) { }

  getAllUsers(): Observable<any> {
    return this.httpClient.get(`${environment.baseUrl}/users`);
  }

  confirmUser(id: number): Observable<any> {
    return this.httpClient.put<any>(`${environment.baseUrl}/confirm?userId=${id}`, null);
  }

  deleteUser(id: number) {
    return this.httpClient.delete<any>(`${environment.baseUrl}/remove_user?userId=${id}`);
  }

}

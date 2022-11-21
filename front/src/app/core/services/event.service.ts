import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from './../../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class EventService {

  constructor(private httpClient: HttpClient) { }

  getAllEvents(): Observable<any>{
    
    return this.httpClient.get(`${environment.baseUrl}/events`);
  }

}

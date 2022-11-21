import { Component, OnInit } from '@angular/core';

export interface Todo{
  id: number; 
  texte: string;
  actif: boolean;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  lesTodos: Array<Todo> = []; 
  title = 'PlanIT';
  ngOnInit(): void {
    this.lesTodos=[{"id":1,"texte":"lait","actif":false},{"id":2,"texte":"beurre","actif":false}];
 }
}

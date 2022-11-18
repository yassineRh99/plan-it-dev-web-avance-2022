import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  //il faut passer le username et le password en arguments (depuis le formulaire)
  onLogin() {
    console.log("clicked");
  }

}

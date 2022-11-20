import { Component, OnInit } from '@angular/core';
import { AuthService } from './../../../core/services/auth.service';
import { TokenService } from './../../../core/services/token.service';
import { Router } from '@angular/router';

import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

 loginForm: FormGroup = new FormGroup({
  username: new FormControl(''),
  password: new FormControl(''),
  });

  error: boolean = false

  constructor(
    private authService: AuthService,
    private tokenService: TokenService,
    private router: Router
  ) { }

  ngOnInit(): void {

  }

  //il faut passer le username et le password en arguments (depuis le formulaire)
  onLogin() {
    this.authService.login(this.loginForm.value.username,this.loginForm.value.password).subscribe(
      data => {
        this.tokenService.saveToken(data.access_token);
      },
      error => {
        this.error = true
      }
    )
  }

  closeErrorAlert(){
    this.error = false
  }

  navigateToRegister(){

  }

  onLogout() {
    this.authService.logout();
  }

}

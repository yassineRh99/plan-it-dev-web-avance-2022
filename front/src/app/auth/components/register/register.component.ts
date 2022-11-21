import { Component, OnInit } from '@angular/core';
import { AuthService } from './../../../core/services/auth.service';
import { TokenService } from './../../../core/services/token.service';
import { Router } from '@angular/router';

import { FormGroup, FormControl } from '@angular/forms';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  loginForm: FormGroup = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    });
  
    error: boolean = false

  constructor( private authService: AuthService,
              private tokenService: TokenService,
              private router: Router) { }

  ngOnInit(): void {

    
  }

  onLogin() {
    this.authService.login(this.loginForm.value.username,this.loginForm.value.password).subscribe(
      data => {
        this.tokenService.saveToken(data.access_token);
        this.router.navigateByUrl("/dashboard/events")
      },
      error => {
        this.error = true
      }
    )
  }

  closeErrorAlert(){
    this.error = false
  }

}

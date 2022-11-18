import { Component, OnInit } from '@angular/core';
import { AuthService } from './../../../core/services/auth.service';
import { TokenService } from './../../../core/services/token.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(
    private authService: AuthService,
    private tokenService: TokenService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  //il faut passer le username et le password en arguments (depuis le formulaire)
  onLogin() {
    this.authService.login("ADMIN","1949").subscribe(
      data => {
        this.tokenService.saveToken(data.access_token);
        this.router.navigateByUrl('/');
      }
    )
  }

  onLogout() {
    this.authService.logout();
  }

}

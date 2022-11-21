import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/core/services/auth.service';
import { TokenService } from 'src/app/core/services/token.service';
import jwt_decode from "jwt-decode"

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  decoded: any = {}
  admin: boolean = false


  constructor(private authService: AuthService, private tokenService: TokenService) { }

  ngOnInit(): void {

    const token = this.tokenService.getToken()
    this.decoded = jwt_decode(token)

    const roles = []

    if(this.decoded.roles.includes("ADMINISTRATEUR")){
        roles.push("ADMINISTRATEUR")
        this.admin = true
    }
    if(this.decoded.roles.includes("ADMINISTRATEUR")){
        roles.push("UTILISATEUR")
    }

  }

  onLogout(): void{
    this.authService.logout();
  }

}

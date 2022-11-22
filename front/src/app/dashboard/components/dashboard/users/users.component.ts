import { Component, OnInit } from '@angular/core';
import { UserService } from './../../../../core/services/user.service';
import { TokenService } from './../../../../core/services/token.service';
import jwt_decode from "jwt-decode"

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  allUsers: any;
  admin!: boolean;

  constructor(private userService: UserService, private tokenService: TokenService) { }

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe(
      data => this.allUsers = data
    );
    const token = this.tokenService.getToken()
    const decoded: any = jwt_decode(token)

    const roles = []

    if (decoded.roles.includes("ADMINISTRATEUR")) {
      roles.push("ADMINISTRATEUR")
      this.admin = true
    }
    if (decoded.roles.includes("ADMINISTRATEUR")) {
      roles.push("UTILISATEUR")
    }
  }

  onConfirm(id: number) {
    this.userService.confirmUser(id).subscribe(
      d => {
        this.userService.getAllUsers().subscribe(
          data => this.allUsers = data
        );
      }
    );
  }

  onRemove(id: number) {
    this.userService.deleteUser(id).subscribe(
      d => {
        this.userService.getAllUsers().subscribe(
          data => this.allUsers = data
        );
      }
    );
  }

}

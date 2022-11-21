import { Component, OnInit } from '@angular/core';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/core/services/auth.service';
import { Router } from '@angular/router';
import { tap } from 'rxjs/operators';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  error: boolean = false;
  registerForm!: FormGroup;

  constructor(
    private router: Router,
    private authService: AuthService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      username: [null, Validators.required],
      email: [null, Validators.required],
      age: [null, Validators.required],
      gender: ['homme', Validators.required],
      password: [null, Validators.required]
    }, {
      updateOn: 'blur'
    }
    );
  }

  onRegister(): any {
    if (this.registerForm.valid) {
      this.authService.register(this.registerForm.value).pipe(
        tap(() => {
          this.router.navigateByUrl('/login')
        })
      ).subscribe((data)=>console.log(data), err=>this.error=true)
    } else {
      this.error = true;
      return false;
    }
  }

  closeErrorAlert() {
    this.error = false
  }

}

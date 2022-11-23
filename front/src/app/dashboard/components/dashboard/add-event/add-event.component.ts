import { Component, OnInit } from '@angular/core';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.scss']
})
export class AddEventComponent implements OnInit {

  addEventForm!: FormGroup;


  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.addEventForm = this.formBuilder.group({
      title: [null, Validators.required],
      address: [null, Validators.required],
      description: [null, Validators.required],
    }, {
      updateOn: 'blur'
    }
    );
  }

  onAddEvent(){
    console.log("Hello")
    console.log(this.addEventForm.value)
  }

}

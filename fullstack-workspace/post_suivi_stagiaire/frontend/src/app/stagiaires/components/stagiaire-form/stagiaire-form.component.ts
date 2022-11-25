import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-stagiaire-form',
  templateUrl: './stagiaire-form.component.html',
  styleUrls: ['./stagiaire-form.component.scss']
})
export class StagiaireFormComponent implements OnInit {

  public stagiaireForm: FormGroup = new FormGroup({
    firstName : new FormControl('', Validators.required),
    lastName : new FormControl('', Validators.required),
    email : new FormControl('', [Validators.email, Validators.required]),
    phoneNumber : new FormControl(''),
    birthDate : new FormControl(new Date())

  })  

  constructor() { }

  ngOnInit(): void {
  }

  public onSubmit(){
    console.warn(this.stagiaireForm.value)
  }

}

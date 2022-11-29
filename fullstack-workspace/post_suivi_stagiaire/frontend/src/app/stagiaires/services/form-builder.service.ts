import { Inject, Injectable } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Stagiaire } from 'src/app/core/models/stagiaire';
import { DateAdapter, MAT_DATE_LOCALE } from '@angular/material/core'; // Un adaptateur pour les dates et les locales (langues)

@Injectable({
  providedIn: 'root'
})
export class FormBuilderService {

  private form!: FormGroup; 
  private stagiaire: Stagiaire = new Stagiaire() ;

  constructor(
    private formBuilder :  FormBuilder,
    private adapter: DateAdapter<any>,
    @Inject(MAT_DATE_LOCALE) private locale: string
  ) { 
    this.locale = 'fr';
    this.adapter.setLocale(this.locale);
  }

  public getForm() : FormGroup {

    return this.form;

  }

  public build(): FormBuilderService{

    this.form = this.formBuilder.group({

      lastName:[
        this.stagiaire.getLastName(),
        [
          Validators.required
        ]
      ],
      firstName:[
        this.stagiaire.getFirstName(),
        [
          Validators.required
        ]
      ],
      email: [
        this.stagiaire.getEmail(), 
        [
          Validators.email,
          Validators.required
        ]
      ],
      phoneNumber: [
        this.stagiaire.getPhoneNumber(),
        [
          Validators.pattern("^[+]?[(]?[0-9]{3}[)]?[-\s.]?[0-9]{3}[-\s.]?[0-9]{4,6}$")
        ]
      ],
      birthDate: [
        this.stagiaire.getBirthDate() !== null ? this.stagiaire.getBirthDate() :  ''
      ]      
      

    })

    return this

  }


}


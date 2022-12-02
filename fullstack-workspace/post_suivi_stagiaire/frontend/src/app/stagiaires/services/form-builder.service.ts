import { Inject, Injectable } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { Stagiaire } from 'src/app/core/models/stagiaire';
import { DateAdapter, MAT_DATE_LOCALE } from '@angular/material/core'; // Un adaptateur pour les dates et les locales (langues)

@Injectable({
  providedIn: 'root'
})
export class FormBuilderService {

  private form!: FormGroup; 
  private stagiaire: Stagiaire = new Stagiaire();
  private updateMode: boolean = false;


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
  

  public build(stagiaire : Stagiaire): FormBuilderService{
    console.log(stagiaire.getId())

    if(stagiaire.getId() > 0) {
      this.updateMode = true;
    }

    this.stagiaire = stagiaire;

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

    //Ajoute un contrôle avec la valeur de l'id du Stagiaire donc ... form.value vaudra {id:1, ....}
    if(this.updateMode){

      const idControl : AbstractControl = new FormControl(stagiaire.getId());
      this.form.addControl('id', idControl);

    }
    return this
      
  }


}


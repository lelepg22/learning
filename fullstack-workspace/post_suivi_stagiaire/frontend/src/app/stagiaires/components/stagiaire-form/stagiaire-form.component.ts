import { Component, Inject, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Stagiaire } from 'src/app/core/models/stagiaire';
import { StagiaireService } from 'src/app/core/services/stagiaire.service';
import { StagiaireDto } from '../../dto/stagiaire-dto';
import { FormBuilderService } from '../../services/form-builder.service';



@Component({
  selector: 'app-stagiaire-form',
  templateUrl: './stagiaire-form.component.html',
  styleUrls: ['./stagiaire-form.component.scss'],
})
export class StagiaireFormComponent implements OnInit {

  public stagiaire : Stagiaire = new Stagiaire ();

  public stagiaireForm!: FormGroup;
  

  constructor( 

    private serviceStagiaires: StagiaireService, 
    private formBuilderService: FormBuilderService, 
    private router: Router
    

    ) { }

  ngOnInit(): void {

    this.stagiaireForm = this.formBuilderService.build().getForm()
  }


  // Méthode "helper"  
 /**
   * Returns a list of form controls
   * @usage In template : c['lastName'] 
   * instead of stagiareForm.controls['lastName']
   */
  public get c(): {[key: string]: AbstractControl} {

    return this.stagiaireForm.controls;
  }


  public onSubmit(){

    const stagiaireDto : StagiaireDto = new StagiaireDto( this.stagiaireForm.value);   

    //console.warn(this.stagiaireForm.value)
    console.warn(stagiaireDto)

    this.serviceStagiaires.addStagiaire(stagiaireDto)
    .subscribe(() => {
      this.goHome();
    });
    
  }

  public goHome(): void {
    this.router.navigate(['/', 'home']);
  }


}

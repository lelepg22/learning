import { Component, Inject, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Params, Router, UrlSegment } from '@angular/router';
import { timeStamp } from 'console';
import { ConnectableObservable } from 'rxjs';
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

  public addMode: boolean = true;
  

  constructor( 

    private stagiaireService: StagiaireService, 
    private formBuilderService: FormBuilderService, 
    private router: Router,
    private route: ActivatedRoute
    

    ) { }

  ngOnInit(): void {

    const data : any = this.route.snapshot.data;

    console.log(data.form.value.id !== 0, data.form);

    (data.form.value.id !== 0) ? this.addMode = false : this.addMode = true

    this.stagiaireForm = data.form; 
    
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
    if(this.addMode){

      this.stagiaireService.addStagiaire(stagiaireDto)
      .subscribe(() => {
        this.goHome();
      });

    }
    else{
      console.log(this.stagiaireForm.value)
      this.stagiaireService.update(stagiaireDto.toStagiaire())
      .subscribe(() => this.goHome())
    }
    
  }

  public goHome(): void {
    this.router.navigate(['/', 'home']);
  }


}

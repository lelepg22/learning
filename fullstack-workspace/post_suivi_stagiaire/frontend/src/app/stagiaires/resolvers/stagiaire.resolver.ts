import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';

import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot,
  ActivatedRoute
} from '@angular/router';
import { Observable, of} from 'rxjs';
import { Stagiaire } from 'src/app/core/models/stagiaire';
import { StagiaireService } from 'src/app/core/services/stagiaire.service';
import { FormBuilderService } from '../services/form-builder.service';
import { map, take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class StagiaireResolver implements Resolve<FormGroup> {
  

  public constructor(

      private route: ActivatedRoute,
      private stagiaireService : StagiaireService,
      private formBuilderService : FormBuilderService

  ){

  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<FormGroup> {

    const id: number = +route.paramMap.get('id')!;

    let form : FormGroup;

    if(id == 0){
    
    form = this.formBuilderService.build(new Stagiaire()).getForm();
    return of(form)

    }

    else{

      return this.stagiaireService.findOne(id)
      .pipe(
        take(1),
        map(
          (oStagiaire: Stagiaire) => {
            return this.formBuilderService.build(oStagiaire).getForm();
          })
      )      
    }

  }
}

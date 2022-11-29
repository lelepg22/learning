import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

//Forms UI

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import  { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDatepickerModule } from '@angular/material/datepicker';






@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ], 
  exports:[
    ...MaterialUiModule.materialsModules // "..." SPREAD OPERATOR convert un tableau dans une list de element
  ]

})
export class MaterialUiModule {

  public static materialsModules = [

    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatDatepickerModule,

  ]

 }

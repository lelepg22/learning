import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StagiaireTableComponent } from './stagiaires/components/stagiaire-table/stagiaire-table.component';
import { ReactiveFormsModule } from '@angular/forms';

import { StagiaireFilterComponent } from './stagiaires/components/stagiaire-filter/stagiaire-filter.component';
import { InitialsPipe } from './shared/pipes/initials.pipe';
import { StagiaireDetailComponent } from './stagiaires/components/stagiaire-detail/stagiaire-detail.component';
import { HiddenDirective } from './shared/directives/hidden.directive';
import { BubbleDirective } from './shared/directives/bubble.directive';
import { HttpClientModule} from '@angular/common/http';
import { StagiaireFormComponent } from './stagiaires/components/stagiaire-form/stagiaire-form.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { SharedModule } from './shared/shared.module';

@NgModule({
  declarations: [
    AppComponent,
    StagiaireTableComponent,    
    StagiaireFilterComponent, 
    InitialsPipe, 
    StagiaireDetailComponent, 
    HiddenDirective, 
    BubbleDirective, 
    StagiaireFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,    
    BrowserAnimationsModule,
    SharedModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

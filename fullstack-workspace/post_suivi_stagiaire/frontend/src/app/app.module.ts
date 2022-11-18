import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StagiaireTableComponent } from './stagiaires/components/stagiaire-table/stagiaire-table.component';

import { StagiaireFilterComponent } from './stagiaires/components/stagiaire-filter/stagiaire-filter.component';
import { InitialsPipe } from './shared/pipes/initials.pipe';
import { StagiaireDetailComponent } from './stagiaires/components/stagiaire-detail/stagiaire-detail.component';
import { HiddenDirective } from './shared/directives/hidden.directive';

@NgModule({
  declarations: [
    AppComponent,
    StagiaireTableComponent,    
    StagiaireFilterComponent, InitialsPipe, StagiaireDetailComponent, HiddenDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

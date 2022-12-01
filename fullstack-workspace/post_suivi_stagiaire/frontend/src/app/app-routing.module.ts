
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StagiaireDetailComponent } from './stagiaires/components/stagiaire-detail/stagiaire-detail.component';
import { StagiaireFormComponent } from './stagiaires/components/stagiaire-form/stagiaire-form.component';
import { StagiaireTableComponent } from './stagiaires/components/stagiaire-table/stagiaire-table.component';



@NgModule({
  imports: [RouterModule.forRoot(AppRoutingModule.routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

  public static routes: Routes =  [

    {
      path: "", 
      redirectTo:"home",  // Redirige vers un autre chemin ici "home" 
      pathMatch: "full"
    },

    {
      path: "home",
      component: StagiaireTableComponent
    },

    {
      path:"stagiaire/add",
      component:StagiaireFormComponent
    },
    {
      path: "stagiaire/:id", // ":" parameter uri from the route
      component: StagiaireDetailComponent
    },

    {
      path:"**",  //Wild card
      redirectTo: "home",
      pathMatch: "full"
    },
    
  ];

 }

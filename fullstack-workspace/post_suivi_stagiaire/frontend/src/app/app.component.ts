import { Component } from '@angular/core';
import { Stagiaire } from './core/models/stagiaire';
import { StagiaireService } from './core/services/stagiaire.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  public title = 'Suivi des stagiaires';

  public stagiares: Array<Stagiaire> = this.stagiareService.getStagiares();

  public inputType: string = 'password';  

  public constructor(
    private stagiareService: StagiaireService
  ){

  }

  public toggleTitle() : void{
    if(this.title === 'Suivi des stagiaires'){
      this.title = 'Hello Angular'
    }
    else{
      this.title = 'Suivi des stagiaires'
    }
  }

  public addStagiaire(): void {
    //this.stagiares.push('Dummy stagiaire');
  }

  public showPassword(): void {
    if (this.inputType === 'password') {
      this.inputType = 'text';
      setTimeout(
        () => {
          this.inputType = 'password'
        },
        800
      )
    } else {
      this.inputType = 'password';
    }
  }

  
}

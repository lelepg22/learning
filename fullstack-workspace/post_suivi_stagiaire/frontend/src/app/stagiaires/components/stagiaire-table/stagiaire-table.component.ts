import { Component, OnInit} from '@angular/core';
import { Stagiaire } from 'src/app/core/models/stagiaire';
import { StagiaireService } from 'src/app/core/services/stagiaire.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-stagiaire-table',
  templateUrl: './stagiaire-table.component.html',
  styleUrls: ['./stagiaire-table.component.scss']
})
export class StagiaireTableComponent implements OnInit {

  public stagiaire: Stagiaire = new Stagiaire();
  public stagiaires: Array<Stagiaire> = [];
  public stopDate: Date | null = new Date(1977,11,31);
  public card: boolean = false;

  public stagiairesOver: Array<Stagiaire> =
   this.serviceStagiaires
   .getStagiares()
   .filter(x => x.getBirthDate() > this.stopDate!);


  constructor(private serviceStagiaires: StagiaireService) { }

  ngOnInit(): void {

    this.stagiaires = this.serviceStagiaires.getStagiares();
    
  }

  public onRemove(stagiaire: Stagiaire): void{
    console.log(`L'utilisateur souhaite supprimer ${stagiaire.getLastName()}`)
    this.serviceStagiaires.delete(stagiaire);
  }

  public getStagiairesVisible(params:Date | null): number {
    
    return this.serviceStagiaires.getStagiairesVisible(params);

  }

  public filterChanged(event: Date | null): void{
    console.log(`Filter has changed to : ${event}`)
    this.stopDate = event;
    this.getStagiairesVisible(event);
  }

  public changeView(stagiaire: Stagiaire): boolean{
    if(this.stopDate === null){
      return true
    }
    if(this.stopDate.getDate() === 31){
      return stagiaire.getBirthDate() > this.stopDate;
    }

    return stagiaire.getBirthDate() < this.stopDate;
  }

  public selectStagiaire(stagiaire: Stagiaire): void{
    
    if(this.card === false){
      this.card = true;
      this.stagiaire = stagiaire;
    }
    
    // (this.card !== true) ?  this.card = true : this.card = true;

    // (this.card === true && this.stagiaire.getFirstName().length > 0) ?
    //  this.stagiaire = this.stagiaire : this.stagiaire = stagiaire;
   
  }

  public toggleCard() : void{

    this.stagiaire = new Stagiaire();

    this.card = !this.card;    

  }

}

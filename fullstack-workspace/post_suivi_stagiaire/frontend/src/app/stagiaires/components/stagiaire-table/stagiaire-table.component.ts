import { Component, OnInit } from '@angular/core';
import { Stagiaire } from 'src/app/core/models/stagiaire';
import { StagiaireService } from 'src/app/core/services/stagiaire.service';

@Component({
  selector: 'app-stagiaire-table',
  templateUrl: './stagiaire-table.component.html',
  styleUrls: ['./stagiaire-table.component.scss']
})
export class StagiaireTableComponent implements OnInit {

  public stagiaires: Array<Stagiaire> = [];

  constructor(private serviceStagiaires: StagiaireService) { }

  ngOnInit(): void {

    this.stagiaires = this.serviceStagiaires.getStagiares();
    
  }

  public onRemove(stagiaire: Stagiaire): void{
    console.log(`L'utilisateur souhaite supprimer ${stagiaire.getLastName()}`)
    this.serviceStagiaires.delete(stagiaire);
  }

}

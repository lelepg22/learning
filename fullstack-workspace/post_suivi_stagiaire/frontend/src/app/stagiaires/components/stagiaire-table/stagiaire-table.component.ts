import { Component, OnInit} from '@angular/core';
import { Stagiaire } from 'src/app/core/models/stagiaire';
import { StagiaireService } from 'src/app/core/services/stagiaire.service';
import { HandleDetailService } from 'src/app/shared/directives/handle-detail.service';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-stagiaire-table',
  templateUrl: './stagiaire-table.component.html',
  styleUrls: ['./stagiaire-table.component.scss']
})
export class StagiaireTableComponent implements OnInit {

  public stagiaire: Stagiaire = new Stagiaire();
  public stagiaires: Array<Stagiaire> = [];
  public stopDate: Date | null = new Date(1977,11,31);
  public card$: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(true);

  public bubbleConfig: any = {
      height: '2em',          
      width: '2em',
      lineHeight: '2em',
      backgroundColor:'rgba(20, 20, 200, .5)', //when manipulating css instead of - use camelCase like background-color
      borderRadius: '50%',
      fontWeight: 'bold',
      verticalAlign: 'middle',
      textAlign: 'center',
      display: 'inline-block'
  }
  

  public stagiairesOver: Array<Stagiaire> =
   this.serviceStagiaires
   .getStagiares(null)
   .filter(x => x.getBirthDate() > this.stopDate!);


  constructor(
    private serviceStagiaires: StagiaireService,
    private handleDetailService: HandleDetailService
    ) { }

  ngOnInit(): void {

    this.serviceStagiaires.findAll().subscribe((stagiaire: Stagiaire[])=>{
      this.stagiaires = stagiaire;
      this.stagiaires = this.serviceStagiaires.getStagiares(null);
    }
    )

    this.card$ = this.handleDetailService.isDetailHidden;

        
    
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
   
      this.stagiaire = stagiaire;

      this.handleDetailService.setIsDetailHidden(false);
      
        
  }  

}

import { Injectable } from '@angular/core';
import { Stagiaire } from '../models/stagiaire';

@Injectable({
  providedIn: 'root'
})
export class StagiaireService {

  private stagiaires: Array<Stagiaire> = [];

  constructor() { 
    this.feedIt();  
  }

  private feedIt(): void {
    let stagiaire:  Stagiaire = new Stagiaire();
    stagiaire.setId(1);
    stagiaire.setLastName("Gaglianone");
    stagiaire.setFirstName("Alexandre");
    stagiaire.setPhoneNumber("+330765654");
    stagiaire.setBirthDate(new Date(1977, 3,30));
    stagiaire.setEmail("alex.gaglianone@gmail.com")

    this.stagiaires.push(stagiaire);

    stagiaire = new Stagiaire();
    stagiaire.setId(2);
    stagiaire.setLastName("Marcel");
    stagiaire.setFirstName("Jean");
    stagiaire.setPhoneNumber("+330826624");
    stagiaire.setBirthDate(new Date(1988, 3,10));
    stagiaire.setEmail("ajeanma@gmail.com")

    this.stagiaires.push(stagiaire);

    stagiaire = new Stagiaire();
    stagiaire.setId(3);
    stagiaire.setLastName("Willow");
    stagiaire.setFirstName("Johnny");
    stagiaire.setPhoneNumber("+330826624");
    stagiaire.setBirthDate(new Date(1965, 3,10));
    stagiaire.setEmail("johnny@gmail.com")

    this.stagiaires.push(stagiaire);

    stagiaire = new Stagiaire();
    stagiaire.setId(4);
    stagiaire.setLastName('Aubert');
    stagiaire.setFirstName('Jean-Luc');
    stagiaire.setPhoneNumber('+(33)6 15 15 15 15');
    stagiaire.setEmail('jla.webprojet@gmail.com');
    stagiaire.setBirthDate(new Date(1968, 3, 30));

    this.stagiaires.push(stagiaire);

  }

  public getStagiares(): Array<Stagiaire>{

      return this.stagiaires;

  }
  
  public delete(stagiaire: Stagiaire): void{

    console.log(`Le composant souhaite que on delete ${stagiaire.getLastName()} stagiaire`)
    
    // this.stagiaires = this.stagiaires
    //   .filter(x => x != stagiaire);
    
    // NE REFRACHIE PAS LE COMPONENT

    console.log(this.stagiaires);

    // or
    this.stagiaires.splice(this.stagiaires.indexOf(stagiaire),1);

    //or
    // const stagiaireIndex: number = this.stagiaires.fixIndex((obj: Stagiaire) => obj.getId() === stagiaire.getId())
    // this.stagiaires.splice(stagiaireIndex,1);

  }

  public getStagiairesVisible(params:Date | null): number{
    
    if(params === null){
      return this.stagiaires.length;
    }
    
    else if(params.getDate() === 31)
    {
      return this.stagiaires
      .filter((x: Stagiaire) => x.getBirthDate() > params) // Si {} a la function fleche il faut un return!
      .length
    }
    else{
      return this.stagiaires
      .filter((x: Stagiaire) => x.getBirthDate() < params) // Si {} a la function fleche il faut un return!
      .length

    }

  }


}

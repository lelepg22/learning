import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, map, take } from 'rxjs/operators'
import { StagiaireDto } from 'src/app/stagiaires/dto/stagiaire-dto';
import { environment } from 'src/environments/environment';
import { Stagiaire } from '../models/stagiaire';

@Injectable({
  providedIn: 'root'
})
export class StagiaireService {
  private stagiaire : Stagiaire = new Stagiaire();
  private stagiaires: Array<Stagiaire> = [];
  private controllerUrl : string  =  `${environment.apiBaseUrl}/trainee`;

  constructor(
    private httpClient: HttpClient
  ) {

  }

  public findAll(): Observable<Stagiaire[]> {

    return this.httpClient.get<any>(
      this.controllerUrl
    )
      .pipe(
        take(1),
        map((stagiaires: any[]) => {
          return this.stagiaires = stagiaires.map(
            (inputStagiaire: any) => {

              const stagiaire: Stagiaire = new Stagiaire();
              stagiaire.setId(inputStagiaire.id);
              stagiaire.setLastName(inputStagiaire.lastName);
              stagiaire.setFirstName(inputStagiaire.firstName);
              stagiaire.setEmail(inputStagiaire.email);
              stagiaire.setPhoneNumber(inputStagiaire.phoneNumber);
              if(inputStagiaire.birthDate != null){
                console.log(inputStagiaire.birthDate)
              stagiaire.setBirthDate(new Date(inputStagiaire.birthDate));}
              return stagiaire;

            }
          )
        }
        )
      )

  }
 

  public getStagiares(stagiaire : Stagiaire | null | any): Array<Stagiaire> {
    (stagiaire) ? this.stagiaires.push(stagiaire) : this.stagiaires;
    

    this.stagiaires;
    return this.stagiaires;

  }

  public delete(stagiaire: Stagiaire) : Observable<HttpResponse<any>> {
    // this.httpClient.delete(`${this.controllerUrl}/delete/${stagiaire.getId()}`,
    // {
    //   observe: 'response'
    // })

    
    console.log(this.stagiaires);

    // or
    this.stagiaires.splice(this.stagiaires.indexOf(stagiaire), 1);
    
    return this.httpClient.delete(`${this.controllerUrl}/delete/${stagiaire.getId()}`, {
      observe: "response"
    });

    console.log(`Le composant souhaite que on delete ${stagiaire.getLastName()} stagiaire`);

    // this.stagiaires = this.stagiaires
    //   .filter(x => x != stagiaire);

    // NE REFRACHIE PAS LE COMPONENT


    //or
    // const stagiaireIndex: number = this.stagiaires.fixIndex((obj: Stagiaire) => obj.getId() === stagiaire.getId())
    // this.stagiaires.splice(stagiaireIndex,1);

  }

  public getStagiairesVisible(params: Date | null): number {

    if (params === null) {
      console.log(this.stagiaires)
      return this.stagiaires.length;
    }

    else if (params.getDate() === 31) {
      return this.stagiaires
        .filter((x: Stagiaire) => x.getBirthDate() > params) // Si {} a la function fleche il faut un return!
        .length
    }
    else {
      return this.stagiaires
        .filter((x: Stagiaire) => x.getBirthDate() < params) // Si {} a la function fleche il faut un return!
        .length

    }

  }

  public addStagiaire(stagiaire :StagiaireDto): Observable<Stagiaire>{

    return this.httpClient.post<StagiaireDto>(this.controllerUrl, stagiaire)
    .pipe(
      // take + map : res Json => Stagiaire
      take(1),
          map((stagiaireDto: StagiaireDto) => {
            const stagiaire: Stagiaire = new Stagiaire();
            stagiaire.setId(stagiaireDto.id!);
            stagiaire.setLastName(stagiaireDto.lastName);
            stagiaire.setFirstName(stagiaireDto.firstName);
            stagiaire.setBirthDate(new Date(stagiaireDto.birthDate));
            stagiaire.setPhoneNumber(stagiaireDto.phoneNumber);
            stagiaire.setEmail(stagiaireDto.email);
            return stagiaire;
          }))

  }

  public findOne(id: number): Observable<Stagiaire> {

    return this.httpClient.get<any>(
      `${this.controllerUrl}/${id}`
      )
      .pipe(
        take(1),
        map(
          (inputStagiaire: any) => {

            const stagiaire: Stagiaire = new Stagiaire();
            stagiaire.setId(inputStagiaire.id);
            stagiaire.setLastName(inputStagiaire.lastName);
            stagiaire.setFirstName(inputStagiaire.firstName);
            stagiaire.setEmail(inputStagiaire.email);
            stagiaire.setPhoneNumber(inputStagiaire.phoneNumber);
            stagiaire.setBirthDate(new Date(inputStagiaire.birthDate));
            return stagiaire;
          }        
        )
      )
  }

  // public add(stagiaire: Stagiaire): void {
  //   // hack to provoke error
  //   stagiaire.setFirstName('')
  //   // end hack here
  //   console.log('add stagiaire asked: ', stagiaire)
  //   this.httpClient.post(this.controllerBaseUrl, stagiaire)
          // .pipe(
          //   // take + map : res Json => Stagiaire
          //   catchError((error: HttpErrorResponse) => {
          //     console.log("Stagiaire not created:", error)
          //     return throwError(() => new Error("Not Created"))
          //   })
          // )
          // .subscribe(res => console.log("Response: ", res))
  // }


}

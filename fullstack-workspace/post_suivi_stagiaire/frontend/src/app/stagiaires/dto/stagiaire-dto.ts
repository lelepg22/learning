import { Stagiaire } from "src/app/core/models/stagiaire";

export class StagiaireDto {

    public id?: number;

    public lastName: string = "";

    public firstName: string = "";

    public email: string = ""; 

    public phoneNumber!: string;

    public birthDate!: Date;

    public constructor(formValues: any){
        Object.assign(this, formValues)
    }

    //example dto transformation if needed to fit into correct class

    public toStagiaire() : Stagiaire {

        const stagiaire: Stagiaire = new Stagiaire();
        if(this.id != undefined) 
        stagiaire.setId(this.id);
        stagiaire.setEmail(this.email);
        stagiaire.setFirstName(this.firstName);
        stagiaire.setLastName(this.lastName);
        stagiaire.setPhoneNumber(this.phoneNumber);
        stagiaire.setBirthDate(this.birthDate);   

        return stagiaire;
        
    }



}



import { Pipe, PipeTransform } from '@angular/core';
import { Stagiaire } from 'src/app/core/models/stagiaire';
import { VariationType } from './variant-type';

@Pipe({
  name: 'initials'
})
export class InitialsPipe implements PipeTransform {

  private variant: VariationType | undefined = undefined;

  transform(value: unknown, ...args: any[]): string {
    if (value instanceof Stagiaire) {
      
      if(args[0] !== undefined && args[0] !== null){
        
        if('firstNameFirst' in args[0] || 'full' in args[0]){        
          
        this.variant = args[0]; 

        }
      }// Get the object at index 0 (can be undefined)
      
      return this.getInitials(value, args).toUpperCase();
    
    } else {
      throw new Error(`value is not a valid Stagiaire object`);
    }
  }

  private getInitials(stagiaire: Stagiaire, variation: unknown[]): string {
    
    
    if (this.variant !== undefined && this.variant.firstNameFirst === false) { // 1 ET 1 => true, 1 ET 0 => false, 0 ET 1 => false, 0 ET 0 => false
      
      return this.lastNameFirst(stagiaire);
      
    }
    
    return this.firstNameFirst(stagiaire);
  }

  private firstNameFirst(stagiaire: Stagiaire): string {
    return this.firstName(stagiaire.getFirstName()) + stagiaire.getLastName().charAt(0);
  }

  private lastNameFirst(stagiaire: Stagiaire): string {
    return stagiaire.getLastName().charAt(0) + 
      this.firstName(stagiaire.getFirstName());
  }  

  private firstName(firstName: string): string  {
    if (this.variant && this.variant.full) {
      const dashPosition: number = firstName.indexOf('-');
      if (dashPosition !== -1) {
        return firstName.charAt(0) + firstName.charAt(dashPosition + 1);
      }
    }
    return firstName.charAt(0);
  }  
}



  
// OR need fixing special char detection
  // private getInitials(stagiaire: Stagiaire, arg: string): string{    
    
    // let result : string = "";

    // for(let i: number = 1; i < stagiaire.getFirstName().length; i++){
    //   if(stagiaire.getFirstName()[i] === stagiaire.getFirstName()[i].toUpperCase()){

    //     result = result + stagiaire.getFirstName()[i].toUpperCase();

    //   }      
    // }

    // if(arg == 'reverse'){

    //   result = stagiaire.getLastName()[0].toUpperCase() + result + stagiaire.getFirstName()[0].toUpperCase();

    //   return result;

    // }
    // else{
    
    //   result = stagiaire.getFirstName()[0].toUpperCase() + result + stagiaire.getLastName()[0].toUpperCase();

    //   return result
    // }
      //or stagiaire.getFirstName().charAt(0) + stagiare.getLastName().charAt(0);

  //}
    
  //  CHANGING THE value TYPE IS NOT A GOOD PRACTICE
  // transform(value: Stagiaire, ...args: unknown[]): unknown {
  //   return `${value.getFirstName()[0]}  ${value.getLastName()[0]} `;
  // }



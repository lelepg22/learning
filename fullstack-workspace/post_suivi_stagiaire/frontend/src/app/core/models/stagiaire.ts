import { last } from "rxjs";

export class Stagiaire {

    private id: number = 0;

    private lastName: string = "";

    private firstName: string = "";

    private email: string = "";

    private phoneNumber: string = "";

    private birthDate!: Date;

    //getter & setter

    public getId(): number {
        return this.id;
    }

    public setId(id: number): void{
        this.id = id;
    }

    public getLastName(): string {
        return this.lastName;
    }

    public setLastName(lastName: string): void {
        this.lastName = lastName;
    }

    public getFirstName(): string{
        return this.firstName;        
    }

    public setFirstName(firstName :string): void{
        this.firstName = firstName;
    }

    public getPhoneNumber(){
        return this.phoneNumber;
    }

    public setPhoneNumber(phoneNumber: string): void{
        this.phoneNumber = phoneNumber;
    }

    public getEmail(){
        return this.email;
    }

    public setEmail(email: string): void{
        this.email = email;
    }

    public getBirthDate(): Date {
        return this.birthDate;
    }

    public setBirthDate(birthDate: Date): void {
        this.birthDate = birthDate;
    }
    
}

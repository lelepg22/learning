package poe.model;

import java.time.LocalDate;

public class Trainee{
    //field
    private String firstname;
    private String lastname;
    private LocalDate birthdate;

    //SURCHARGE DE METHODE CONSTRUCTOR, le logiciel choisi la methode avec les numeros de parametres equivalent.
    public Trainee() {
    }

    public Trainee(String firstname, String lastname, LocalDate birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    //getter & setter
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return  "Trainee{" +
                "firstname:'" + firstname + '\'' +
                ", lastname:'" + lastname + '\'' +
                ", birthdate:" + birthdate +
                '}';
    }
}

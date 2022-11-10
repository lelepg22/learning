package poe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class Trainee{
    //field
    private String firstname;
    private String lastname;
    private LocalDate birthdate;

    //SURCHARGE DE METHODE CONSTRUCTOR, le logiciel choisi la methode avec les numeros de parametres equivalent.


    @Override
    public String toString() {
        return  "Trainee{" +
                "firstname:'" + firstname + '\'' +
                ", lastname:'" + lastname + '\'' +
                ", birthdate:" + birthdate +
                '}';
    }
}

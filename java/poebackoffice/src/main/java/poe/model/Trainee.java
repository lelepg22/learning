package poe.model;

import lombok.*;

import java.time.LocalDate;
@Builder
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

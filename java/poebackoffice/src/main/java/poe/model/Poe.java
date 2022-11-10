package poe.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class Poe {

    private String title;
    private LocalDate beginDate;
    private LocalDate endDate;
    private PoeType poeType;

    @Builder.Default
    private List<Trainee> trainees = new ArrayList<>();


    //convenience method
    public void addTrainee(Trainee trainee){

        trainees.add(trainee);

    }
    // extends accepts heritage from trainee and super accepts the parents as well
    public void addTrainees(Collection<? extends Trainee> otherTrainees){

        trainees.addAll(otherTrainees);

    }

    //var args HOWEVER ARGS you want
    public void addTrainees(Trainee... otherTrainees){
        Collections.addAll(trainees, otherTrainees);
    }


    @Override

    public String toString() {

        return "Poe{" +
                "title='" + title + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", poeType=" + poeType +
                '}';

    }

}

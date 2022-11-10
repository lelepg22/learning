package poe.model.play;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import poe.model.Poe;
import poe.model.PoeType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.*;


public class PlayCollectionPoe {

    static List<Poe> poeList;

    @BeforeAll

    static void initData() {
        poeList = List.of(

                new Poe(

                        "Java Fullstack",
                        LocalDate.of(2022, 10, 24),
                        LocalDate.of(2023, 1, 27),
                        PoeType.POEI
                ),

                new Poe(

                        "Java Fullstack",
                        LocalDate.of(2022, 11, 2),
                        LocalDate.of(2023, 2, 3),
                        PoeType.POEC
                ),

                new Poe(

                        "Consultant DevOps",
                        LocalDate.of(2022, 6, 13),
                        LocalDate.of(2022, 9, 16),
                        PoeType.POEC
                ),

                new Poe(

                        "Consultant Cyber Sécurité",
                        LocalDate.of(2021, 9, 13),
                        LocalDate.of(2021, 11, 16),
                        PoeType.POEI
                ),

                new Poe(

                        "Consultant SAP",
                        LocalDate.of(2022, 4, 13),
                        LocalDate.of(2022, 8, 16),
                        PoeType.POEI
                ),

                new Poe(

                        "Consultant BI",
                        LocalDate.of(2022, 9, 24),
                        LocalDate.of(2022, 11, 23),
                        PoeType.POEI
                )


        );

    }

    @Test
    void playWithListPoe() {
        //1. compter les POEI

        System.out.println(poeList);

        long countPoei = poeList.stream()
                .filter(poe -> poe.getPoeType() == PoeType.POEI).count();

        System.out.println(countPoei);

    }

    @Test
    void testAverageDaysPoe() {
        //2. Moyenne de la durée des POE

        double averagePoe = poeList.stream()
                .mapToLong(poe -> ChronoUnit.DAYS.between(poe.getBeginDate(), poe.getEndDate()))
                .average().getAsDouble();
        System.out.println(averagePoe);

        System.out.println(
                (poeList.stream()
                        .mapToLong(data -> data.getEndDate().toEpochDay() - data.getBeginDate().toEpochDay()).sum())
                        / poeList.stream().count()

        );
    }
}
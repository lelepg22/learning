package poe.model.play;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import poe.model.Poe;
import poe.model.PoeType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class PlayCollectionPoe {

    static List<Poe> poeList;

    @BeforeAll

    static void initData() {
        poeList = List.of(
                Poe.builder()
                        .title("Java Fullstack")
                        .beginDate(LocalDate.of(2022, 10, 24))
                        .endDate(LocalDate.of(2023, 1, 27))
                        .poeType(PoeType.POEI)
                        .build(),
                Poe.builder()
                        .title("Java Fullstack")
                        .beginDate(LocalDate.of(2022, 11, 2))
                        .endDate(LocalDate.of(2023, 2, 3))
                        .poeType(PoeType.POEC)
                        .build(),
                Poe.builder()
                        .title("Consultant Devops")
                        .beginDate(LocalDate.of(2022, 6, 13))
                        .endDate(LocalDate.of(2022, 9, 16))
                        .poeType(PoeType.POEC)
                        .build(),
                Poe.builder()
                        .title("Consultant Cyber Sécurité")
                        .beginDate(LocalDate.of(2021, 9, 13))
                        .endDate(LocalDate.of(2021, 11, 16))
                        .poeType(PoeType.POEI)
                        .build(),
                Poe.builder()
                        .title("Consultant SAP")
                        .beginDate(LocalDate.of(2022, 4, 13))
                        .endDate(LocalDate.of(2022, 8, 16))
                        .poeType(PoeType.POEI)
                        .build(),
                Poe.builder()
                        .title("Consultant BI")
                        .beginDate(LocalDate.of(2022, 9, 24))
                        .endDate(LocalDate.of(2022, 11, 23))
                        .poeType(PoeType.POEI)
                        .build()
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
    @Test
    void sortPoe(){

        // NavigableSet<Poe> poeSet = new TreeSet<>(Comparator.reverseOrder());
        // System.out.println(poeSet);

        // List<Poe> poeList1 = new ArrayList<>();
        // Collections.sort(poeList1);

        Comparator<Poe> comparatorPoe = (p1, p2) -> -1; //avec ou SANS typage JAVA DETERMINE les parametre comment Poe

        NavigableSet<Poe> poeSet = new TreeSet<>(comparatorPoe);
        poeSet.addAll(poeList);
        System.out.println(poeSet);

        Comparator<Poe> comparator2 = Comparator.comparing(Poe::getBeginDate);

        NavigableSet<Poe> poeSet2 = new TreeSet<>(comparator2);
        poeSet2.addAll(poeList);
        System.out.println(poeSet2);

        Comparator<Poe> comparator3 = Comparator.comparing(Poe::getBeginDate, Comparator.reverseOrder());

        NavigableSet<Poe> poeSet3 = new TreeSet<>(comparator3);
        poeSet3.addAll(poeList);
        System.out.println(poeSet3);

        Comparator<Poe> comparator4 = Comparator.comparing(Poe::getPoeType, Comparator.reverseOrder()).thenComparing(Poe::getBeginDate);

        NavigableSet<Poe> poeSet4 = new TreeSet<>(comparator4);
        poeSet4.addAll(poeList);
        System.out.println("4" + poeSet4);


    }
}
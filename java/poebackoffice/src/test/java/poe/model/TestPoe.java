package poe.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullSource;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TestPoe {
    @Test

    void testDefaultConstructor(){

        LocalDate beginDate = LocalDate.of(2022,10,17);
        LocalDate endDate = LocalDate.of(2023,1,27);
        PoeType poeType = PoeType.POEI;

        Poe poe = new Poe();
        assertNull(poe.getTitle());
        assertNull(poe.getBeginDate());
        assertNull(poe.getEndDate());
        assertNull(poe.getPoeType());
        assertTrue(poe.getTrainees().isEmpty(), "empty collection");

        poe.setPoeType(poeType);
        poe.setBeginDate(beginDate);
        poe.setEndDate(endDate);
        poe.setTitle("FullStack Java");

        assertEquals("FullStack Java", poe.getTitle());
        assertEquals(LocalDate.of(2023,1,27), poe.getEndDate());
        assertEquals(LocalDate.of(2022,10,17), poe.getBeginDate());
        assertEquals(PoeType.POEI, poe.getPoeType());

        assertInstanceOf(Poe.class, poe);

    }

    @Test

    void testAllArgsConstructor(){

        LocalDate beginDate = LocalDate.of(2022,10,24);
        LocalDate endDate = LocalDate.of(2023,1,27);
        PoeType poeType = PoeType.POEI;
        List<Trainee> trainees = new ArrayList<>();

        Poe poe = new Poe("FullStack Java", beginDate, endDate, poeType, trainees);

        assertEquals(LocalDate.of(2022,10,24), poe.getBeginDate(), "beginDate");
        assertEquals(PoeType.POEI, poe.getPoeType());
        assertEquals(LocalDate.of(2023,1,27), poe.getEndDate());
        assertEquals("FullStack Java", poe.getTitle());
        assertSame(trainees, poe.getTrainees());

        assertInstanceOf(Poe.class, poe);

    }

    @Test

    void toStringTest(){

        LocalDate beginDate = LocalDate.of(2022,10,24);
        LocalDate endDate = LocalDate.of(2023,1,27);
        PoeType poeType = PoeType.POEI;
        List<Trainee> trainees = new ArrayList<>();

        Poe poe = new Poe("FullStack Java", beginDate, endDate, poeType, trainees);

        assertEquals("Poe{" +
                "title='" + poe.getTitle() + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", poeType=" + poeType +
                '}', poe.toString());

    }

    @Test

    void testAddTrainee(){

        Poe poe = Poe.builder()
                .title("Java Fullstack")
                .beginDate(LocalDate.of(2022, 10, 24))
                .endDate(LocalDate.of(2023, 1, 27))
                .poeType(PoeType.POEI)
                .build();

        Trainee trainee =  Trainee.builder()
                .firstname("Johnny")
                .lastname("Clark")
                .build();

        poe.addTrainee(trainee);

    }

    @Test

    void testAddTraineesCollection(){
        Poe poe = Poe.builder()
                .title("Java Fullstack")
                .beginDate(LocalDate.of(2022, 10, 24))
                .endDate(LocalDate.of(2023, 1, 27))
                .poeType(PoeType.POEI)
                .build();

        Trainee trainee1 =  Trainee.builder()
                .firstname("Johnny")
                .lastname("Clark")
                .build();

        Trainee trainee2 =  Trainee.builder()
                .firstname("Michael")
                .lastname("Johnson")
                .build();

        Set<Trainee> trainees = Set.of(trainee1, trainee2);
        poe.addTrainees(trainees);

        assertAll(trainees.stream()
                .map( data -> () -> assertTrue(
                        poe.getTrainees().contains(data),
                        " trainee " + data.getFirstname() + " is in poe trainees ")));

    }
    @Test

    void testAddTraineesArgs(){

        // given
        Poe poe = Poe.builder()
                .title("Java Fullstack")
                .beginDate(LocalDate.of(2022, 10, 24))
                .endDate(LocalDate.of(2023, 1, 27))
                .poeType(PoeType.POEI)
                .build();

        Trainee trainee1 =  Trainee.builder()
                .firstname("Johnny")
                .lastname("Clark")
                .build();

        Trainee trainee2 =  Trainee.builder()
                .firstname("Michael")
                .lastname("Johnson")
                .build();

        // when
        poe.addTrainees(trainee1, trainee2);

        // then
        assertTrue(poe.getTrainees().contains(trainee1),
                " trainee " + trainee1.getFirstname() + " is in poe trainees ");

        String firstname =poe.getTrainees().stream()
                .filter(data -> data.getFirstname().equals("Johnny"))
                .map(x -> x.getFirstname())
                .findFirst().get();

        assertEquals("Johnny",poe.getTrainees().stream()
                .filter(data -> data.getFirstname().equals("Johnny"))
                .map(x -> x.getFirstname())
                .findFirst().get() );

        assertAll(Stream.of(trainee1, trainee2)
                .map( data -> () -> assertTrue(
                        poe.getTrainees().contains(data),
                        " trainee " + data.getFirstname() + " is in poe trainees ")));

    }

}
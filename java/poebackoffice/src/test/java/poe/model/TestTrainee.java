package poe.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TestTrainee {

    @Test

    void testDefaultConstructor(){

        Trainee trainee = new Trainee();
        System.out.println(trainee);
        System.out.println(trainee.hashCode());

        trainee.setFirstname("Alexandre");
        System.out.println(trainee.getFirstname());
        assertEquals("Alexandre", trainee.getFirstname());

    }

    @Test

    void testAllArgsConstructor(){

        LocalDate birthdate = LocalDate.of(1902,01,9);

        Trainee trainee1 =
                new Trainee("Alexandre", "Gaglianone", birthdate );

        assertEquals("Alexandre", trainee1.getFirstname(), "firstname");
        assertEquals("Gaglianone", trainee1.getLastname(), "lastname");
        assertEquals(birthdate, trainee1.getBirthdate(), "birthdate");

        assertInstanceOf(Trainee.class, trainee1);


    }

    @Test

    void severalInstances(){

        Trainee trainee1 = new Trainee();
        Trainee trainee2 = new Trainee();
        Trainee trainee3 = new Trainee();

        System.out.println(trainee1);
        System.out.println(trainee2);
        System.out.println(trainee3);

        assertInstanceOf(Trainee.class, trainee1);

    }

    @Test

    void testToString(){
        Trainee trainee = new Trainee("Jane", "Doe", LocalDate.of(2000,2,29));
        System.out.println(trainee.toString());
        assertEquals("Doe", trainee.getLastname());

    }

}
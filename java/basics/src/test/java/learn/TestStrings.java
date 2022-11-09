package learn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStrings {

    @Test
    void testStringsUninitializedVariable() {

        String city; // variable non initialized

        //System.out.println(city); //forbidden

        city = "Toulouse";
        System.out.println(city);

    }

    @Test
    void testStringInitializedVariable() {

        String city =  "Toulouse";
        System.out.println(city);

        String message = city  +  " la ville rose, avec " + 470000 + " habitantes";
        System.out.println(message);

        System.out.println("Nb lettres: " + city.length());
        System.out.println(city.toUpperCase());
        System.out.println(city.toLowerCase());

        message += "; il fait beau aujourd'hui";
        System.out.println(message);

        //first character at index 0
        System.out.println(city.substring(4));
        System.out.println(city.substring(4,6));

    }

    @Test
    void testSubstringOutOfBonds(){

        String city = "Toulouse";
        assertThrows(IndexOutOfBoundsException.class,
                () -> city.substring(9));

    }

    @Test
    void testOperatorEquals (){

        //test de ==
        String city = "Toulouse";
        String d = "se";
        String city2 = "Tou" + "lou" + d;

        boolean ea = city == city2;
        System.out.println(city + " " + city2);
        System.out.println("operateur == " + ea);

        assertFalse( city == city2);

    }

    @Test
    void testMethodEquals () {

        //test de String.equals("String " valueToTest)

        String city = "Toulouse";
        String d = "se";
        String city2 = "Tou" + "lou" + d;

        boolean ea = city.equals(city2);

        assertTrue(ea);

    }

}

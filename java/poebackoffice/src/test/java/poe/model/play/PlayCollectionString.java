package poe.model.play;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;


 class PlayCollectionString {

     @ParameterizedTest
     @ValueSource(strings = {"chat","chien", "mostique tigre"})

    void testList1(String animal){

        List<String> animals = new ArrayList<>();
        System.out.println(animals);

        animals.add(animal);
        animals.add("tigre");
        animals.add("buffalo");
        animals.add("vache");

        System.out.println(animals);
        System.out.println(animals.size());

         for (String animale: animals
              ) {
             System.out.println("\t -" + animale);
         }
         assertEquals("tigre", animals.get(1));



    }

    @Test

    void testList2(){

        List<String> animals = new ArrayList<>();
        Collections.addAll(animals,"chien", "chat","vache", "zebre","singe");
        System.out.println(animals);

        System.out.println(animals.size());

        for (String animale: animals
        ) {
            System.out.println("\t -" + animale);
        }

        System.out.println(animals.get(4));
        assertEquals(5, animals.size());

    }

    @Test

    void playWithList3(){

         // since Java 11 exists List.of
        List<String> animals = List.of("Dog", "Cat", "Owl", "Monkey", "Mouse", "Lion");
        // List created with List.of are Immutable!,
        // So an operation as List.add() throws an error.

        System.out.println(animals);
        System.out.println(animals.getClass());

        assertEquals(6, animals.size());

        //loops: statements(des instructions)

        for (String animal: animals) {

            System.out.println("\t °  " + animal.toUpperCase());

        }
        for (int i = 0; i < animals.size(); i++) {

            System.out.println("\t #  " + animals.get(i).toLowerCase());

        }

        //loops: functional

        //1. .forEach(f)
                animals.forEach(animal -> System.out.println("\t @ " + animal));

        //2 .reduce, .map, .filter
                List<Integer> countLetters = animals.stream()
                        .map(animal ->  animal.length()).toList();

                System.out.println(countLetters);
        //3 other pipeline .filter
                List<String> animalsName = animals.stream()
                        .filter(animal -> animal.length() > 3).toList();

                System.out.println(animalsName);

                List<Integer> countLettersE = animals.stream()
                        .filter(animal -> animal.endsWith("e"))
                        .map(String::length)
                        .toList();
                System.out.println(countLettersE);

        // 4 pipeline with reduce
                int totalCountLetters = animals.stream()
                        .mapToInt(String::length)
                        .sum();
                System.out.println(totalCountLetters);



    }

}



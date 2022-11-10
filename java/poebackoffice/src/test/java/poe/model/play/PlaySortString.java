package poe.model.play;

import org.junit.jupiter.api.Test;
import poe.model.Poe;
import poe.model.PoeType;

import java.text.Collator;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static poe.model.play.PlayCollectionPoe.poeList;

public class PlaySortString {

    @Test

    void testSortStrings(){

        List<String> animals ;

        String animal1 = "dog";
        String animal2 = "cat";

        assertTrue(animal1.compareTo(animal2) > 0);

    }

    @Test

    void sortListStrings(){

        List<String> animals = new ArrayList<>();

        Collections.addAll(animals, "dog", "cat", "zebra", "lion", "monkey", "owl");


        //Alphabetical order by French rules, collator as parameter on sort
        Collator collator = Collator.getInstance(new Locale("fr", "FR"));

        Collections.sort(animals, collator);


        System.out.println(animals);

    }

    @Test

    void sortSetString(){

        Set<String> animals = new TreeSet<>();

        Collections.addAll(animals, "dog","cat", "zebra", "lion", "monkey", "owl");

        System.out.println(animals);

        Set<String> animals2 = new TreeSet<>(Comparator.reverseOrder());

        animals2.addAll(animals);
        System.out.println(animals2);




    }





}

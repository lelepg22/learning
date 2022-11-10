package poe.model.play;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlaySortInteger {

    @Test

    void compareIntegers(){

        int distance1 = 15;
        int distance2 = 4;
        assertFalse(distance1 < distance2);

    }

    @Test

    void sortIntegers(){

        List<Integer> distances = new ArrayList<>();
        Collections.addAll(distances, 15, 4, 3,8, 98,55);

        Collections.sort(distances);
        System.out.println(distances);

        //sorting with a comparable
        Collections.sort(distances, Comparator.reverseOrder());
        System.out.println(distances);

    }

    @Test

    void navigableSetIntegers(){

        NavigableSet<Integer> distances = new TreeSet<>();

        Collections.addAll(distances, 7,3,100,86,52,22);

        System.out.println(distances);

        distances.add(42);

        System.out.println(distances);

        NavigableSet<Integer> distances2 = new TreeSet<>(Comparator.reverseOrder());

        distances2.addAll(distances);
        System.out.println(distances2);

        // if we try to add two times the same value in a Set, it will return false
        System.out.println(distances2.add(42));

        System.out.println(distances2);


    }
}

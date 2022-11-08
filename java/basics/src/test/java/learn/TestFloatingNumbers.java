package learn;

import static org.junit.jupiter.api.Assertions.*;

//IEEE754

import org.junit.jupiter.api.Test;

import java.util.List;

public class TestFloatingNumbers {

    @Test

    void testDouble(){

        double x =  3.75;
        double f = 1.25;
        double g = 3.123E10; //E EXPONANT
        double h = -3.1621E-20;
        for (double m: List.of(x,f,g,h)){
            System.out.println(m);
        }

    }

    @Test

    void testComputeOperator(){

        double x = 7.0; // or 7D or 7. if 7 it's int in a double
        double y = ((x + 3) * 10) / 9 - 1;
        System.out.println(y);
        assertEquals(10.11111, y, 1E-5);

    }

    @Test

    void testFraiseTagadaDouble(){

        double price = 0.10;

        for (int i = 1; i <= 3 ; i++) {

            double totalPrice = i * price;
            System.out.println(totalPrice);

        }

    }

    @Test

    void testFraiseTagadaFloat(){

        float price = 0.10F; // F obligatory for float

        for (int i = 1; i <= 5 ; i++) {

            float totalPrice = i * price;
            System.out.printf("%.8f%n",totalPrice); // pour aficher plus que 0.1 utilizer printf("%.8f", valeur)
            // pour sauter la ligne dans la console "%n"

        }

    }

    @Test

    void testInfinity(){

        double inf = Double.POSITIVE_INFINITY;
        System.out.println(inf);
        double x = 1E308;
        System.out.println(x);
        x*=2;
        System.out.println(x);
        double z = 1 / inf;
        System.out.println(z);
        double y = 1/0D;
        System.out.println(y);
        y = 0/0D;
        System.out.println(y);



    }

}

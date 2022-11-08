package learn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 *  1011 (2)  = 1*2^3 + 0*2^2 + 1*2^1 + 1*2^0(10)
 */

public class TestIntegers {

    @Test

        void testSignedInts(){

            //int x = 3000000000; syntax error max int passed
            int x = 2000000000;

            System.out.println(x);
            System.out.println(-x);
            System.out.println(Integer.MAX_VALUE);
            System.out.println(Integer.MIN_VALUE);

         }

    @Test
        void testComputerOverflow(){

            int x = 2000000000;
            int y = x*2;
            System.out.println(y);
        }

    @Test
        void testComputeoverflowError() {

        int x = Integer.MAX_VALUE;

        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> Math.addExact(x, 1));

        assertEquals("integer overflow", exception.getMessage());

        }

    @Test

        void testUnsignedInts() {

            int x = Integer.parseUnsignedInt("3000000000");
            x += 1;
            System.out.println(Integer.toUnsignedString(x));
        }

    @Test

        void testLongs(){

        long x = 3000000000L; // "L" pour un long plus grand que le valeur accepte pour int.
        System.out.println(x);
        x *= 2;
        System.out.println(x);

        }

    @Test

        void testComputeOperators(){

            int x = 7;
            int y = (x + 3) * 10 / 9 - 1;
            int r = ((x+3) * 10) % 9;

            System.out.println(y);
            System.out.println(r);

            assertEquals(10, y, "y");
            assertEquals(1, r, "r");

        }

    @Test

        void divideByZero() {

        ArithmeticException exception = assertThrows(ArithmeticException.class,
                ()-> { int y = 1/0; });

        assertEquals("/ by zero", exception.getMessage());


    }


}

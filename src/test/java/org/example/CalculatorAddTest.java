package org.example;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorAddTest {
    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("Calculator Add test case - when both numbers are positive")
    void addTestCase1() {
        //sample data
        // expected data - 30
        int n1 = 10;
        int n2 = 20;
        int expected = 30;
        int sum = calculator.add(n1, n2);

        assertEquals(expected, sum);
    }

    @Test
    @DisplayName("Calculator Add test case - when both numbers are negative")
    void addTestCase2() {
        //sample data
        // expected data - 30
        int n1 = -10;
        int n2 = -20;
        int expected = -30;
        int sum = calculator.add(n1, n2);

        assertEquals(expected, sum);
    }

    // handle exception Nested class insdie same method
    @Nested
    @DisplayName("Exception cases")
    class ExceptionCases {
        @Test
        @DisplayName("Calculator Add test case - when  any number is less than -100")
        void addTestCase3() {
            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> calculator.add(-101, 100));

            assertEquals("Numbers less than 100 are not allowed", exception.getMessage());
        }

        @Test
        @DisplayName("Calculator Add test case - when  any number is larger than 50000")
        void addTestCase4() {

            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> calculator.add(500001, 100));

            assertEquals("Negative Numbers not allowed", exception.getMessage());
        }
    }


    // Timeout test case of method
    @Nested
    @DisplayName("TImout cases..")
    class TimeoutCases {
        @Test
        @DisplayName("Calculator Add test case - when  any number is larger than 40000 and taking time")
        @Timeout(value = 10000, unit = TimeUnit.MILLISECONDS)// time testing for each method , how much time it is taking
        void addTestCase5() {
            int sum = calculator.add(41000, 41000);
            assertEquals(82000, sum);
        }

        @Test
        @DisplayName("Calculator Add test case - when  any number is larger than 40000 and taking time")
        void addTestCase6() {
            int sum = assertTimeout(Duration.ofMillis(10000), () -> calculator.add(42000, 42000));
            assertEquals(84000, sum);
        }
    }

    @Test
    @DisplayName("Assertion library demo")
    void addTestCase7() {

        assertTrue("str".equals("str"));
        assertFalse(false);

        String str = "arvind";
        assertNotNull(str);

        assertNotEquals(23, 43);

    }

    @Test
    @DisplayName("Calculator Add test case - assertAll")
    void addTestCase8() {

        assertAll("mulitple test cases",
                () -> assertEquals(46, calculator.add(23, 23)),
                () -> assertEquals(460, calculator.add(230, 230)),
                () -> assertEquals(8000, calculator.add(4000, 4000)));

    }

    @Nested
    @DisplayName("Repeate tests demo")
    class RepeatTestCases {

        @RepeatedTest(10)// for Repeated no . of and no require of @Test as it is by default take care
        @DisplayName("Repeat test for timing info")
        void addTestCase1() {
            int sum = assertTimeout(Duration.ofMillis(990), () -> calculator.add(42000, 42000));
            assertEquals(84000, sum);

        }
    }
}

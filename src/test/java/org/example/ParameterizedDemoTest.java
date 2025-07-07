package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestMethodOrder(MethodOrderer.Random.class)// Randomly run the test cases and
public class ParameterizedDemoTest {
    @ParameterizedTest
    @EmptySource // blank source value
    @NullSource // null source value passed to the function
    @NullAndEmptySource // both null and empty
    @ValueSource(strings = {"abc", "defc", "xyz"})
    void testCase1(String arg) {

        Assertions.assertTrue(!arg.isEmpty());
    }


    Calculator calculator = new Calculator();
    @Order(1)
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 34, 5, 6})
    void testCase2(int arg) {

        Assertions.assertTrue(calculator.isSumAllowed(arg));
    }

    @ParameterizedTest
    @MethodSource("intRange") // method name for
    void testCase3(int arg) {
        Assertions.assertTrue(calculator.isSumAllowed(arg));
    }

    static IntStream intRange() {
        return IntStream.range(10, 40);// generate range of no. between 30 approaximate
    }


    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",// n1,n2 , expected by commasepareted value
            "11, 20, 31",
            "12, 20, 32",
            "13, 20, 33"
    })
    void testCase4(int num1, int num2, int expected) {
        assertEquals(expected, calculator.add(num1, num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    void testCase5(int num1, int num2, int expected) {
        assertEquals(expected, calculator.add(num1, num2));
    }
}

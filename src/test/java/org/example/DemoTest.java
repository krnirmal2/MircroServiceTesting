package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DemoTest {
    public DemoTest() {
        System.out.println("test instance");
    }
    // Lifecycle Method
    @BeforeEach
    void setup(){
        System.out.println("before each");
    }


    @Test
    @Order(10)
    void howToProtectFromCorona() {
        String expected = "stay home !! stay safe !!";
        Demo demo = new Demo();
        String actual = demo.howToProtectFromCorona();
        assertEquals(expected, actual, "both are not equal");
    }

    @Test
    @Order(2)
    void currentlyInfectedPeoples() {

        Demo demo = new Demo();
        int actual = demo.currentlyInfectedPeoples(100);
        int expected = 13100;
        assertEquals(expected, actual);
    }

    // LifeCycle method
    @AfterEach
    void teardown(){
        System.out.println("after each");
    }
}
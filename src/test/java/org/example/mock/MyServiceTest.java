package org.example.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

public class MyServiceTest {
   // as Myservice use external service so need to add
    // mock object
    //
    @InjectMocks
    MyService myService;

    @Mock // this annotation help mocking objects
//    @Spy
    ExternalService externalService;

    @BeforeEach
    void setup(){

        MockitoAnnotations.openMocks(this);

//        externalService = Mockito.mock(ExternalService.class);// @Mock and this line work create mocking objects
//        externalService = Mockito.spy(ExternalService.class);

//        myService = new MyService(externalService);// injecting external service to my service same as @InjectMocking
    }

    @Test
    void test(){
//        Mockito.when(externalService.getValidationData("Nirmal")).theReturn("any-value"); // hard coded string
        Mockito.when(externalService.getValidationData(anyString())).thenReturn("some-value");// any string value return string not hard code

        assert (myService.validate("Nirmal"));// validata data
//        Mockito.verify(externalService, Mockito.times(1).getValidationData("Nirmal"));// validate the service or behaviour
        Mockito.verify(externalService, Mockito.times(1)).getValidationData(anyString());

    }

    @Test
    void test2(){
        Mockito.when(externalService.getValidationData("true")).thenReturn("true");
        Mockito.when(externalService.getValidationData(null)).thenReturn(null);
        Assertions.assertTrue(myService.validate("true"));

        assertThrows(RuntimeException.class, () -> myService.validate(null));

        Mockito.verify(externalService).getValidationData("true");
    }

    //when -then
    @Test
    void test3(){
        Mockito.when(externalService.getValidationData(null)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> myService.validate(null));
    }

    //doretun and dothrow
    @Test
    void test4() {
        Mockito.doReturn("abc").when(externalService.getValidationData("abc"));
        Mockito.doThrow(RuntimeException.class).when(externalService.getValidationData(null));
    }
    // spy annotation help mix like actual and mock object both unlike mock only handle mocking object
}

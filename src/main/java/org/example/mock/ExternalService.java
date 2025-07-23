package org.example.mock;

public class ExternalService {

        public String getValidationData(String id){
            return "actual data for validation";
        }

        void someMethod() throws RuntimeException{
            System.out.println("doing nothing..");
    }
}

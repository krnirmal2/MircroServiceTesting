package org.example.mock;

public class MyService {
    // use External service
    ExternalService externalService; // composing or injecting
    public MyService(ExternalService externalService){
        this.externalService = externalService;// instantiate external service
    }

    public boolean validate(String id){
        if(id ==null){
            throw new RuntimeException("id is null");
        }
        if(externalService.getValidationData(id) != null){// check if external service is not null
            return true;
        }

        return false;
    }
}

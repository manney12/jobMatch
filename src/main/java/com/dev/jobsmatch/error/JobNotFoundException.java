package com.dev.jobsmatch.error;

public class JobNotFoundException extends RuntimeException{

    public JobNotFoundException (String message){
        super(message);

    }
}

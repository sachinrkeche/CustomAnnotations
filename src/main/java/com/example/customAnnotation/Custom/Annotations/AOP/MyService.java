package com.example.customAnnotation.Custom.Annotations.AOP;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class MyService {

    @LogsExecutionsTime(value = "fetching serve method", level="INFO")
    public void serve() throws InterruptedException, ExecutionException {

    }
}

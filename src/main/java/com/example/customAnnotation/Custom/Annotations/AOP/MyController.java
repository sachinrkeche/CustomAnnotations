package com.example.customAnnotation.Custom.Annotations.AOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class MyController {
    @Autowired
    private MyService myService;

    @GetMapping("/") // Maps HTTP GET requests to the root URL ("/")
    public String helloWorld() throws ExecutionException, InterruptedException {
        myService.serve();
        return "Hello World from Spring Boot!"; // Returns a simple string response
    }

}

package com.digitalhouse.HelloWorld.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backend/202407")
public class HelloWorldController {

    //HTTP: GET POST PUT DELETE
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hola Mundo";
    }

    //HTTP: GET POST PUT DELETE
    @GetMapping("/goodbye")
    public String goodbyeWorld() {
        return "Hasta luego!";
    }



}

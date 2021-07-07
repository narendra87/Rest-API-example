package com.example.springrestapi.controller;

import com.example.springrestapi.modal.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

//Controller
@RestController
public class HelloWorldController {
@Autowired
    MessageSource messageSource;
    //Get
    //URI
    //Method
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello world!!";
    }
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello-world-bean");
    }

    @GetMapping(path = "/hello-world-bean/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello-world-bean %S",name));
    }
//    @GetMapping(path = "/hello-world/internationalized")
//    public String helloWorldPathVariable(@RequestHeader(name="Accept-Language",required = false) Locale locale){
//return messageSource.getMessage("good.morning.message",null,locale);
//    }
@GetMapping(path = "/hello-world/internationalized")
public String helloWorldPathVariable(){
    return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
}
}

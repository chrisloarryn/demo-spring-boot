package com.chrisloarryn.demospringboot;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

    @RequestMapping("/cat")
    public String cat() {
        return "Meow!";
    }

    @RequestMapping("/dog")
    public String dog() {
        return "Woof!";
    }
}

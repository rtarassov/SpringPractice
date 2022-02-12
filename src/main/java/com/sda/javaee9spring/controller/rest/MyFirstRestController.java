package com.sda.javaee9spring.controller.rest;

import com.sda.javaee9spring.entity.Child;
import com.sda.javaee9spring.entity.Mother;
import com.sda.javaee9spring.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest")
public class MyFirstRestController {

    // Person object is returned as a JSON inside body of response
    @GetMapping("/one-person")
    public Person onePerson() {
        log.info("onePerson() method called!");
        return new Person("Richard", "T", 22);
    }

    @GetMapping("/persons-array")
    public Person[] personsArray() {
        return new Person[] {
                new Person("Kasia", "P.", 15),
                new Person("Marek", "Nowak", 35)
        };
    }

    @GetMapping("/mother")
    public Mother motherAndChild() {
        return new Mother("Ewelina",
                new Child("Frank", "male"));
    }
}

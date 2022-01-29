package com.sda.javaee9spring.controller;

import com.sda.javaee9spring.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/persons")
public class PersonController {

    public static final String PERSONS_KEY = "persons";

    @GetMapping("/names")
    public String showListOfPersonsNames(Model data) {
        // This list will be dynamic in the future
        //        List<Person> persons
        var persons = List.of(
                new Person("Mariusz", "Pastuszka", 18),
                new Person("Alicja", "Strus", 25),
                new Person("Joe", "Doe", 40)
        );
        data.addAttribute(PERSONS_KEY, persons);
        return "persons/persons-names";
    }
}

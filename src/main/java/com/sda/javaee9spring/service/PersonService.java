package com.sda.javaee9spring.service;

import com.sda.javaee9spring.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    public List<Person> getAllPersons() {
        var persons = List.of(
                new Person("Mariusz", "Pastuszka", 18),
                new Person("Alicja", "Strus", 25),
                new Person("Joe", "Doe", 40)
        );
        return persons;
    }
}

package com.sda.javaee9spring.controller.rest;

import com.sda.javaee9spring.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/first-person-rest")
public class FirstPersonRestController {

    @GetMapping("/one-person")
    public ResponseEntity<Person> onePerson() {
        log.info("onePerson() method called!");
        return ResponseEntity.ok(new Person(
                "Richard",
                "T",
                22));
    }

    @GetMapping("/one-person-404")
    public ResponseEntity<Person> onePerson404() {
        log.info("onePerson-404() method called!");
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/custom")
    public ResponseEntity<Person> customResponseEntity() {
        return new ResponseEntity<>(new Person("Mike", "T", 33), HttpStatus.OK);
    }

    @GetMapping("/with-headers")
    public ResponseEntity<Person> customResponseEntityWithHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("name", "richard");
        return new ResponseEntity<>(new Person("John", "S", 20), httpHeaders, HttpStatus.OK);
    }

}

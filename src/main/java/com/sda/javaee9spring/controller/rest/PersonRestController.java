package com.sda.javaee9spring.controller.rest;

import com.sda.javaee9spring.entity.PersonEntity;
import com.sda.javaee9spring.service.RealPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class PersonRestController {

    private final RealPersonService personService;

    @Autowired
    public PersonRestController(RealPersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<PersonEntity> findAllPersons() {
        log.info("findAllPersons() was called from controller");

        return personService.readAllPersonEntities();
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonEntity> findPersonById(@PathVariable("id") Long personId) {
        log.info("Trying to find a person by id [{}]", personId);

        var personEntity = personService.findPersonById(personId);
        if (personEntity == null) {
            log.info("Didn't find a personEntity");
            return ResponseEntity.notFound().build();
//            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(personEntity);
//        return new ResponseEntity<>(personEntity, null, HttpStatus.OK);
    }
}

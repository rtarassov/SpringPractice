package com.sda.javaee9spring.service;

import com.sda.javaee9spring.entity.Person;
import com.sda.javaee9spring.entity.PersonEntity;
import com.sda.javaee9spring.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RealPersonService {

    private final PersonRepository personRepository;

    public RealPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonEntity> readAllPersonEntities() {
        log.info("trying to read all persons entities...");

        var result = personRepository.findAll();
        log.info("'person entities read from DB: " + result);
        return result;
    }

    public PersonEntity findPersonById(Long personId) {
        log.info("Trying to find person by id: [{}]", personId);
        PersonEntity result = null;
        var maybePerson = personRepository.findById(personId);
        if (maybePerson.isPresent()) {
           result = maybePerson.get();
        }
        log.info("Found PersonEntity: [{}]", result);
        return result;
    }
}
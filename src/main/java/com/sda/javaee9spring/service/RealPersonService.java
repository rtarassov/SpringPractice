package com.sda.javaee9spring.service;

import com.sda.javaee9spring.entity.Person;
import com.sda.javaee9spring.entity.PersonEntity;
import com.sda.javaee9spring.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        log.info("person entities read from DB: " + result);
        return result;
    }

    public Optional<PersonEntity> findPersonById(Long personId) {
        log.info("Trying to find person by id: [{}]", personId);

        var maybePerson = personRepository.findById(personId);

        log.info("Found PersonEntity: [{}]", maybePerson);
        return maybePerson;
    }

    @Transactional
    public boolean deletePersonEntityById(Long id) {
        log.info("trying to delete entity by id: [{}]", id);

        boolean result = false;
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            result = true;
        }

        return result;
    }

    @Transactional
    public PersonEntity savePerson(PersonEntity personEntity) {
        if (!personRepository.checkDuplicates(personEntity.getName(), personEntity.getSurname())) {
            personRepository.save(personEntity);
            log.info("Entity after saving: [{}]", personEntity);
        } else {
            log.info("Found a duplicate, new entity not saved!");
        }
        return personEntity;
    }
}
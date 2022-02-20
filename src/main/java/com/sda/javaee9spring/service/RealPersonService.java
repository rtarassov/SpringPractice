package com.sda.javaee9spring.service;

import com.sda.javaee9spring.entity.PersonEntity;
import com.sda.javaee9spring.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RealPersonService {

    private final PersonRepository personRepository;
    private final RestTemplate restTemplate;

    public RealPersonService(PersonRepository personRepository, RestTemplate restTemplate) {
        this.personRepository = personRepository;
        this.restTemplate = restTemplate;
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
    public boolean savePerson(PersonEntity entity) {
        boolean result = false;
        log.info("entity for saving: [{}]", entity);
        if (checkIfEntityIsValid(entity) && !personRepository.checkDuplicates(entity.getName(), entity.getSurname())) {
            personRepository.save(entity);
            log.info("entity after saving: [{}]", entity);
            result = true;
        } else {
            log.info("Found a duplicate, new entity was not saved.");
        }

        return result;
    }

    private static boolean checkIfEntityIsValid(PersonEntity personEntity) {
        boolean result = true;

        if (personEntity.getName() == null || personEntity.getName().isBlank()) {
            result = false;
        }
        if (personEntity.getSurname() == null || personEntity.getSurname().isBlank()) {
            result = false;
        }
        if (personEntity.getAge() < 0) {
            result = false;
        }

        log.info("Entity: [{}], isValid?: [{}]", personEntity, result);
        return result;
    }
}
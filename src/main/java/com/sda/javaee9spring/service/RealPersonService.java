package com.sda.javaee9spring.service;

import com.sda.javaee9spring.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class RealPersonService {

    private final PersonRepository personRepository;

    public RealPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}

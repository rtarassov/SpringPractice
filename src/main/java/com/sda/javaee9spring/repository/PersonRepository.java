package com.sda.javaee9spring.repository;

import com.sda.javaee9spring.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    // based on the name of that method Spring is going to build an SQL query
    // Spring is using class properties to build the query: like name, surname, ir or age
    // use it only for simple cases(short method names)!!!
    // for complicated or long sql queries use @Query annotation
    boolean existsByNameAndSurname(String name, String surname);

    // we can provide our own query and Spring with Hibernate are going to use it
    // it is very useful for longer queries
    // we've got 2 options here:
    // using native sqls(with nativeQuery set to true)
    // OR
    // using JPQL (with nativeQuery set to false)
    @Query(value = """
    SELECT COUNT(*) > 0
    FROM PERSON_ENTITIES
    WHERE name = :name AND surname = :surname
    """, nativeQuery = true)
    boolean checkDuplicates(String name, String surname);
}

package com.javatestdecagon.decagontest.repo;

import com.javatestdecagon.decagontest.enitity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);
}

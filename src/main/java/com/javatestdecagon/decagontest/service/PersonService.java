package com.javatestdecagon.decagontest.service;

import com.javatestdecagon.decagontest.dto.PersonDto;
import com.javatestdecagon.decagontest.enitity.Person;

public interface PersonService {

    // CRUD

    Person saveOurGuy(PersonDto person);

    Person findById(Long id);

    boolean deleteThatGuy(Person person);
}

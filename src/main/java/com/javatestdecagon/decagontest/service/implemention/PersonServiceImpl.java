package com.javatestdecagon.decagontest.service.implemention;

import com.javatestdecagon.decagontest.dto.PersonDto;
import com.javatestdecagon.decagontest.enitity.Person;
import com.javatestdecagon.decagontest.repo.PersonRepository;
import com.javatestdecagon.decagontest.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    @Override
    public Person saveOurGuy(PersonDto person) {
        // Save -- Check if Exist
        log.info("service:: about saving person :: {}", person);
        Person personExist = personRepository.findByEmail(person.getEmail())
                .orElse(null);


        if(personExist == null) {
           return personRepository.save(Person.builder()
                            .age(person.getAge())
                            .email(person.getEmail())
                            .name(person.getName())
                    .build());
        }

        log.info("person was saved");
        // Save
        // Return Person
        return null;
    }

    @Override
    public Person findById(Long id) {

        Optional<Person> optionalPerson = personRepository.findById(id);

        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        }
        return null;
    }

    @Override
    public boolean deleteThatGuy(Person person) {

        personRepository.delete(person);
        return true;
    }
}

package com.javatestdecagon.decagontest.service.implemention;

import com.javatestdecagon.decagontest.dto.PersonDto;
import com.javatestdecagon.decagontest.enitity.Person;
import com.javatestdecagon.decagontest.repo.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    // Mock External Component
    @Mock
    private PersonRepository personRepository;

    //Service Under Test
    @InjectMocks // ==> Constructor
    private PersonServiceImpl personService;

    @Test
    void GivenPersonThatAlreadyExist_WhenSaveOurBuy_ShouldReturnNull() {
        //Given
        PersonDto personData = new PersonDto("email@gmail.com","ernest", 20);
        Person person = Person.builder()
                .id(1L)
                .age(personData.getAge())
                .name(personData.getName())
                .email(personData.getEmail())
                .build();


        //When
        when(personRepository.findByEmail(personData.getEmail())).thenReturn(Optional.ofNullable(person));
        Person actual = personService.saveOurGuy(personData);

        assertNull(actual);

    }

    @Test
    void saveOurGuy() {

        //Given
        PersonDto personData = new PersonDto("email@gmail.com","ernest", 20);
        Person person = Person.builder()
                .id(1L)
                .age(personData.getAge())
                .name(personData.getName())
                .email(personData.getEmail())
                .build();


        //When
        when(personRepository.save(Mockito.any(Person.class))).thenReturn(person);
        Person actual = personService.saveOurGuy(personData);

        assertEquals(person.getAge(), actual.getAge());
    }

    @Test
    void findById() {
//        Given
        Long id = 20L;
        //Given
        PersonDto personData = new PersonDto("email@gmail.com","ernest", 20);
        Person person = Person.builder()
                .id(1L)
                .age(personData.getAge())
                .name(personData.getName())
                .email(personData.getEmail())
                .build();


        // When
        when(personRepository.findById(id)).thenReturn(Optional.ofNullable(person));
        Person actual = personService.findById(id);

        //Then
        assertEquals(person.getAge(), actual.getAge());
    }

    @Test
    void deleteThatGuy() {
    }
}
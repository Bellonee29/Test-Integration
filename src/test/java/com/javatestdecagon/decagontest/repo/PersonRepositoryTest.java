package com.javatestdecagon.decagontest.repo;

import com.javatestdecagon.decagontest.enitity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest // Take time, It will start the whole context DON'T USE

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.DERBY)
class PersonRepositoryTest {

    // Unit Test
        // Test Should cost  --- Speed and Space (memory)
    // Unit Test -- We Test in isolation (only one unit) Solution --> Mock/Stub --> Mockito
    // Correctness

    //Person -- CRUD -- (C) Save -- (R) Find -- (U)



    // Service Under Test
    @Autowired
    private PersonRepository personRepository;


    // Update
    @Test
    public void GiveDeleteId_WhenDelete_ShouldRemoveThatEntity() {
//        Given
        Long id = 1L;
        Person personData = new Person(1L, "Bisi", 15, "ada@gmail.com");

        //When
        // Update -- Find the Entity, Set properties then Save
        personRepository.save(personData);

        personRepository.delete(personData);

        Person response = personRepository.findById(id).orElse(null);

        assertNull(response);

    }



    //Read
    @Test
    @DisplayName(value = "my_test_oh")
    void GiveId1_WhenFindById_ThenReturn() {
        // Given
        Long id = 1L;
        Person personData = new Person(1L, "Ada", 15, "ada@gmail.com");

        // When
        personRepository.save(personData);
        Optional<Person> person = personRepository.findById(id);
        String expected = person.get().getName();
        String actual = "Ada";

        //Then
        assertNotNull(person.get());
        assertEquals("Ada", expected);
    }

    @Test
    @DisplayName(value = "my_test_oh")
    void GiveByEmail_WhenFindByEmail_ThenReturnObject() {
        // Given
        Long id = 1L;
        Person personData = new Person(1L, "Ada", 15, "ada@gmail.com");

        // When
        personRepository.save(personData);
        Optional<Person> person = personRepository.findByEmail("ada@gmail.com");
        String expected = person.get().getName();
        String actual = "Ada";

        //Then
        assertNotNull(person.get());
        assertEquals("Ada", expected);
    }


    //Save -- Given/ When / Then == Naming convention
    @Test
    public void GivenPerson_WhenSave_ThenReturnObject() {

        // Given
        Person person = new Person(1L, "Ada", 15, "ada@gmail.com");

        //When
        Person actual = personRepository.save(person);

        //Then
        assertNotNull(actual);

    }
}
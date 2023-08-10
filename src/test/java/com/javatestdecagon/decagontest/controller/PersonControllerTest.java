package com.javatestdecagon.decagontest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatestdecagon.decagontest.dto.PersonDto;
import com.javatestdecagon.decagontest.enitity.Person;
import com.javatestdecagon.decagontest.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = PersonController.class) // Help us test Rest Endpoint PersonController
@AutoConfigureMockMvc(addFilters = false) // Remove and front filter eg: Security
@ExtendWith(MockitoExtension.class) //To Mock external components eg: PersonService
class PersonControllerTest {

    //Intention
    // To Test Routing and Validation

    //Mocks
    @MockBean
    private PersonService personService;

    //Util
    @Autowired
    private MockMvc mockMvc; //

    @Autowired
    private ObjectMapper objectMapper;

    //Data
//    PersonDto
    PersonDto personDto;
    Person person;

    @BeforeEach
    void setUp() {
        // We use this to setup data

        System.out.println("OGA HOW FAR!!!!");

        personDto = PersonDto.builder()
                .age(20)
                .email("decagon@gmail")
                .name("decagon")
                .build();
        person = Person.builder()
                .age(20)
                .id(40L)
                .email("decagon@gmail")
                .name("decagon")
                .build();
    }

    // Given When Then

    // AAA

    @Test
    public void GivenPersonDto_WhenSaveOurGuy_ShouldReturnOk() throws Exception {
        //Mock
        when(personService.saveOurGuy(personDto)).thenReturn(person);

        ResultActions result = mockMvc.perform(post("/app/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(personDto)));
        result.andExpect(status().isOk());

    }


    @Test
    @DisplayName("Testing Dto")
    public void GivenIncorrectDto_WhenEditPerson_ThenThrowException() throws Exception {
        // Given
        PersonDto incorrectDto = PersonDto.builder()
                .name("John")

                .build();

        when(personService.saveOurGuy(personDto)).thenReturn(person);

        ResultActions result = mockMvc.perform(put("/app/edit/"+4)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(incorrectDto)));

        result.andExpect(status().isBadRequest());
    }

    @Test
    void GivenId_WhenFetchById_ShouldReturnPerson() throws Exception {
// Mock
        Long id = 20L;
        when(personService.findById(id)).thenReturn(person);

//        ResultActions result = mockMvc.perform(get("/app/fetch-person/{id}", id)
//                .contentType(MediaType.APPLICATION_JSON));

//        result.andExpect(status().isOk());



        MvcResult result = mockMvc.perform(get("/app/fetch-person/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        //Assert

        int actual = result.getResponse().getStatus();
        Assertions.assertEquals(200, actual);

    }

    @Test
    void editPerson() {
    }
}
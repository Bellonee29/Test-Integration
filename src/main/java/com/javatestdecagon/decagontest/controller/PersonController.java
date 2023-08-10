package com.javatestdecagon.decagontest.controller;

import com.javatestdecagon.decagontest.dto.PersonDto;
import com.javatestdecagon.decagontest.enitity.Person;
import com.javatestdecagon.decagontest.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@Slf4j // This is to enable logging
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/app")
public class PersonController {

    // CRUD

    private final PersonService personService;


    //Save
    @PostMapping(path = "/sign-up")
    ResponseEntity<Person> personSignUp(@RequestBody PersonDto request) {
        log.info("user request to sign up for {}", request.getName());

        var response = personService.saveOurGuy(request);
        return ResponseEntity.ok(response);
    }


    // Read
    @GetMapping(path = "/fetch-person/{id}")
    ResponseEntity<?> fetchPersonByEmail(@PathVariable(value = "id") Long id) {
        log.info("about fetching person for :: {}", id);
        Person response = personService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/edit/{id}")
    ResponseEntity<?> editPerson(@PathVariable(value = "id") Long id,
    @RequestBody @Valid PersonDto request
    ) {
        log.info("about fetching person for :: {}", id);
        Person response = personService.saveOurGuy(request);
        return ResponseEntity.ok(response);
    }











    //Controller ** (Rest) Status, Routing, Validation
    // Create Endpoints
    // Understand components around endpoint
    // Test our endpoint



//    RestController :: this is a marker for A.Context and Dispatcher servlet
//    RequestMapping :: Defines the Location for DispatcherServlet
//    Verbs: @PostMapping (Sending Data), @GetMapping (Getting Data)
    //  @PutMapping :: Total Update
    // @PatchMapping :: Partial Update @DeleteMapping
    // @Option --> Ping your service to know if it's access
//
//    @PostMapping(path = "/register/{id}")
//    void saveUser(@PathVariable Long id){
//
//    }
//
//    @PostMapping(path = "/register/{id}/{customerId}")
//    void saveUser1(@PathVariable(value = "customerId") Long id){
//
//    }
//
//    @PostMapping(path = "/register/{id}")
//    ResponseEntity<Object> saveUser3(@PathVariable(value = "id") Long id,
//                   @PathParam(value = "name") String name,
//                    @RequestBody @Valid PersonDto person){
//
//        Object response = null;
//
//        return ResponseEntity.ok(response);
//
////        return ResponseEntity.status(200).body(response);
//
////        ResponseEntity.created(URI.create("/register/1")).body(response);
//
////        ResponseEntity.badRequest().body(response) 400
//
//    }
//
//    // www.decagon/register/1
////    {
////        name: "John";
////    }
//    // www.decagon/register/{id}
//    // www.decagon/register/id?23& ===> PathParam
//
////    @Valid :: we use this to active Dto validations, Passed as an Argument
////    @PathVariable
////    @PathParam
////    @RequestBody :: Tells that the endpoint requires a Body (Json)
//
////    ResponseEntity :: Helps construct our Objects to better json
//
////    Status Code HttpStatus
////    200 - 299 --- Generally it means the server is Fine
////    200 aka Ok
////    201 == Created
////    202 == accepted
//
//
////    400 == BadRequest
////    401 == Unauthorized
////    403 == No Access
//      404 == Not Found
//
////    500 == Server Error (Application Crashed)
//    //
}

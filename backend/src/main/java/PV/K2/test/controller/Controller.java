package PV.K2.test.controller;

import PV.K2.test.model.Person;
import PV.K2.test.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class Controller {
    @Autowired
    PersonRepository personRepository;

    @CrossOrigin
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(
            method = RequestMethod.POST,
            path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @CrossOrigin
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person deletePerson(@RequestBody Person person) {
        return personRepository.delete(person);
    }
}

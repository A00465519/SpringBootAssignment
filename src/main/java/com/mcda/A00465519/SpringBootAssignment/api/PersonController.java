package com.mcda.A00465519.SpringBootAssignment.api;

import com.mcda.A00465519.SpringBootAssignment.model.Person;
import com.mcda.A00465519.SpringBootAssignment.service.PersonService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public void addPerson(@NotNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping("/person")
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/person/{id}")
    public Person getPersonByID(@NotNull @PathVariable UUID id) {
        return personService.getPersonByID(id);
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@NotNull @PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @DeleteMapping("/person")
    public void deleteAllPerson() {
        personService.deleteAllPersons();
    }
}

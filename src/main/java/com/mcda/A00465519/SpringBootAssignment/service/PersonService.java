package com.mcda.A00465519.SpringBootAssignment.service;

import com.mcda.A00465519.SpringBootAssignment.dao.PersonDAO;
import com.mcda.A00465519.SpringBootAssignment.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDAO personDAO;
    @Autowired
    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    public void addPerson(Person person) {
//        UUID id = UUID.randomUUID();
//        personDAO.save(new Person(id, person.getName(), person.getPhone(), person.getEmail()));
        personDAO.save(person);
    }

    public List<Person> getAllPerson() {
        return (List<Person>) personDAO.findAll();
    }

    public Person getPersonByID(UUID id) {
        ArrayList<Person> usersList = (ArrayList) personDAO.findAll();
        Person matchedPerson = null;
        for(Person person : usersList) {
            if (person.getId().compareTo(id) == 0) {

                matchedPerson = person;
            }
        }
        return matchedPerson;
    }

    public void deletePerson(UUID id) {
        Person person = this.getPersonByID(id);
        personDAO.delete(person);
    }
    public void deleteAllPersons() {
        personDAO.deleteAll();
    }
}

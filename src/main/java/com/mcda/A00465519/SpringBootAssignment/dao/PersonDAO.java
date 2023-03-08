package com.mcda.A00465519.SpringBootAssignment.dao;

import com.mcda.A00465519.SpringBootAssignment.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDAO extends CrudRepository<Person, Integer> {

}

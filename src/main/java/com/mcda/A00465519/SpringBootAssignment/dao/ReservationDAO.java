package com.mcda.A00465519.SpringBootAssignment.dao;

import com.mcda.A00465519.SpringBootAssignment.model.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ReservationDAO extends CrudRepository<Reservation, Integer> {

}

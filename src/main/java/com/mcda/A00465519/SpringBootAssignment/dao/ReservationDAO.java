package com.mcda.A00465519.SpringBootAssignment.dao;

import com.mcda.A00465519.SpringBootAssignment.model.Reservation;

import java.util.UUID;

public interface ReservationDAO {
    int makeReservation(UUID rid, Reservation r);
    default int makeReservation(Reservation r) {
        UUID id = UUID.randomUUID();
        return makeReservation(id, r);
    }


}

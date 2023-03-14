package com.mcda.A00465519.SpringBootAssignment.service;

import com.mcda.A00465519.SpringBootAssignment.dao.ReservationDAO;
import com.mcda.A00465519.SpringBootAssignment.model.Reservation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {
    private final ReservationDAO reservationDAO;

    @Autowired
    public ReservationService(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    public void newReservation(@NotNull Reservation reservation) {
        reservationDAO.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationDAO.findAll();
    }

    public Reservation getReservationByID(@NotNull UUID id) {
        ArrayList<Reservation> reservationArrayList = (ArrayList) reservationDAO.findAll();
        Reservation matchedReservation = null;
        for(Reservation reservation : reservationArrayList) {
            if (reservation.getId().compareTo(id) == 0) {
                matchedReservation = reservation;
            }
        }
        return matchedReservation;
    }

    public void deleteReservation(@NotNull UUID id) {
        Reservation reservation = this.getReservationByID(id);
        reservationDAO.delete(reservation);
    }

    public void modifyReservation(@NotNull Reservation reservation) {
        Reservation currentReservation = getReservationByID(reservation.getId());
        Reservation newReservation = new Reservation(currentReservation.getId(),
                currentReservation.getUid(), currentReservation.getHid(), reservation.getNumberOfRoomsBooked());
        reservationDAO.save(newReservation);
    }
}

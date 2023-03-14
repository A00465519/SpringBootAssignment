package com.mcda.A00465519.SpringBootAssignment.api;

import com.mcda.A00465519.SpringBootAssignment.model.Reservation;
import com.mcda.A00465519.SpringBootAssignment.service.ReservationService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/")
@RestController
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/reservation")
    public void makeReservation(@NotNull @RequestBody Reservation reservation) {
        reservationService.newReservation(reservation);
    }

    @GetMapping("/reservation")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/reservation/{id}")
    public Reservation getReservationsByID(@NotNull @PathVariable UUID id) {
        return reservationService.getReservationByID(id);
    }

    @DeleteMapping("/reservation/{id}")
    public void deleteReservations(@NotNull @PathVariable("id") UUID id) {
        reservationService.deleteReservation(id);
    }

    @PatchMapping("/reservation")
    public void modifyReservation(@NotNull @RequestBody Reservation reservation) {
        reservationService.modifyReservation(reservation);
    }

}

package com.mcda.A00465519.SpringBootAssignment.api;

import com.mcda.A00465519.SpringBootAssignment.model.Hotel;
import com.mcda.A00465519.SpringBootAssignment.service.HotelService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/hotel")
@RestController
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public void addHotel(@RequestBody Hotel hotel) {
        hotelService.addHotel(hotel);
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public Hotel getHotelByID(@PathParam("id") UUID id) {
        return hotelService.getHotelByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathParam("id") UUID id) {
        hotelService.deleteHotel(id);
    }

    @DeleteMapping
    public void deleteAllHotels() {
        hotelService.deleteAllHotels();
    }
}

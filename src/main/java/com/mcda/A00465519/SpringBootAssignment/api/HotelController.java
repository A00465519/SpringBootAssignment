package com.mcda.A00465519.SpringBootAssignment.api;

import com.mcda.A00465519.SpringBootAssignment.model.Hotel;
import com.mcda.A00465519.SpringBootAssignment.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1")
@RestController
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/hotel")
    public void addHotel(@RequestBody Hotel hotel) {
        hotelService.addHotel(hotel);
    }

    @GetMapping("/hotel")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/hotel/{id}")
    public Hotel getHotelByID(@PathVariable("id") UUID id) {
        return hotelService.getHotelByID(id);
    }

    @DeleteMapping("/hotel/{id}")
    public void deleteHotel(@PathVariable("id") UUID id) {
        hotelService.deleteHotel(id);
    }

    @DeleteMapping("/hotel")
    public void deleteAllHotels() {
        hotelService.deleteAllHotels();
    }
}

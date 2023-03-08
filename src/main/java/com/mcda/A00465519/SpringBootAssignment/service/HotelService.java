package com.mcda.A00465519.SpringBootAssignment.service;

import com.mcda.A00465519.SpringBootAssignment.dao.HotelDAO;
import com.mcda.A00465519.SpringBootAssignment.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HotelService {

    private final HotelDAO hotelDAO;

    @Autowired
    public HotelService(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    public void addHotel(Hotel hotel) {
        hotelDAO.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return (List<Hotel>) hotelDAO.findAll();
    }

    public Hotel getHotelByID(UUID id) {
        ArrayList<Hotel> hotelArrayList = (ArrayList) hotelDAO.findAll();
        Hotel matchedHotel = null;
        for(Hotel hotel : hotelArrayList) {
            if (hotel.getId().compareTo(id) == 0) {
                matchedHotel = hotel;
            }
        }
        return matchedHotel;
    }

    public void deleteHotel(UUID id) {
        Hotel hotel = this.getHotelByID(id);
        hotelDAO.delete(hotel);
    }

    public void deleteAllHotels() {
        hotelDAO.deleteAll();
    }
}
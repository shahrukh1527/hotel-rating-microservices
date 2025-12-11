package com.lcwd.rating.service.service;

import com.lcwd.rating.service.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel saveHotel(Hotel hotel);

    List<Hotel> getAllHotel();

    Hotel getHotel(String hotelId);
}

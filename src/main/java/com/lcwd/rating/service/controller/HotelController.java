package com.lcwd.rating.service.controller;

import com.lcwd.rating.service.entities.Hotel;
import com.lcwd.rating.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotelResponse =hotelService.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelResponse);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId){
        Hotel hotelResponse =hotelService.getHotel(hotelId);
        return ResponseEntity.ok(hotelResponse);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllhotel(){
        List<Hotel> hotelResponse =hotelService.getAllHotel();
        return ResponseEntity.ok(hotelResponse);
    }
}

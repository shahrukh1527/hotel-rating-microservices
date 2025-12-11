package com.lcwd.rating.service.controller;

import com.lcwd.rating.service.entities.Rating;
import com.lcwd.rating.service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createrating(@RequestBody Rating rating){
        Rating ratingResponse =ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingResponse);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getSinglerating(@PathVariable String ratingId){
        Rating ratingResponse =ratingService.getRating(ratingId);
        return ResponseEntity.ok(ratingResponse);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        List<Rating> ratingResponse =ratingService.getRatingsByUserId(userId);
        return ResponseEntity.ok(ratingResponse);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllrating(){
        List<Rating> ratingResponse =ratingService.getAllRating();
        return ResponseEntity.ok(ratingResponse);
    }
}

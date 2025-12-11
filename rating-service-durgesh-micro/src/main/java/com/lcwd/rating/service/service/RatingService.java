package com.lcwd.rating.service.service;

import com.lcwd.rating.service.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating saveRating(Rating rating);

    List<Rating> getAllRating();

    Rating getRating(String ratingId);

    List<Rating> getRatingsByUserId(String userId);
}

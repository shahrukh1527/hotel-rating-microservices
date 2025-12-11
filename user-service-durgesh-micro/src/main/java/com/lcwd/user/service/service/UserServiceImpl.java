package com.lcwd.user.service.service;

import com.lcwd.user.service.client.HotelClient;
import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exception.ResourceNotFoundException;
import com.lcwd.user.service.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelClient hotelClient;

    private Logger logger  = LoggerFactory.getLogger(UserService.class);

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {

        Rating[] ratingsOfUser =restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
        logger.info("{} ",ratingsOfUser);

        List<Rating> ratings =Arrays.stream(ratingsOfUser).toList();


        User user =userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found in db with Id: "+userId));

        List<Rating> ratingList = ratings.stream().map(rating -> {
//            call hotel service to get hotel with rating id
            Hotel hotel = hotelClient.getHotel(rating.getHotelId());

//            Hotel hotel = forEntity.getBody();

//            logger.info(" getStatusCode:  {} ",forEntity.getStatusCode());

//            set the hotel to rating
            rating.setHotel(hotel);

           return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }
}

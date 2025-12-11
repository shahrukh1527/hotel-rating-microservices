package com.lcwd.rating.service.repositories;

import com.lcwd.rating.service.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}

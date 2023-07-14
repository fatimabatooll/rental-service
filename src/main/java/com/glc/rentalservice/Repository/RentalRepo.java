package com.glc.rentalservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glc.rentalservice.Model.Rental;

@Repository
public interface RentalRepo extends JpaRepository<Rental, Long> {
    
}

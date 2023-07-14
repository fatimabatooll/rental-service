package com.glc.rentalservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glc.rentalservice.Model.Rental;
import com.glc.rentalservice.Repository.RentalRepo;

@RestController
@RequestMapping("/rentals")
@CrossOrigin("*")
public class RentalCon {

    @Autowired
        private final RentalRepo rentalRepo;

        public RentalCon(RentalRepo rentalRepo) {
        this.rentalRepo = rentalRepo;
    }
      @PostMapping("/add")
    public ResponseEntity<Rental> bookRenatal(@RequestBody Rental rental){
         Rental  savedRental= rentalRepo.save(rental);
        return ResponseEntity.ok(savedRental);
    }

}

package com.glc.rentalservice.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long carId;

    private String name;

    private String phoneNumber;

    private String driverLicense;

    private String email;
    private String address;
    private LocalDateTime pickupDateTime;
    private LocalDateTime dropDateTime;
    private double totalPrice;
    public Rental getJson() {
        return null;
    }
}

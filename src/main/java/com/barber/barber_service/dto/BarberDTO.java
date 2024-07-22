package com.barber.barber_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BarberDTO {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String location;
    private String bio;
    private BigDecimal rating;
}

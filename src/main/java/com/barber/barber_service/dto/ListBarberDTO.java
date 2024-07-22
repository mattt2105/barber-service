package com.barber.barber_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListBarberDTO {
    private String name;
    private String phone;
    private String location;
    private String bio;
}

package com.barber.barber_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePasswordDTO {
    private String oldPassword;
    private String newPassword;
}

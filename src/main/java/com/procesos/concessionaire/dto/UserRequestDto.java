package com.procesos.concessionaire.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequestDto {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private LocalDate birthday;

}

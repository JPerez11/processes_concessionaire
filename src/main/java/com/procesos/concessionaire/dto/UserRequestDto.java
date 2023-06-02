package com.procesos.concessionaire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private LocalDate birthday;

}

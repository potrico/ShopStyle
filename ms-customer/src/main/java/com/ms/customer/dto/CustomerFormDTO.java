package com.ms.customer.dto;


import lombok.Data;

import java.time.LocalDateTime;


@Data
public class CustomerFormDTO {
    private String firstName;
    private String lastName;
    private String sex;
    private String cpf;
    private LocalDateTime birthdate;
    private String email;
    private String password;
    private boolean active;

}

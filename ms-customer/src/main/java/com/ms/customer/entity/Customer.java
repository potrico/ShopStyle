package com.ms.customer.entity;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "TB_CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    @Pattern(regexp = "Masculino|Feminino")
    private String sex;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime birthdate;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean active = true;
}

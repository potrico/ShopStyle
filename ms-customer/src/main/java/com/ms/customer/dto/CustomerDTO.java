package com.ms.customer.dto;


import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class CustomerDTO {
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String firstName;

    @NotBlank
    @Size(min = 3)
    private String lastName;

    @NotBlank
    @Pattern(regexp = "Masculino|Feminino", message = "O campo apenas permite valores 'Masculino' ou 'Feminino'" )
    private String sex;

    @NotBlank
    @CPF(message = "O campo cpf precisa seguir o seguinte padrão (xxx-xxx-xxx-xx)")
    private String cpf;

    @NotBlank
    private LocalDateTime birthdate;

    @NotBlank
    @Email(message = "Email Deve estar em formato valido")
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private boolean active;
}

package com.gamboa.api_restaurant.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupRequestDTO {
    //
    @NotBlank
    private String firstName;
    @NotBlank(message = "Apellido es obligatorio")
    private String lastName;
    @Email(message = "Correo Invalido")
    @NotBlank(message = "correo es obligatorio")
    private String email;
    @NotBlank(message = "contrasena es obligatorio")
    //Size tiene que soportar hasta 4 caracteres
    @Size(min = 4)
    private String password;
}

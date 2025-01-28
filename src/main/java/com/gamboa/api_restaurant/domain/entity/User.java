package com.gamboa.api_restaurant.domain.entity;

import com.gamboa.api_restaurant.domain.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name",nullable = false)
    private String firstName;
    @Column(name="last_name",nullable = false)
    private String lastName;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="password",nullable = false)
    private String password;
    //Se utiliza el tipo de String para almacenar el nombre(ROlE=ADMIN, USER)
    //Si Se utiliza Ordinal se almacenaria la posicion(ROLE= 1, 2)
    @Enumerated(EnumType.STRING)
    private Role role;

}

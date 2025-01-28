package com.gamboa.api_restaurant.dto.response;

import com.gamboa.api_restaurant.domain.enums.Role;
import lombok.Data;

@Data
public class UserProfileResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}

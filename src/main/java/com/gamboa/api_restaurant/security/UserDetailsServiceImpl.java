package com.gamboa.api_restaurant.security;

import com.gamboa.api_restaurant.domain.entity.User;
import com.gamboa.api_restaurant.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException{
        User user = userRepository.findOneByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException(username));
        //El user generado es del mismo spring security
        return org.springframework.security.core.userdetails.User
                //Indicando que el user es el Email
                .withUsername(user.getEmail())
                .password(user.getPassword())
                //Los roles del Enum
                .roles(user.getRole().name())
                .build();
    }

}

package com.gamboa.api_restaurant.controller;


import com.gamboa.api_restaurant.dto.request.AuthRequestDTO;
import com.gamboa.api_restaurant.dto.request.SignupRequestDTO;
import com.gamboa.api_restaurant.dto.response.AuthResponseDTO;
import com.gamboa.api_restaurant.dto.response.UserProfileResponseDTO;
import com.gamboa.api_restaurant.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UserService userService;
  //Inicio de sesion
  @PostMapping("/sign-in")
  public ResponseEntity<AuthResponseDTO> signIn(@RequestBody AuthRequestDTO authRequest) {
    AuthResponseDTO authResponse = userService.signIn(authRequest);
    return new ResponseEntity<>(authResponse, HttpStatus.OK);
  }

  //Registro de sesion
  @PostMapping("/sign-up")
  public ResponseEntity<UserProfileResponseDTO> register(@RequestBody @Validated SignupRequestDTO signupRequestDTO) {
    UserProfileResponseDTO userProfileResponseDTO = userService.signup(signupRequestDTO);
    return new ResponseEntity<>(userProfileResponseDTO, HttpStatus.CREATED);
  }

}

package com.gamboa.api_restaurant.exception;

public class UserNotAuthenticatedException extends RuntimeException {

  public UserNotAuthenticatedException() {
    super();
  }

  public UserNotAuthenticatedException(String message) {
    super(message);
  }
}

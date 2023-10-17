package com.example.javaspringcrudapplication.user;

public class UserNotFoundException extends Throwable {
  public UserNotFoundException(String message) {
    super(message);
  }
}

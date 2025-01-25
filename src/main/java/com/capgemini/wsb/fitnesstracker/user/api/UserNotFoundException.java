package com.capgemini.wsb.fitnesstracker.user.api;

import com.capgemini.wsb.fitnesstracker.exception.api.NotFoundException;

@SuppressWarnings("squid:S110")
public class UserNotFoundException extends NotFoundException {

    private UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Long id) {
        this("Użytkownik o ID=%s nie został odnaleziony".formatted(id));
    }

}

package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.exception.api.NotFoundException;


@SuppressWarnings("squid:S110")
public class TrainingNotFoundException extends NotFoundException {

    private TrainingNotFoundException(String message) {
        super(message);
    }
    public TrainingNotFoundException(Long id) {
        this("Trening o danym ID nie został odnaleziony".formatted(id));
    }
}

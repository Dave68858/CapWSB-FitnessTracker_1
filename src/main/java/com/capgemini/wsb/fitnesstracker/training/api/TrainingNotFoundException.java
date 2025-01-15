package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.exception.api.NotFoundException;

/**
 @link Training
 */
@SuppressWarnings("squid:S110")
public class TrainingNotFoundException extends NotFoundException {

    /**
     * @param message 
     */
    private TrainingNotFoundException(String message) {
        super(message);
    }

    /**
     * @param id 
     */
    public TrainingNotFoundException(Long id) {
        this(String.format("Training with ID %d was not found", id));
    }
}

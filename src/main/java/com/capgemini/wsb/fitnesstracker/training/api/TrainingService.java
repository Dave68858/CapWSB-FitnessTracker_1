package com.capgemini.wsb.fitnesstracker.training.api;

import java.util.Map;
public interface TrainingService {
    Training createTraining(Training training);
    Training updateTraining(Long id, Training training);
    Training partiallyUpdateTraining(Long id, Map<String, Object> updates);
    void deleteTraining(Long id);
}
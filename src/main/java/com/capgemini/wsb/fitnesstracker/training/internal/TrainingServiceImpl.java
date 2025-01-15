package com.capgemini.wsb.fitnesstracker.training.internal;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingNotFoundException;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingProvider;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingService;
import com.capgemini.wsb.fitnesstracker.user.api.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrainingServiceImpl implements TrainingService, TrainingProvider {

    private final TrainingRepository trainingRepository;

    @Override
    public Optional<Training> getTraining(final Long trainingId) {
        return trainingRepository.findById(trainingId);
    }

    @Override
    public List<Training> findAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public List<Training> findTrainingByUser(final Long userId) {
        return trainingRepository.findByUserId(userId);
    }

    @Override
    public List<Training> findByUserObject(User user) {
        return trainingRepository.findByUserObject(user);
    }

    @Override
    public List<Training> findFinishedTrainings(final Date afterTime) {
        return trainingRepository.findByEndTimeAfter(afterTime);
    }

    @Override
    public List<Training> findTrainingsByActivityType(ActivityType activityType) {
        return trainingRepository.findByActivityType(activityType);
    }

    @Override
    public Training createTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public Training updateTraining(Long id, Training training) {
        if (!trainingRepository.existsById(id)) {
            throw new TrainingNotFoundException(id);
        }
        training.setId(id);
        return trainingRepository.save(training);
    }

    @Override
    public Training partiallyUpdateTraining(Long id, Map<String, Object> updates) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new TrainingNotFoundException(id));
        updates.forEach((key, value) -> {
            switch (key) {
                case "startTime" -> training.setStartTime((Date) value);
                case "endTime" -> training.setEndTime((Date) value);
                case "activityType" -> training.setActivityType((ActivityType) value);
                case "distance" -> training.setDistance((Double) value);
                case "averageSpeed" -> training.setAverageSpeed((Double) value);
                default -> throw new IllegalArgumentException("Invalid field: " + key);
            }
        });
        return trainingRepository.save(training);
    }

    @Override
    public void deleteTraining(Long id) {
        if (!trainingRepository.existsById(id)) {
            throw new TrainingNotFoundException(id);
        }
        trainingRepository.deleteById(id);
    }
}
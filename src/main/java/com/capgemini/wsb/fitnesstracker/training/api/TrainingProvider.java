package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import java.util.Date;
import java.util.List;
import java.util.Optional;
public interface TrainingProvider {


    Optional<User> getTraining(Long trainingId);


    List<Training> findAllTrainings();


    List<Training> findTrainingByUser(Long userId);


    List<Training> findByUserObject(User user);


    List<Training> findFinishedTrainings(Date endTime);


    List<Training> findTrainingsByActivityType(ActivityType activityType);

}
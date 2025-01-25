package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    default List<Training> findByUserId(Long userId) {
        return findAll().stream()
                .filter(training -> training.getUser().getId().equals(userId))
                .toList();
    }

    default List<Training> findByUserObject(User user) {
        return findAll().stream()
                .filter(training -> Objects.equals(training.getUser(), user))
                .collect(Collectors.toList());
    }

    default List<Training> findByEndTimeAfter(Date afterTime) {
        return findAll().stream().filter(
                training -> Objects.compare(training.getEndTime(), afterTime, Comparator.naturalOrder()) > 0
        ).collect(Collectors.toList());
    }

    default List<Training> findByActivityType(ActivityType activityType){
        return findAll().stream().filter(
                training -> Objects.equals(training.getActivityType(), activityType)
        ).collect(Collectors.toList());
    }
}


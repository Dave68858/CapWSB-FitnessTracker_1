package com.capgemini.wsb.fitnesstracker.loader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.LocalDate.now;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Component
@Profile("loadInitialData")
@Slf4j
@ToString
class InitialDataLoader {

    @Autowired
    private JpaRepository<User, Long> userRepository;

    @Autowired
    private JpaRepository<Training, Long> trainingRepository;

    @EventListener
    @Transactional
    @SuppressWarnings({"squid:S1854", "squid:S1481", "squid:S1192", "unused"})
    public void loadInitialData(ContextRefreshedEvent event) {
        verifyDependenciesAutowired();

        log.info("Loading initial data to the database");

        List<User> sampleUserList = generateSampleUsers();
        List<Training> sampleTrainingList = generateTrainingData(sampleUserList);

        log.info("Finished loading initial data");
    }

    private void verifyDependenciesAutowired() {
        if (isNull(userRepository) || isNull(trainingRepository)) {
            throw new IllegalStateException("Repositories are not properly autowired");
        }
    }

    private List<User> generateSampleUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("John", "Doe", now().minusYears(30), "john.doe@example.com"));
        users.add(new User("Jane", "Smith", now().minusYears(25), "jane.smith@example.com"));
        return userRepository.saveAll(users);
    }

    private List<Training> generateTrainingData(List<User> users) {
        List<Training> trainings = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            trainings.add(new Training(users.get(0), sdf.parse("2023-01-01 10:00:00"), sdf.parse("2023-01-01 11:00:00"), ActivityType.RUNNING, 5.0, 10.0));
            trainings.add(new Training(users.get(1), sdf.parse("2023-01-02 10:00:00"), sdf.parse("2023-01-02 11:00:00"), ActivityType.CYCLING, 20.0, 20.0));
        } catch (ParseException e) {
            log.error("Error parsing date", e);
        }
        return trainingRepository.saveAll(trainings);
    }
}

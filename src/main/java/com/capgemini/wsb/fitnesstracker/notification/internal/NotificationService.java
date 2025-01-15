package com.capgemini.wsb.fitnesstracker.notification.internal;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.capgemini.wsb.fitnesstracker.mail.api.EmailProvider;
import com.capgemini.wsb.fitnesstracker.mail.api.EmailSender;
import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingProvider;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserProvider;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Service
@Slf4j
@EnableScheduling
public class NotificationService {
    private final EmailSender emailSender;
    private final EmailProvider emailProvider;
    private final TrainingProvider trainingProvider;
    private final UserProvider userProvider;
    private final String reportString = "Monthly report";

    @Scheduled(cron = "0 0 9 1 * *")
    public void generateReportAndSendMail() {
        log.info("Cron scheduling report generation");
        List<User> allUsers = userProvider.findAllUsers();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneMonthAgo = now.minus(1, ChronoUnit.MONTHS);

        for (User user : allUsers) {
            List<Training> recentTrainings = getRecentTrainings(user, oneMonthAgo);
            
        }
    }

    private List<Training> getRecentTrainings(User user, LocalDateTime oneMonthAgo) {
        Date oneMonthAgoDate = Date.from(oneMonthAgo.atZone(ZoneId.systemDefault()).toInstant());
        return trainingProvider.findTrainingByUser(user.getId())
                .stream()
                .filter(training -> training.getEndTime().after(oneMonthAgoDate))
                .collect(Collectors.toList());
    }
}
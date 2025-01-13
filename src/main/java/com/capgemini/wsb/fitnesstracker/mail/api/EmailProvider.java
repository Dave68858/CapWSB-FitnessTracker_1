package com.capgemini.wsb.fitnesstracker.mail.api;

import java.util.List;
import com.capgemini.wsb.fitnesstracker.training.api.Training;

public interface EmailProvider {

    EmailDto sendMail(String to, String subject, List<Training> trainingList);
}

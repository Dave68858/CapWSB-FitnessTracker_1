package com.capgemini.wsb.fitnesstracker.training.internal;

import java.util.Date;
import io.micrometer.common.lang.Nullable;

public record TrainingDtoWithUserId(
        @Nullable Long id,Long userId,Date startTime,Date endTime,ActivityType activityType,double distance,double averageSpeed
) {
    
}


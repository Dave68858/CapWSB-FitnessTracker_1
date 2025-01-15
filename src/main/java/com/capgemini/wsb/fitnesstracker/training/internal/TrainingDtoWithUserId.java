package com.capgemini.wsb.fitnesstracker.training.internal;

import java.util.Date;
import io.micrometer.common.lang.Nullable;

/**
 * @param id 
 * @param userId 
 * @param startTime 
 * @param endTime 
 * @param activityType 
 * @param distance 
 * @param averageSpeed 
 */
public record TrainingDtoWithUserId(
        @Nullable Long id,
        Long userId,
        Date startTime,
        Date endTime,
        ActivityType activityType,
        double distance,
        double averageSpeed
) {
}

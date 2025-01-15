package com.capgemini.wsb.fitnesstracker.training.internal;

import java.util.Date;
import com.capgemini.wsb.fitnesstracker.user.api.UserDto;
import io.micrometer.common.lang.Nullable;

/**
 * @param id 
 * @param user 
 * @param startTime 
 * @param endTime 
 * @param activityType 
 * @param distance 
 * @param averageSpeed 
 */
public record TrainingDto(
        @Nullable Long id,
        UserDto user,
        Date startTime,
        Date endTime,
        ActivityType activityType,
        double distance,
        double averageSpeed
) {
}

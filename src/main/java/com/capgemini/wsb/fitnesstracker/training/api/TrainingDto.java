package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;
import com.capgemini.wsb.fitnesstracker.user.api.UserDto;
import jakarta.annotation.Nullable;

import java.util.Date;

public record TrainingDto( @Nullable Long id, UserDto user,Date startTime, Date endTime,ActivityType activityType, double distance,double averageSpeed
){

}
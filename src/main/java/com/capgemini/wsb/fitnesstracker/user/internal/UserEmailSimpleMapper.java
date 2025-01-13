package com.capgemini.wsb.fitnesstracker.user.internal;

import org.springframework.stereotype.Component;
import com.capgemini.wsb.fitnesstracker.user.api.User;

@Component
class UserEmailSimpleMapper {

    UserEmailSimpleDto toEmailSimpleDto(User user) {
        return new UserEmailSimpleDto(user.getId(), user.getEmail());
    }

    User toSimpleEmailEntity(UserEmailSimpleDto userDto) {
        return new User(null, null, null, userDto.email());
    }
}

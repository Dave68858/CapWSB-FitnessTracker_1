package com.capgemini.wsb.fitnesstracker.user.internal;

import org.springframework.stereotype.Component;
import com.capgemini.wsb.fitnesstracker.user.api.User;

@Component
class UserSimpleMapper {

    UserSimpleDto toSimpleDto(User user) {
        return new UserSimpleDto(user.getId(), user.getFirstName(), user.getLastName());
    }

    User toSimpleEntity(UserSimpleDto userDto) {
        return new User(userDto.firstName(), userDto.lastName(), null, null);
    }
}

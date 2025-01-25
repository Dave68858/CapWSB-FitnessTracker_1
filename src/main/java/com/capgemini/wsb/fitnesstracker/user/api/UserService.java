package com.capgemini.wsb.fitnesstracker.user.api;

public interface UserService {

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long userId);

}

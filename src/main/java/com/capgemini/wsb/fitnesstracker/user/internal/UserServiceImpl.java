package com.capgemini.wsb.fitnesstracker.user.internal;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserProvider;
import com.capgemini.wsb.fitnesstracker.user.api.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
class UserServiceImpl implements UserService, UserProvider {

    private final UserRepository userRepository;

    @Override
    public User createUser(final User user) {
        log.info("Creating user {}", user);
        if (user.getId() != null) {
            throw new IllegalArgumentException("User already has an ID, update is not allowed!");
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(final Long id, final User user) {
        log.info("Updating user {}", user);
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User with ID " + id + " does not exist, creation is not allowed!");
        }
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(final Long userId) {
        log.info("Deleting user with ID {}", userId);
        userRepository.deleteById(userId);
    }

    @Override
    public Optional<User> getUser(final Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findUsersByEmailFragment(String emailFragment) {
        return userRepository.findByEmailFragmentIgnoreCase(emailFragment);
    }

    @Override
    public List<User> findUsersByBirthDateBefore(LocalDate date) {
        return userRepository.findByBirthDateBefore(date);
    }
}
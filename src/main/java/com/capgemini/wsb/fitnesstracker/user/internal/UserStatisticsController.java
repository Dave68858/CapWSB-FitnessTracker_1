package com.capgemini.wsb.fitnesstracker.user.internal;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.wsb.fitnesstracker.user.api.User;

@RestController
public class UserStatisticsController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/by-email-fragment")
    public List<User> getUsersByEmailFragment(@RequestParam String emailFragment) {
        return userRepository.findByEmailFragmentIgnoreCase(emailFragment);
    }

    @GetMapping("/users/by-birthdate-before")
    public List<User> getUsersByBirthDateBefore(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return userRepository.findByBirthDateBefore(date);
    }

    @GetMapping("/users/count")
    public long getUserCount() {
        return userRepository.count();
    }
    
    @GetMapping("/users/by-first-name")
    public List<User> getUsersByFirstName(@RequestParam String firstName) {
        return userRepository.findByFirstNameIgnoreCase(firstName);
    }
}
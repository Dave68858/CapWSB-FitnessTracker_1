package com.capgemini.wsb.fitnesstracker.user.internal;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.wsb.fitnesstracker.user.api.User;

@Repository
interface UserRepository extends JpaRepository<User, Long> {

    default Optional<User> findByEmail(String email) {
        return findAll().stream()
                        .filter(user -> Objects.equals(user.getEmail(), email))
                        .findFirst();
    }

    default List<User> findByEmailFragmentIgnoreCase(String emailFragment) {
        return findAll().stream()
                        .filter(user -> user.getEmail().toLowerCase().contains(emailFragment.toLowerCase()))
                        .toList();
    }

    default List<User> findByBirthDateBefore(LocalDate date) {
        return findAll().stream()
                        .filter(user -> user.getBirthdate().isBefore(date))
                        .toList();
    }
}


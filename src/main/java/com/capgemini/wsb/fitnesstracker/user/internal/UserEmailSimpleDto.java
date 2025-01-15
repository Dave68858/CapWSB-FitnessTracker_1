package com.capgemini.wsb.fitnesstracker.user.internal;

import jakarta.annotation.Nullable;

/**
 * @param id 
 * @param email 
 */
public record UserEmailSimpleDto(@Nullable Long id, String email) {
}

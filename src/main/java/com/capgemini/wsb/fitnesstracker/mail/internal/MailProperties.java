package com.capgemini.wsb.fitnesstracker.mail.internal;

import com.capgemini.wsb.fitnesstracker.mail.api.EmailSender;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Konfiguracja {@link EmailSender} (dodatek do konfiguracji Spring {@link JavaMailSender} dokona automatycznej konfiguracji).
 */
@ConfigurationProperties(prefix = "mail")
@Getter
@RequiredArgsConstructor
class MailProperties {
    private final String from;
}

package com.capgemini.wsb.fitnesstracker.training.internal;

/**
 * Wyliczenia prezentujące różne typy działań.
 */
public enum ActivityType {

    RUNNING("Bieganie"),
    CYCLING("Jazda na rowerze"),
    WALKING("Chód"),
    SWIMMING("Pływanie"),
    TENNIS("Tenis");

    private final String displayName;

    ActivityType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Pobiera wyświetlaną nazwę typu aktywności.
     *
     * @return wyświetlana nazwa typu aktywości
     */
    public String getDisplayName() {
        return displayName;
    }
}

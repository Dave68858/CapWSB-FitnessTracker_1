package com.capgemini.wsb.fitnesstracker.training.internal;

/**
 * Wyliczenia prezentujące różne typy działań.
 */
public enum ActivityType {

    RUNNING("Running"),
    CYCLING("Cycling"),
    WALKING("Walking"),
    SWIMMING("Swimming"),
    TENNIS("Tennis");

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

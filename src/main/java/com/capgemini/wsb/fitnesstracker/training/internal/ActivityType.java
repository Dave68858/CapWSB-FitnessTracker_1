package com.capgemini.wsb.fitnesstracker.training.internal;


public enum ActivityType {

    RUNNING("Bieganie"),CYCLING("Jazda na rowerze"), WALKING("Chód"),SWIMMING("Pływanie"), TENNIS("Tenis");

    private final String displayName;

    ActivityType(String displayName) 
    {    this.displayName = displayName;

    }
    public String getDisplayName() {
        return displayName;
    }
}

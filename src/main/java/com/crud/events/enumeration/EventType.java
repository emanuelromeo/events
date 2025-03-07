package com.crud.events.enumeration;

public enum EventType {
    CONFERENCE("Conference"),
    WORKSHOP("Workshop"),
    SEMINARY("Seminary");

    private final String description;

    EventType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

package com.order66.team66.spacetraderapp.models;

/**
 * Stores Spaceship types and their names
 */
public enum Spaceship {

    /** Spaceship Types */
    GNAT("Gnat"),
    NULL("N/A");

    /** Name of spaceship to be displayed */
    private String name;

    /**
     * Makes a Spaceship
     *
     * @param name name of spaceship
     */
    Spaceship(String name) {
        this.name = name;
    }

    /**
     * Gets name of spaceship
     *
     * @return spaceship name
     */
    public String getName() {
        return name;
    }
}

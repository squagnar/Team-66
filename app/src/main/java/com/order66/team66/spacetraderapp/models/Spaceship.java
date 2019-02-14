package com.order66.team66.spacetraderapp.models;

public enum Spaceship {

    /**
     * Spaceship Types
     */
    GNAT("Gnat");

    /** Name of spaceship to be displayed */
    private String name;

    /**
     *
     * @param name
     */
    Spaceship(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
}

package com.order66.team66.spacetraderapp.models;

/**
 * Stores Spaceship types and their names
 */
public enum Spaceship {

    /** Spaceship Types */
    GNAT("Gnat", 2),
    YAMATO("Battleship Yamato", 20),
    NULL("N/A", 0);

    /** Name of spaceship to be displayed */
    private String name;
    private int fuelCap;

    /**
     * Makes a Spaceship
     *
     * @param name name of spaceship
     */
    Spaceship(String name, int fuelCap) {
        this.name = name;
        this.fuelCap = fuelCap;
    }

    /**
     * Gets name of spaceship
     *
     * @return spaceship name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the maximum fuel held by the spaceship
     *
     * @return fuel Capacity
     */
    public int getFuelCap() {
        return fuelCap;
    }
}

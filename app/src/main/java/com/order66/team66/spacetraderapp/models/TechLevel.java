package com.order66.team66.spacetraderapp.models;

import java.util.Arrays;
import java.util.List;

/**
 * Represents Different Solar System Tech Levels
 */
public enum TechLevel {

    /**
     * Tech Levels in Order
     */
    PREAGRICULTURE("Pre-Agriculture"),
    AGRICULTURE("Agriculure"),
    MEDIEVAL("Medieval"),
    RENAISSANCE("Renaissance"),
    EARLYINDUSTRIAL("Early Industrial"),
    INDUSTRIAL("Industrial"),
    POSTINDUSTRIAL("Post-Industrial"),
    HITECH("Hi-Tech");

    /** Name of Tech Level */
    private String name;

    /**
     * Makes TechLevel
     *
     * @param name name of level to be displayed
     */
    TechLevel(String name) {
        this.name = name;
    }

    /**
     * Returns level name
     *
     * @return level name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a random Tech Level
     *
     * @return resource type
     */
    public static TechLevel getRandom() {
        List<TechLevel> techLevels = Arrays.asList(TechLevel.values());
        return techLevels.get((int)(Math.random() * techLevels.size()));
    }
}

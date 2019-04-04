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
    PREAGRICULTURE("Pre-Agriculture", 0),
    AGRICULTURE("Agriculure", 1),
    MEDIEVAL("Medieval", 2),
    RENAISSANCE("Renaissance", 3),
    EARLYINDUSTRIAL("Early Industrial", 4),
    INDUSTRIAL("Industrial", 5),
    POSTINDUSTRIAL("Post-Industrial", 6),
    HITECH("Hi-Tech", 7);

    /** Name of Tech Level */
    private String name;
    private int levelNumber;

    /**
     * Makes TechLevel
     *
     * @param name name of level to be displayed
     */
    TechLevel(String name, int levelNumber) {
        this.name = name;
        this.levelNumber = levelNumber;
    }

    TechLevel() {

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
     * Returns numeric representation of the tech level
     *
     * @return number representing the tech level
     */
    public int getLevelNumber() {
        return levelNumber;
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

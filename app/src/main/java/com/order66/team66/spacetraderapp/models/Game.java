package com.order66.team66.spacetraderapp.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Stores Game Data
 */
public class Game {

    /** Game Difficulty */
    private Difficulty difficulty;

    /** Game's Player */
    private Player player;

    /** Game Solar System */
    private static List<SolarSystem> solarSystems;

    /** Max X and Y Coordinates in Game */
    public static final int MAX_X_COORDINATES = 150;
    public static final int MAX_Y_COORDINATES = 100;



    public static List<SolarSystem> createSolarSystem() {
        solarSystems = new ArrayList<>();
        List<String> planetNames = Arrays.asList(SolarSystem.planetNames);
        Collections.shuffle(planetNames);
        int[][] coordinates = new int[MAX_X_COORDINATES][MAX_Y_COORDINATES];
        int planets = 0;
        SolarSystem curr = null;
        for (String name: planetNames) {
            // If planets == 0, make a new Solar System
            if (planets == 0) {
                // New number of planets for Solar System
                planets = (int) (Math.random() * 12) + 1;
                // Find coordinates for new Solar System
                int x = -1;
                int y = -1;
                boolean found = false;
                while (!found) {
                    x = (int) (Math.random() * (coordinates.length));
                    y = (int) (Math.random() * (coordinates[0].length));
                    if (coordinates[x][y] != -1) {
                        found = true;
                        coordinates[x][y] = -1;
                    }
                }
                // Makes solar system
                curr = new SolarSystem(name, x, y);
                solarSystems.add(curr);
            }
            // Choose Tech Level
            TechLevel techLevel = TechLevel.getRandom();
            // Choose Resource
            Resource resource = Resource.getRandom();
            curr.addPlanet(new Planet(name, techLevel, resource, curr));
            planets--;
        }
        return solarSystems;
    }
}


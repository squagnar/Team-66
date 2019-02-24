package com.order66.team66.spacetraderapp.models;

/**
 * Planets in a Solar System
 */
public class Planet {

    private String name;

    // Solar System of Planet
    private SolarSystem solarSystem;

    // TODO: Implement Markets
//    private Market market

    /**
     * Makes planet
     *
     * @param name planet's name
     * @param solarSystem planet's solar system
     */
    public Planet(String name, SolarSystem solarSystem) {
        this.name = name;
        this.solarSystem = solarSystem;
    }

    /**
     * Gets Planet's Solar System
     *
     * @return solar system
     */
    public SolarSystem getSolarSystem() {
        return solarSystem;
    }

    /**
     * Gets planet name
     *
     * @return planet name
     */
    public String getName() {
        return name;
    }

}

package com.order66.team66.spacetraderapp.models;

/**
 * Planets in a Solar System
 */
public class Planet {

    private String name;

    // Solar System of Planet
    private SolarSystem solarSystem;

    /** Has one tech level */
    private TechLevel techLevel;

    /** Has one predominant resource */
    private ResourceModifier WorldModifier;

    // TODO: Implement Markets
//    private Market market

    /**
     * Makes planet
     *
     * @param name planet's name
     * @param solarSystem planet's solar system
     */
    public Planet(String name, TechLevel techLevel, ResourceModifier WorldModifier, SolarSystem solarSystem) {
        this.name = name;
        this.techLevel = techLevel;
        this.WorldModifier = WorldModifier;
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

    public String toString() {
        return "Planet Name: " + name + "\n" +
                "Tech Level: " + techLevel.getName() + "\n" +
                "Resource: " + WorldModifier.getName() + "\n";
    }

}

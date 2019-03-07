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
    private ResourceEvent resourceEvent;

    // TODO: Implement Markets
//    private Market market

    /**
     * Makes planet
     *
     * @param name planet's name
     * @param solarSystem planet's solar system
     */
    public Planet(String name, TechLevel techLevel, ResourceEvent resourceEvent, SolarSystem solarSystem) {
        this.name = name;
        this.techLevel = techLevel;
        this.resourceEvent = resourceEvent;
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
                "Resource: " + resourceEvent.getName() + "\n";
    }

}

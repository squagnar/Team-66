package com.order66.team66.spacetraderapp.models;

import com.google.firebase.database.Exclude;

/**
 * Planets in a Solar System
 */
public class Planet {

    private String name;

    // Solar System of Planet
    @Exclude
    private SolarSystem solarSystem;

    // Market of Planet
    private Market market;

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
    public Planet(String name, TechLevel techLevel, ResourceModifier worldModifier, SolarSystem solarSystem) {
        this.name = name;
        this.techLevel = techLevel;
        this.WorldModifier = worldModifier;
        this.solarSystem = solarSystem;
        this.market = new Market(worldModifier, techLevel);
    }

    /**
     * Gets Planet's Solar System
     *
     * @return solar system
     */
    @Exclude
    public SolarSystem getSolarSystem() {
        return solarSystem;
    }

    /**
     * Gets Planet's Market
     *
     * @return market
     */
    public Market getMarket() { return  market; }

    /**
     * Gets planet name
     *
     * @return planet name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Planet Name: " + name + "\n" +
                "Tech Level: " + techLevel.getName() + "\n" +
                "Resource: " + WorldModifier.getName() + "\n";
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof Planet) {
            Planet p = (Planet) other;
            if (name.equals(p.getName())) {
                return true;
            }
        }
        return false;
    }

}

package com.order66.team66.spacetraderapp.models;

import org.jetbrains.annotations.NotNull;

/**
 * Planets in a Solar System
 */
public class Planet {

    private String name;

    // Market of Planet
    private final Market market;

    /** Has one tech level */
    private final TechLevel techLevel;

    /** Has one predominant resource */
    private final ResourceModifier WorldModifier;

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
        this.market = new Market(worldModifier, techLevel);
    }

    public Planet(){

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

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public ResourceModifier getWorldModifier(){
        return WorldModifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Override
    public String toString() {
        return "Planet Name: " + name + "\n" +
                "Tech Level: " + techLevel.getName() + "\n" +
                "Resource: " + WorldModifier.getName() + "\n";
    }

    @Override
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

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
package com.order66.team66.spacetraderapp.models;

import org.jetbrains.annotations.NotNull;

/**
 * Planets in a Solar System
 */
public class Planet {

    private String name;

    // Market of Planet
    private Market market;

    /** Has one tech level */
    private TechLevel techLevel;

    /** Has one predominant resource */
    private ResourceModifier WorldModifier;

    /**
     * Makes new planet
     *
     * @param name planet name
     * @param techLevel planet tech level
     * @param worldModifier planet world modifier
     */
    public Planet(String name, TechLevel techLevel, ResourceModifier worldModifier) {
        this.name = name;
        this.techLevel = techLevel;
        this.WorldModifier = worldModifier;
        this.market = new Market(worldModifier, techLevel);
    }

    /**
     * Firebase constructor
     */
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

    /**
     * Gets planet tech level
     *
     * @return tech level
     */
    public TechLevel getTechLevel() {
        return techLevel;
    }

    /**
     * Gets planet world modifier
     *
     * @return world modifier
     */
    public ResourceModifier getWorldModifier(){
        return WorldModifier;
    }

    /**
     * Sets planet name
     *
     * @param name of planet
     */
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
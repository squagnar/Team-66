package com.order66.team66.spacetraderapp.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents Resources in a Solar System
 */
public enum ResourceModifier {

    /**
     * Types of Resource Modifiers in Order
     */

    /**
     * World Resource Modifiers
     * I.E. Modifiers that change the fundamental supply/price of certain resources on a planet
     */
    NOSPECIALRESOURCES("No Special Resources"),
    MINERALRICH("Mineral Rich"),
    MINERALPOOR("Mineral Poor"),
    DESERT("Desert"),
    LOTSOFWATER("Lots of Water"),
    RICHSOIL("Rich Soil"),
    POORSOIL("Poor Soil"),
    RICHFAUNA("Rich Fauna"),
    LIFELESS("Lifeless"),
    WEIRDMUSHROOMS("Weird Mushrooms"),
    LOTSOFHERBS("Lots of Herbs"),
    ARTISTIC("Artistic"),
    WARLIKE("Warlike"),

    /**
     * Event Resource Modifiers
     * I.E. Modifiers that provide temporary change to the supply/price of certain resources
     */
    DROUGHT("Drought"),

    /** Name of Resource */
    private String name;

    /**
     * Makes Resource
     *
     * @param name name to be displayed
     */
    ResourceModifier(String name) {
        this.name = name;
    }

    /**
     * Returns name of resource to be displayed
     *
     * @return resource name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a random resource
     * NOSPECIALRESOURCES is three times more common
     *
     * @return resource type
     */
    public static ResourceModifier getRandom() {
        List<ResourceModifier> resourceEvents = new ArrayList<>(Arrays.asList(ResourceModifier.values()));
        resourceEvents.add(ResourceModifier.NOSPECIALRESOURCES);
        resourceEvents.add(ResourceModifier.NOSPECIALRESOURCES);
        return resourceEvents.get((int)(Math.random() * resourceEvents.size()));
    }
}

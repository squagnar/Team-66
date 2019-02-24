package com.order66.team66.spacetraderapp.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents Resources in a Solar System
 */
public enum Resource {

    /**
     * Types of Resources in Order
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
    WARLIKE("Warlike");

    /** Name of Resource */
    private String name;

    /**
     * Makes Resource
     *
     * @param name name to be displayed
     */
    Resource(String name) {
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
    public static Resource getRandom() {
        List<Resource> resources = new ArrayList<>(Arrays.asList(Resource.values()));
        resources.add(Resource.NOSPECIALRESOURCES);
        resources.add(Resource.NOSPECIALRESOURCES);
        return resources.get((int)(Math.random() * resources.size()));
    }
}

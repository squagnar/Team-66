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
    NOSPECIALRESOURCES("No Special Resources", "World"),
    MINERALRICH("Mineral Rich", "World"),
    MINERALPOOR("Mineral Poor", "World"),
    DESERT("Desert", "World"),
    LOTSOFWATER("Lots of Water", "World"),
    RICHSOIL("Rich Soil", "World"),
    POORSOIL("Poor Soil", "World"),
    RICHFAUNA("Rich Fauna", "World"),
    LIFELESS("Lifeless", "World"),
    WEIRDMUSHROOMS("Weird Mushrooms", "World"),
    LOTSOFHERBS("Lots of Herbs", "World"),
    ARTISTIC("Artistic", "World"),
    WARLIKE("Warlike", "World"),

    /**
     * Event Resource Modifiers
     * I.E. Modifiers that provide temporary change to the supply/price of certain resources
     */
    DROUGHT("Drought", "Event"),
    COLD("Cold", "Event"),
    CROPFAIL("Crop Failed", "Event"),
    WAR("War", "Event"),
    BOREDOM("Boredom", "Event"),
    PLAGUE("Plague", "Event"),
    LACKOFWORKERS("Lack of Workers", "Event"),
    NULL("No Event", "Event");

    /** Name of Resource */
    private String name;

    /** Type of Modifier */
    private String type;

    /**
     * Makes Resource
     *
     * @param name name to be displayed
     */
    ResourceModifier(String name, String type) {
        this.name = name;
        this.type = type;
    }

    ResourceModifier() {

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
     * Returns a random world modifier
     * NOSPECIALRESOURCES is returned ~50% of the time
     *
     * @return a world modifier
     */
    public static ResourceModifier getRandomWorldMod() {
        List<ResourceModifier> worldModifiers = new ArrayList<>();
        for (ResourceModifier mod: ResourceModifier.values()) {
            if (mod.type.equalsIgnoreCase("World")) {
                worldModifiers.add(mod);

                //This way "No Special Resources" is the most common world type
                worldModifiers.add(ResourceModifier.NOSPECIALRESOURCES);
            }
        }
        return worldModifiers.get((int)(Math.random() * worldModifiers.size()));
    }

    /**
     * Returns a random event modifier
     * All events are equally likely
     *
     * @return an event modifier
     */
    public static ResourceModifier getRandomEventMod() {
        List<ResourceModifier> eventModifiers = new ArrayList<>();
        for (ResourceModifier mod: ResourceModifier.values()) {
            if (mod.type.equalsIgnoreCase("Event")) {
                eventModifiers.add(mod);
            }
        }
        return eventModifiers.get((int)(Math.random() * eventModifiers.size()));
    }
}

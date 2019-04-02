package com.order66.team66.spacetraderapp.models;

import java.util.Random;

/**
 * Represents a given type of trade-able resource
 */
public enum Resource {

    WATER("Water", 0, 0, 2, 30, 3, 4,
            ResourceModifier.DROUGHT, ResourceModifier.LOTSOFWATER, ResourceModifier.DESERT, 30, 50),
    FURS("Furs", 0, 0, 0, 250, 10, 10,
            ResourceModifier.COLD, ResourceModifier.RICHFAUNA, ResourceModifier.LIFELESS, 230, 280),
    FOOD("Food", 1, 0, 1, 100, 5, 5,
            ResourceModifier.CROPFAIL, ResourceModifier.RICHSOIL, ResourceModifier.POORSOIL, 90, 160),
    ORE("Ore", 2, 2, 3, 350, 20, 10,
            ResourceModifier.WAR, ResourceModifier.MINERALRICH, ResourceModifier.MINERALPOOR, 350, 420),
    GAMES("Games", 3, 1, 6, 250, -10, 5,
            ResourceModifier.BOREDOM, ResourceModifier.ARTISTIC, ResourceModifier.NULL, 160, 270),
    FIREARMS("Firearms", 3, 1, 5, 1250, -75, 100,
            ResourceModifier.WAR, ResourceModifier.WARLIKE, ResourceModifier.NULL, 600, 1100),
    MEDICINE("Medicine", 4, 1, 6, 650, -20, 10,
            ResourceModifier.PLAGUE, ResourceModifier.LOTSOFHERBS, ResourceModifier.NULL, 400, 700),
    MACHINES("Machines", 4, 3, 5, 900, -30, 5,
            ResourceModifier.LACKOFWORKERS, ResourceModifier.NULL, ResourceModifier.NULL, 600, 800),
    NARCOTICS("Narcotics", 5, 0, 5, 3500, -125, 150,
            ResourceModifier.BOREDOM, ResourceModifier.WEIRDMUSHROOMS, ResourceModifier.NULL, 2000, 3000),
    ROBOTS("Robots", 6, 4, 7, 5000, -150, 100,
            ResourceModifier.LACKOFWORKERS, ResourceModifier.NULL, ResourceModifier.NULL, 3500, 5000);

    private final String name;
    private final int minTechMake;
    private final int minTechUse;
    private final int optimalTech;
    private final int basePrice;
    private final int priceChangePerTech;
    private final int priceVariance;
    private final ResourceModifier shortageEvent;
    private final ResourceModifier surplusEvent;
    private final ResourceModifier expensiveEvent;
    private final int minTraderPrice;
    private final int maxTraderPrice;

    /**
     * Creates a new Resource object to store the general data about a resource type
     *
     * @param name name of the resource
     * @param minTechMake the min tech level required for a planet to make this resource
     * @param minTechUse the min tech level required for a planet to buy this resource
     * @param optimalTech the tech level where the most of this resource is produced
     * @param basePrice the base price of this resource
     * @param priceChangePerTech the increase in price per tech level for this resource
     * @param priceVariance the price variance for this resource
     * @param shortageEvent the type of ResourceModifier that causes a shortage of this resource
     * @param surplusEvent the type of ResourceModifier that causes a surplus of this resource
     * @param expensiveEvent the type of ResourceModifier that causes a price increase of this resource
     * @param minTraderPrice the minimum amount of this resource a trader selling it can have
     * @param maxTraderPrice the maximum amount of this resource a trader selling it can have
     */
    Resource(String name, int minTechMake, int minTechUse, int optimalTech,
             int basePrice, int priceChangePerTech, int priceVariance,
             ResourceModifier shortageEvent, ResourceModifier surplusEvent, ResourceModifier expensiveEvent,
             int minTraderPrice, int maxTraderPrice) {
        this.name = name;
        this.minTechMake = minTechMake;
        this.minTechUse = minTechUse;
        this.optimalTech = optimalTech;
        this.basePrice = basePrice;
        this.priceChangePerTech = priceChangePerTech;
        this.priceVariance = priceVariance;
        this.shortageEvent = shortageEvent;
        this.surplusEvent = surplusEvent;
        this.expensiveEvent = expensiveEvent;
        this.minTraderPrice = minTraderPrice;
        this.maxTraderPrice = maxTraderPrice;
    }

    /**
     * Gets the name of the resource
     * @return the resource name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public int getMinTechMake() {
        return minTechMake;
    }

    /**
     *
     * @return
     */
    public int getMinTechUse() {
        return minTechUse;
    }

    /**
     *
     * @return
     */
    public int getOptimalTech() {
        return optimalTech;
    }

    /**
     *
     * @return
     */
    public int getBasePrice() {
        return basePrice;
    }

    /**
     *
     * @return
     */
    public int getPriceChangePerTech() {
        return priceChangePerTech;
    }

    /**
     *
     * @return
     */
    public int getPriceVariance() {
        return priceVariance;
    }

    /**
     *
     * @return
     */
    public ResourceModifier getShortageEvent() {
        return shortageEvent;
    }

    /**
     *
     * @return
     */
    public ResourceModifier getSurplusEvent() {
        return surplusEvent;
    }

    /**
     *
     * @return
     */
    public ResourceModifier getExpensiveEvent() {
        return expensiveEvent;
    }

    /**
     *
     * @return
     */
    public int getMinTraderPrice() {
        return minTraderPrice;
    }

    /**
     *
     * @return
     */
    public int getMaxTraderPrice() {
        return maxTraderPrice;
    }

    public int getPrice(int techLevel, ResourceModifier worldMod, ResourceModifier eventMod) {
        int price;
        int variance;
        Random randVariance = new Random();

        variance = randVariance.nextInt(priceVariance + 1);
        if(randVariance.nextBoolean()) { variance *= -1; }

        price = basePrice + (priceChangePerTech * (techLevel - minTechUse)) + variance;

        if(worldMod.equals(shortageEvent) || eventMod.equals(shortageEvent)) {
            price *= 2;
        }

        if(worldMod.equals(surplusEvent) || eventMod.equals(surplusEvent)) {
            price *= .5;
        }

        if(worldMod.equals(expensiveEvent) || eventMod.equals(expensiveEvent)) {
            price *= 1.5;
        }

        return price;
    }

    public int getStock(int techLevel, ResourceModifier worldMod, ResourceModifier eventMod) {
        int stock;
        int optimalDiff = Math.abs(optimalTech - techLevel);

        stock = basePrice * (10 - minTechMake - optimalDiff);

        if(worldMod.equals(shortageEvent) || eventMod.equals(shortageEvent)) {
            stock *= .25;
        }

        if(worldMod.equals(surplusEvent) || eventMod.equals(surplusEvent)) {
            stock *= 2;
        }

        if(worldMod.equals(expensiveEvent) || eventMod.equals(expensiveEvent)) {
            stock *= .5;
        }

        return stock;
    }

}

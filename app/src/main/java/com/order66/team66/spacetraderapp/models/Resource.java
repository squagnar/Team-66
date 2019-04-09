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

    private String name;
    private int minTechMake;
    private int minTechUse;
    private int optimalTech;
    private int basePrice;
    private int priceChangePerTech;
    private int priceVariance;
    private ResourceModifier shortageEvent;
    private ResourceModifier surplusEvent;
    private ResourceModifier expensiveEvent;
    private int minTraderPrice;
    private int maxTraderPrice;

    private static final double eventPriceMod = .5;
    private static final double eventStockMod = .25;

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

    Resource(){

    }

    /**
     * Gets the name of the resource
     *
     * @return the resource name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets min tech to make resource
     *
     * @return min tech to make
     */
    public int getMinTechMake() {
        return minTechMake;
    }

    /**
     * Gets min tech to use resource
     *
     * @return min tech to use
     */
    public int getMinTechUse() {
        return minTechUse;
    }

    /**
     * Gets optimal tech for resource
     *
     * @return optimal tech
     */
    public int getOptimalTech() {
        return optimalTech;
    }

    /**
     * Gets resource base price
     *
     * @return base price
     */
    public int getBasePrice() {
        return basePrice;
    }

    /**
     * Gets price chance per tech
     *
     * @return price change
     */
    public int getPriceChangePerTech() {
        return priceChangePerTech;
    }

    /**
     * Gets resource price variance
     *
     * @return resource price variance
     */
    public int getPriceVariance() {
        return priceVariance;
    }

    /**
     * Gets shortage event
     *
     * @return shortage event
     */
    public ResourceModifier getShortageEvent() {
        return shortageEvent;
    }

    /**
     * Gets surplus event
     *
     * @return surplus event
     */
    public ResourceModifier getSurplusEvent() {
        return surplusEvent;
    }

    /**
     * Gets expensive event
     *
     * @return expensive event
     */
    public ResourceModifier getExpensiveEvent() {
        return expensiveEvent;
    }

    /**
     * Gets min trader price
     *
     * @return min trader price
     */
    public int getMinTraderPrice() {
        return minTraderPrice;
    }

    /**
     * Gets max trader price
     *
     * @return trader price
     */
    public int getMaxTraderPrice() {
        return maxTraderPrice;
    }

    /**
     * Calculates resource price
     *
     * @param techLevel    current tech level
     * @param worldMod     current world modifier
     * @param eventMod     current event modifier
     * @param randVariance random variance
     * @return resource price
     */
    public int getPrice(int techLevel, ResourceModifier worldMod, ResourceModifier eventMod, Random randVariance) {
        int price;
        int variance;
        //Random randVariance = new Random();

        variance = randVariance.nextInt(priceVariance + 1);
        if(randVariance.nextBoolean()) { variance *= -1; }

        price = basePrice + (priceChangePerTech * (techLevel - minTechUse)) + variance;

        if(worldMod.equals(shortageEvent) || eventMod.equals(shortageEvent)) {
            price *= eventPriceMod * 4;
        }

        if(worldMod.equals(surplusEvent) || eventMod.equals(surplusEvent)) {
            price *= eventPriceMod;
        }

        if(worldMod.equals(expensiveEvent) || eventMod.equals(expensiveEvent)) {
            price *= eventPriceMod * 3;
        }

        return price;
    }

    /**
     * Gets resource stock
     *
     * @param techLevel current tech level
     * @param worldMod current world modifier
     * @param eventMod current event modifier
     * @return resource stock
     */
    public int getStock(int techLevel, ResourceModifier worldMod, ResourceModifier eventMod) {
        int stock;
        int optimalDiff = Math.abs(optimalTech - techLevel);

        stock = basePrice * (10 - minTechMake - optimalDiff);

        if(worldMod.equals(shortageEvent) || eventMod.equals(shortageEvent)) {
            stock *= eventStockMod;
        }

        if(worldMod.equals(surplusEvent) || eventMod.equals(surplusEvent)) {
            stock *= eventStockMod * 8;
        }

        if(worldMod.equals(expensiveEvent) || eventMod.equals(expensiveEvent)) {
            stock *= eventStockMod * 2;
        }

        return stock;
    }

}

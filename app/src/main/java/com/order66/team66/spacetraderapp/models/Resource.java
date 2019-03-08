package com.order66.team66.spacetraderapp.models;

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
            ResourceModifier.BOREDOM, ResourceModifier.ARTISTIC, null, 160, 270),
    FIREARMS("Firearms", 3, 1, 5, 1250, -75, 100,
            ResourceModifier.WAR, ResourceModifier.WARLIKE, null, 600, 1100),
    MEDICINE("Medicine", 4, 1, 6, 650, -20, 10,
            ResourceModifier.PLAGUE, ResourceModifier.LOTSOFHERBS, null, 400, 700),
    MACHINES("Machines", 4, 3, 5, 900, -30, 5,
            ResourceModifier.LACKOFWORKERS, null, null, 600, 800),
    NARCOTICS("Narcotics", 5, 0, 5, 3500, -125, 150,
            ResourceModifier.BOREDOM, ResourceModifier.WEIRDMUSHROOMS, null, 2000, 3000),
    ROBOTS("Robots", 6, 4, 7, 5000, -150, 100,
            ResourceModifier.LACKOFWORKERS, null, null, 3500, 5000);

    private String name;
    private int minTechSell;
    private int minTechBuy;
    private int optimalTech;
    private int basePrice;
    private int priceIncPerTech;
    private int priceVariance;
    private ResourceModifier shortageEvent;
    private ResourceModifier surplusEvent;
    private ResourceModifier expensiveEvent;
    private int minTraderStock;
    private int maxTraderStock;

    /**
     * Creates a new Resource object to store the general data about a resource type
     *
     * @param name name of the resource
     * @param minTechSell the min tech level required for a planet to make this resource
     * @param minTechBuy the min tech level required for a planet to buy this resource
     * @param optimalTech the tech level where the most of this resource is produced
     * @param basePrice the base price of this resource
     * @param priceIncPerTech the increase in price per tech level for this resource
     * @param priceVariance the price variance for this resource
     * @param shortageEvent the type of ResourceModifier that causes a shortage of this resource
     * @param surplusEvent the type of ResourceModifier that causes a surplus of this resource
     * @param expensiveEvent the type of ResourceModifier that causes a price increase of this resource
     * @param minTraderStock the minimum amount of this resource a trader selling it can have
     * @param maxTraderStock the maximum amount of this resource a trader selling it can have
     */
    Resource(String name, int minTechSell, int minTechBuy, int optimalTech,
                    int basePrice, int priceIncPerTech, int priceVariance,
                    ResourceModifier shortageEvent, ResourceModifier surplusEvent, ResourceModifier expensiveEvent,
                    int minTraderStock, int maxTraderStock) {
        this.name = name;
        this.minTechSell = minTechSell;
        this.minTechBuy = minTechBuy;
        this.optimalTech = optimalTech;
        this.basePrice = basePrice;
        this.priceIncPerTech = priceIncPerTech;
        this.priceVariance = priceVariance;
        this.shortageEvent = shortageEvent;
        this.surplusEvent = surplusEvent;
        this.expensiveEvent = expensiveEvent;
        this.minTraderStock = minTraderStock;
        this.maxTraderStock = maxTraderStock;
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
    public int getMinTechSell() {
        return minTechSell;
    }

    /**
     *
     * @return
     */
    public int getMinTechBuy() {
        return minTechBuy;
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
    public int getPriceIncPerTech() {
        return priceIncPerTech;
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
    public int getMinTraderStock() {
        return minTraderStock;
    }

    /**
     *
     * @return
     */
    public int getMaxTraderStock() {
        return maxTraderStock;
    }
}

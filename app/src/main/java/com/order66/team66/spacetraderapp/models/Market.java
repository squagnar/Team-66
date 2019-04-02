package com.order66.team66.spacetraderapp.models;


import java.util.EnumMap;
import java.util.Set;

/**
 * Represents the market on a given planet
 */
public class Market {

    ResourceModifier worldModifier;
    ResourceModifier eventModifier = ResourceModifier.NULL;
    int techLevel;

    EnumMap<Resource, Integer> resourceStock = new EnumMap<>(Resource.class);
    EnumMap<Resource, Integer> resourcePrice = new EnumMap<>(Resource.class);
    EnumMap<Resource, Boolean> canUseResource = new EnumMap<>(Resource.class);
    EnumMap<Resource, Boolean> canMakeResource = new EnumMap<>(Resource.class);
    /**
     * Creates a new Market object
     *
     * @param worldModifier the world resource modifier of the associated planet
     * @param techlevel the tech level of the associated planet
     */
    public Market(ResourceModifier worldModifier, TechLevel techlevel) {
        this.worldModifier = worldModifier;
        this.techLevel = techlevel.getLevelNumber();

        generateMarket();
    }

    /**
     * Using the tech level and worldModifier, populates the list of trade goods
     * in this market.
     */
    private void generateMarket(){
        int minTechToUse;
        int minTechToMake;

        for (Resource resource : Resource.values()) {
            minTechToUse = resource.getMinTechUse();
            minTechToMake = resource.getMinTechMake();

            if(techLevel >= minTechToUse) {
                canUseResource.put(resource, true);
                resourcePrice.put(resource, resource.getPrice(techLevel, worldModifier, eventModifier));

                if(techLevel >= minTechToMake) {
                    canMakeResource.put(resource,true);
                    resourceStock.put(resource, resource.getStock(techLevel, worldModifier, eventModifier));
                }
                else {
                    canMakeResource.put(resource, false);
                    resourceStock.put(resource, 0);
                }
            }
            else {
                canUseResource.put(resource, false);
                resourcePrice.put(resource, 0);
                canMakeResource.put(resource, false);
                resourceStock.put(resource, 0);
            }
        }
    }

    /**
     * Returns if this market can buy the given resource from the player
     *
     * @param resource the resource to check
     * @return true if it can be bought from the player, otherwise false
     */
    public boolean canUse(Resource resource) {
        if (canUseResource.containsKey(resource)) {
            return canUseResource.get(resource);
        }
        return false;
    }

    /**
     * Returns if this market can sell the given resource to the player
     *
     * @param resource the resource to check
     * @return true if it can be sold to the player, otherwise false
     */
    public boolean canMake(Resource resource) {
        if (canMakeResource.containsKey(resource)) {
            return canMakeResource.get(resource);
        }
        return false;
    }

    /**
     * Returns the price of the given resource
     *
     * @param resource the resource to check
     * @return the price if it has one, else 0
     */
    public int getPrice(Resource resource) {
        if (resourcePrice.containsKey(resource)) {
            return resourcePrice.get(resource);
        }
        return 0;
    }

    /**
     * Returns the stock of the given resource
     *
     * @param resource the resource to check
     * @return the stock if any is present, else 0
     */
    public int getStock(Resource resource) {
        if (resourceStock.containsKey(resource)) {
            return resourceStock.get(resource);
        }
        return 0;
    }

    /**
     * Returns the current ResourceModifier event for this market
     *
     * @return the current ResourceModifier event, or null if there is none
     */
    public ResourceModifier getCurrentEvent() {
        return eventModifier;
    }

    /**
     * Updates market prices and stock for a new event resource modifier
     *
     * @param eventMod the event resource modifier to change the market
     */
    public void updateMarket(ResourceModifier eventMod) {
        this.eventModifier = eventMod;

        for (Resource resource : Resource.values()) {
            if(canUse(resource)) {
                int newPrice = resource.getPrice(techLevel, worldModifier, eventModifier);
                resourcePrice.put(resource, newPrice);

                if(canMake(resource)) {
                    int newStock = resource.getStock(techLevel, worldModifier, eventModifier);
                    resourceStock.put(resource, newStock);
                }
            }
        }
    }

    /**
     * Increases the stock of the given resource in this market
     *
     * @param resource the resource to modify
     * @param amount the amount to increase stock by
     */
    public void increaseStock(Resource resource, int amount) {
        if (resourceStock.containsKey(resource)) {
            int newStock = resourceStock.get(resource) + amount;
            resourceStock.put(resource, newStock);
        }
    }

    /**
     *  Decreases the stock of the given resource in this market
     *
     * @param resource the resource to modify
     * @param amount the amount to decrease stock by
     */
    public void decreaseStock(Resource resource, int amount) {
        if (resourceStock.containsKey(resource)) {
            int newStock = Math.max(resourceStock.get(resource) - amount, 0);
            resourceStock.put(resource, newStock);
        }
    }

    public Set<Resource> getAvailableResources() {
        return canUseResource.keySet();
    }
}

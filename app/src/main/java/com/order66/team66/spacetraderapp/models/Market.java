package com.order66.team66.spacetraderapp.models;

import java.util.EnumMap;

/**
 * Represents the market on a given planet
 */
public class Market {

    ResourceModifier worldModifier;
    ResourceModifier eventModifier = null;
    int techLevel;

    EnumMap<Resource, Integer> resourceStock = new EnumMap<>(Resource.class);
    EnumMap<Resource, Integer> resourcePrice = new EnumMap<>(Resource.class);
    EnumMap<Resource, Boolean> canBuyResource = new EnumMap<>(Resource.class);
    EnumMap<Resource, Boolean> canSellResource = new EnumMap<>(Resource.class);

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
        int minTechToBuy;
        int minTechToSell;
        int price;
        int stock;

        for (Resource resource : Resource.values()) {
            minTechToBuy = resource.getMinTechBuy();
            minTechToSell = resource.getMinTechSell();

            if(techLevel >= minTechToBuy) {
                canBuyResource.put(resource, true);
                resourcePrice.put(resource, resource.getPrice(techLevel, worldModifier, eventModifier));

                if(techLevel >= minTechToSell) {
                    canSellResource.put(resource,true);
                    resourceStock.put(resource, resource.getStock(techLevel, worldModifier, eventModifier));
                }
            }
        }
    }

    private void updateMarket(ResourceModifier eventMod) {
        this.eventModifier = eventModifier;

        
    }

}

package com.order66.team66.spacetraderapp.models;

import java.util.HashMap;

/**
 * Represents a cargo hold with resources
 */
public class CargoHold {

    private final HashMap<String, Integer> cargoStock = new HashMap<>();
    private final int maxCapacity;
    private int currentCapacity;

    /**
     * Creates a CargoHold object and populates the cargoStock with resources
     *
     * @param capacity the max storage capacity of the CargoHold
     */
    CargoHold(int capacity) {
        maxCapacity = capacity;

        for (Resource resource : Resource.values()) {
            cargoStock.put(resource.getName(), 0);
        }
    }

    /**
     * Gets the current amount of the given resource in the CargoHold
     *
     * @param resource the resource to check the stock of
     * @return the amount of the given resource in the CargoHold
     */
    public int getStock(Resource resource) {
        Integer stock = null;
        if (resource != null && cargoStock.containsKey(resource.getName())) {
            stock = cargoStock.get(resource.getName());
        }
        return stock != null ? stock : 0;
    }

    /**
     * Adds the given amount to the stock of the given resource
     *
     * @param resource the resource to increase the stock of
     * @param amount the amount to increase the stock by
     */
    public void increaseStock(Resource resource, int amount) {
        if (resource != null && cargoStock.containsKey(resource.getName())) {
            Integer currStock = cargoStock.get(resource.getName());
            int newStock = (currStock != null ? currStock : 0) + amount;
            cargoStock.put(resource.getName(), newStock);
            currentCapacity += amount;
        }
    }

    /**
     * Removes the given amount from the stock of the given resource
     *
     * @param resource the resource to decrease the stock of
     * @param amount the amount to decrease the stock by
     */
    public void decreaseStock(Resource resource, int amount) {
        if (resource != null && cargoStock.containsKey(resource.getName())) {
            Integer currStock = cargoStock.get(resource.getName());
            int newStock = Math.max(currStock != null ? currStock : 0 - amount, 0);
            cargoStock.put(resource.getName(), newStock);
            currentCapacity -= amount;
        }
    }

    /**
     * Returns max capacity of hold
     *
     * @return max capacity
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Returns current capacity
     *
     * @return current capacity
     */
    public int getCurrentCapacity() {
        return currentCapacity;
    }

    /**
     * Getter for cargoStock.
     * For use with FIREBASE ONLY
     *
     * @return the enumMap cargoStock
     */
    public HashMap<String, Integer> getCargoStock() {
        return cargoStock;
    }

}

package com.order66.team66.spacetraderapp.models;

import java.util.NoSuchElementException;

/**
 * Player class stores information about the player's name, credits,
 * spaceship, and skill points.
 */
public class Player {

    /** Player's Name */
    private String name;

    /** Player's Credits */
    private int credits;

    /**
     * Player's Skill Points
     *
     * Should not exceed MAX_SKILL_POINTS
     */
    private Skill pilot;
    private Skill fighter;
    private Skill trader;
    private Skill engineer;

    /** Player's Maximum Number of Skill Points */
    private static final int MAX_SKILL_POINTS = 16;

    /** Player's Spaceship */
    private Spaceship spaceship;

    private CargoHold cargoHold = new CargoHold(100);

    private int currentFuel;

    /**
     * Creates a new player with given skill points
     *
     * Sets initial credits to 1000
     * Sets initial spaceship to Gnat
     *
     * @param name Player Name
     * @param pilot Pilot Skill
     * @param fighter Fighter Skill
     * @param trader Trader Skill
     * @param engineer Engineer Skill
     */
    public Player(String name, Skill pilot, Skill fighter, Skill trader, Skill engineer) {
        this.name = name;
        this.pilot = pilot;
        this.fighter = fighter;
        this.trader = trader;
        this.engineer = engineer;
        credits = 1000;
        spaceship = Spaceship.GNAT;
        currentFuel = spaceship.getFuelCap();
    }

    public Player(){

    }

    /**
     * Gets Player's Name
     *
     * @return player name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Player's Name
     *
     * @param name player name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets Player's Credits
     *
     * @return player credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Sets Player's Credits
     *
     * @param credits player credits
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getMaxSkillPoints() {
        return MAX_SKILL_POINTS;
    }

    /**
     * Gets Player's Spaceship
     *
     * @return player spaceship
     */
    public Spaceship getSpaceship() {
        return spaceship;
    }

    /**
     * Gets Player's CargoHold
     *
     * @return player CargoHold
     */
    public CargoHold getCargoHold() { return  cargoHold; }

    /**
     * Sets Player's Spaceship
     *
     * @param spaceship player spaceship
     */
    public void setSpaceship(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    /**
     * Gets Player's Current Fuel
     *
     * @return current fuel count
     */
    public int getCurrentFuel(){
        return currentFuel;
    }

    /**
     * Adds fuel to the currentFuel if it doesn't go over the maximum fuel capacity.
     *
     * @param amt the amount to add
     */
    public void addFuel(int amt) {
        if(currentFuel + amt >= spaceship.getFuelCap()) {
            throw new RuntimeException("Tried to overfuel!");
        } else {
            currentFuel += amt;
        }
    }

    /**
     * Removes fuel from the currentFuel if it doesn't go below zero.
     *
     * @param amt the amount to remove
     */
    public void removeFuel(int amt) {
        if(currentFuel > 0) {
            currentFuel -= amt;
        } else {
            throw new RuntimeException("Not Enough Fuel!");
        }
    }

    @Override
    public String toString() {
        String toRet = "Name: " + name + "\n" +
                "Credits: " + credits + "\n" +
                "Spaceship: " + spaceship.getName() + "\n" +
                "Pilot Skill: 16\n" + //+ pilot.getLevel() + "\n" +
                "Fighter Skill: 0\n" + //+ fighter.getLevel() + "\n" +
                "Trader Skill: 0\n" + //+ trader.getLevel() + "\n" +
                "Engineer Skill: 0\n"; //+ engineer.getLevel() + "\n";
        return toRet;
    }

    public Skill getPilot(){
        return pilot;
    }

    public Skill getFighter(){
        return fighter;
    }

    public Skill getTrader(){
        return trader;
    }

    public Skill getEngineer(){
        return engineer;
    }
}

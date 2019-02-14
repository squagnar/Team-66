package com.order66.team66.spacetraderapp.models;

public class Player {

    /** Player's Name */
    private String name;

    /** Player's Credits */
    private int credits;

    /**
     * Player's Skill Points
     *
     * Should not exceed 16 points total
     */
    private int pilot;
    private int fighter;
    private int trader;
    private int engineer;

    /** Player's Spaceship */
    private Spaceship spaceship;


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
    public Player(String name, int pilot, int fighter, int trader, int engineer) {
        this.name = name;
        this.pilot = pilot;
        this.fighter = fighter;
        this.trader = trader;
        this.engineer = engineer;
        credits = 1000;
        spaceship = Spaceship.GNAT;
    }

    /**
     * Creates a new player with skill points set to 0
     *
     * Sets initial credits to 1000
     * Sets initial spaceship to Gnat
     *
     * @param name Player Name
     */
    public Player(String name) {
        this(name, 4, 4, 4, 4);
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

    /**
     * Increases Player's Credits
     *
     * @param credits credits to add
     */
    public void addCredits(int credits) {
        this.credits += credits;
    }

    /**
     * Decreases Player's Credits
     *
     * @param credits credits to remove
     */
    public void removeCredits(int credits) {
        this.credits -= credits;
    }

    /**
     * Gets Player's Pilot Skill
     *
     * @return pilot skill
     */
    public int getPilot() {
        return pilot;
    }

    /**
     * Sets Player's Pilot Skill
     *
     * @param pilot pilot skill
     */
    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

    /**
     * Increases Player's Pilot Skill
     *
     * @param pilot pilot skill points to add
     */
    public void addPilot(int pilot) {
        this.pilot += pilot;
    }

    /**
     * Decreases Player's Pilot Skill
     *
     * @param pilot pilot skill points to remove
     */
    public void removePilot(int pilot) {
        this.pilot -= pilot;
    }
    /**
     * Gets Player's Fighter Skill
     *
     * @return fighter skill
     */
    public int getFighter() {
        return fighter;
    }

    /**
     * Sets Player's Fighter Skill
     *
     * @param fighter fighter skill
     */
    public void setFighter(int fighter) {
        this.fighter = fighter;
    }

    /**
     * Gets Player's Trader Skill
     *
     * @return trader skill
     */
    public int getTrader() {
        return trader;
    }

    /**
     * Sets Player's Trader Skill
     *
     * @param trader trader skill
     */
    public void setTrader(int trader) {
        this.trader = trader;
    }

    /**
     * Gets Player's Engineer Skill
     *
     * @return engineer skill
     */
    public int getEngineer() {
        return engineer;
    }

    /**
     * Sets Player's Engineer Skill
     *
     * @param engineer engineer skill
     */
    public void setEngineer(int engineer) {
        this.engineer = engineer;
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
     * Sets Player's Spaceship
     *
     * @param spaceship player spaceship
     */
    public void setSpaceship(Spaceship spaceship) {
        this.spaceship = spaceship;
    }
}

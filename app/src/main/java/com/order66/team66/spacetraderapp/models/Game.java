package com.order66.team66.spacetraderapp.models;

import android.support.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Stores Game Data
 */
public final class Game {

    private static final Game GAME_STATE = new Game();

    private final String userID = "test";

    private final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private final DatabaseReference mUserData = mDatabase.child("users").child(userID);

    /** Game Difficulty */
    private Difficulty difficulty;

    /** Game's Player */
    private Player player;

    /** Game Solar System */
    private List<SolarSystem> solarSystems;

    private SolarSystem currentSystem;

    private Planet currentPlanet;

    private Game(){
        difficulty = Difficulty.EASY;
        solarSystems = createSolarSystem();

        currentSystem = solarSystems.get(0);
        currentPlanet = currentSystem.getPlanet(0);
    }

    /**
     * Returns instance of Game
     *
     * @return game state
     */
    public static Game getInstance(){
        return GAME_STATE;
    }

    /** Max X and Y Coordinates in Game */
    private static final int MAX_X_COORDINATES = 150;
    private static final int MAX_Y_COORDINATES = 100;

    /**
     * Returns player
     *
     * @return player
     */
    public Player getPlayer(){
        return player;
    }

    /**
     * Returns difficulty
     *
     * @return difficulty
     */
    private Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * Returns all solar systems
     *
     * @return list of solar systems
     */
    public List<SolarSystem> getSolarSystems() {
        return  solarSystems;
    }

    /**
     * Returns current solar system
     *
     * @return current solar system
     */
    public SolarSystem getCurrentSystem() {
        return currentSystem;
    }

    /**
     * Returns current planet
     *
     * @return current planet
     */
    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    /**
     * Sets current player
     *
     * @param player new player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Sets game difficulty
     *
     * @param diff game difficulty
     */
    public void setDifficulty(Difficulty diff) {
        difficulty = diff;
    }

    /**
     * Sets current planet
     *
     * @param planet new planet
     */
    public void setCurrentPlanet(Planet planet) {
        currentPlanet = planet;
    }

    /**
     * Sets current planet with different solar system
     *
     * @param planet new planet
     * @param system new system
     */
    public void setCurrentPlanet(Planet planet, SolarSystem system){
        currentSystem = system;
        currentPlanet = planet;
    }

    /**
     * Short travel to another planet
     *
     * @param planet planet to travel to
     */
    public void shortTravel(Planet planet) {
        if(currentSystem.hasPlanet(planet)){
            currentPlanet = planet;
        } else {
            throw new NoSuchElementException("Planet does not exist in this solar system!");
        }
    }

    /**
     * Long travel to planet
     *
     * @param system new solar system
     * @param planet planet to travel to
     */
    public void longTravel(SolarSystem system, Planet planet) {
        try {
            player.removeFuel(1);
            if(system.hasPlanet(planet)){
                currentSystem = system;
                currentPlanet = planet;
                //TODO: run an encounter check here
            } else {
                throw new NoSuchElementException("Planet does not exist in this solar system!");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Not enough fuel!");
        }
    }

    /**
     * Randomly generates solar systems
     *
     * @return list of solar systems
     */
    private List<SolarSystem> createSolarSystem() {
        solarSystems = new ArrayList<>();
        List<String> planetNames = Arrays.asList(SolarSystem.planetNames);
        Collections.shuffle(planetNames);
        int[][] coordinates = new int[MAX_X_COORDINATES][MAX_Y_COORDINATES];
        int planets = 0;
        int counter = 0;
        SolarSystem curr = null;
        while (solarSystems.size() < 10) {
            String name = planetNames.get(counter);
            counter++;
            // If planets == 0, make a new Solar System
            if (planets == 0) {
                // New number of planets for Solar System
                planets = (int) (Math.random() * SolarSystem.MAX_PLANETS) + 1;
                // Find coordinates for new Solar System
                int x = -1;
                int y = -1;
                boolean found = false;
                while (!found) {
                    x = (int) (Math.random() * (coordinates.length));
                    y = (int) (Math.random() * (coordinates[0].length));
                    if (coordinates[x][y] != -1) {
                        found = true;
                        coordinates[x][y] = -1;
                    }
                }
                // Makes solar system
                curr = new SolarSystem(name, x, y);
                solarSystems.add(curr);
            }
            // Choose Tech Level
            TechLevel techLevel = TechLevel.getRandom();
            // Choose Resource
            ResourceModifier resourceMod = ResourceModifier.getRandomWorldMod();
            curr.addPlanet(new Planet(name, techLevel, resourceMod));
            planets--;
        }
        return solarSystems;
    }

    /**
     * Updates user data for firebase
     */
    public void writeUserData() {
        mUserData.setValue(getInstance());
    }

    /**
     * Reads user data from firebase
     */
    public void readUserData() {
        ValueEventListener downloader = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Get the saved data from the Database
                Game loadedState = dataSnapshot.getValue(Game.class);

                //Update the game with the saved data
                if (loadedState != null) {
                    difficulty = loadedState.getDifficulty();
                    setPlayer(loadedState.getPlayer());
                    solarSystems = loadedState.getSolarSystems();
                    currentPlanet = loadedState.getCurrentPlanet();
                    currentSystem = loadedState.getCurrentSystem();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mUserData.addListenerForSingleValueEvent(downloader);
    }
}


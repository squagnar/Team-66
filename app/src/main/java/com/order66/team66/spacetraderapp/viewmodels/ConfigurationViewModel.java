package com.order66.team66.spacetraderapp.viewmodels;

import android.arch.lifecycle.ViewModel;
import com.order66.team66.spacetraderapp.models.Game;
import com.order66.team66.spacetraderapp.models.Player;

public class ConfigurationViewModel extends ViewModel {
    private String name;
    // private Button difficultyField;
    private int pointsFighter;
    private int pointsTrader;
    private int pointsPilot;
    private int pointsEngineer;
    private String difficulty;
    /**
     * Passthrough method to allow a view to create a Player object
     *
     * @param name name of the player
     * @param pilot total pilot skill points
     * @param fighter total fighter skill points
     * @param trader total trader skill points
     * @param engineer total engineer skill points
     */
    public void createPlayer(String name, int pilot, int fighter, int trader, int engineer) {
        Player player = new Player(name, pilot, fighter, trader, engineer);
        //TODO: store this somewhere, maybe firebase database
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPilot(int points) {
        this.pointsPilot = points;
    }

    public void setPointsFighter(int points) {
        this.pointsFighter = points;
    }

    public void setPointsTrader(int points) {
        this.pointsTrader = points;
    }

    public void setPointsEngineer(int points) {
        this.pointsEngineer = points;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
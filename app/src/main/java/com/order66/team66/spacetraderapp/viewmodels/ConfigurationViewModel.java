package com.order66.team66.spacetraderapp.viewmodels;

import android.arch.lifecycle.ViewModel;
import com.order66.team66.spacetraderapp.models.Game;
import com.order66.team66.spacetraderapp.models.Player;
import com.order66.team66.spacetraderapp.models.Skill;
import com.order66.team66.spacetraderapp.models.SolarSystem;

import java.util.List;

/**
 * View Model for Character Creation
 */
public class ConfigurationViewModel extends ViewModel {

    private final Game GAME_STATE = Game.getInstance();

    /**
     * Pass-Through method to allow a view to create a Player object
     *
     * @param name name of the player
     * @param pilot total pilot skill points
     * @param fighter total fighter skill points
     * @param trader total trader skill points
     * @param engineer total engineer skill points
     */
    public void createPlayer(String name, Skill pilot, Skill fighter, Skill trader, Skill engineer) {
        Player player = new Player(name, pilot, fighter, trader, engineer);
        GAME_STATE.setPlayer(player);
        //GAME_STATE.writeUserData();
    }

    /**
     * Returns game state player
     *
     * @return player
     */
    public Player getPlayer() { return GAME_STATE.getPlayer();}

    /**
     * Returns game state solar systems
     *
     * @return solar systems
     */
    public List<SolarSystem> getSolarSystems() {
        return GAME_STATE.getSolarSystems();
    }
}
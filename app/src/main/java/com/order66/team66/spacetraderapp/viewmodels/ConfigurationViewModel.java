package com.order66.team66.spacetraderapp.viewmodels;

import android.arch.lifecycle.ViewModel;
import com.order66.team66.spacetraderapp.models.Game;
import com.order66.team66.spacetraderapp.models.Player;
import com.order66.team66.spacetraderapp.models.Skill;
import com.order66.team66.spacetraderapp.models.SolarSystem;

import java.util.List;

public class ConfigurationViewModel extends ViewModel {

    private Game GAME_STATE = Game.getInstance();

    /**
     * Passthrough method to allow a view to create a Player object
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
        GAME_STATE.writeUserData();
        GAME_STATE.createUnivserse();
    }

    public Player getPlayer() { return GAME_STATE.getPlayer();}

    public List<SolarSystem> getSolarSystems() {
        return GAME_STATE.getSolarSystems();
    }
}
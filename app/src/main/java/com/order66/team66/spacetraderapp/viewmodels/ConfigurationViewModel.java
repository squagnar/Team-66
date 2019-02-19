package com.order66.team66.spacetraderapp.viewmodels;

import android.arch.lifecycle.ViewModel;
import com.order66.team66.spacetraderapp.models.Game;
import com.order66.team66.spacetraderapp.models.Player;
import com.order66.team66.spacetraderapp.models.Skill;

public class ConfigurationViewModel extends ViewModel {

    private Player player;

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
        player = new Player(name, pilot, fighter, trader, engineer);
        //TODO: store this somewhere, maybe firebase database
    }

    public Player getPlayer() { return player;}
}
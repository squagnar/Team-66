package com.order66.team66.spacetraderapp.viewmodels;
import android.arch.lifecycle.ViewModel;
import com.order66.team66.spacetraderapp.models.*;

import java.util.List;

public class MarketViewModel extends ViewModel {

    private Game GAME_STATE = Game.getInstance();
    private Planet planet = GAME_STATE.getCurrentPlanet();
    private Market market = planet.getMarket();
    private Player player = GAME_STATE.getPlayer();

    public Planet getPlanet() {
        return planet;
    }

    public Market getMarket() {
        return market;
    }

    public Player getPlayer() {
        return player;
    }

    public void travel(Planet planet) {
        if (!planet.equals(this.planet)) {
            this.planet = planet;
            GAME_STATE.setCurrentPlanet(planet);
            market = planet.getMarket();
            player.removeFuel(1);

            //Check if we trigger a market event for this world
            if(Math.random() > .7) {
                market.updateMarket(ResourceModifier.getRandomEventMod());
            }
        }
    }
}

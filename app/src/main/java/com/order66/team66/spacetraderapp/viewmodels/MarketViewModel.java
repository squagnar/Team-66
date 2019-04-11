package com.order66.team66.spacetraderapp.viewmodels;

import android.arch.lifecycle.ViewModel;
import com.order66.team66.spacetraderapp.models.Game;
import com.order66.team66.spacetraderapp.models.Market;
import com.order66.team66.spacetraderapp.models.Planet;
import com.order66.team66.spacetraderapp.models.Player;
import com.order66.team66.spacetraderapp.models.ResourceModifier;
import com.order66.team66.spacetraderapp.models.SolarSystem;

/**
 * View Model for Player Activities
 */
public class MarketViewModel extends ViewModel {

    private final Game GAME_STATE = Game.getInstance();
    private Planet planet = GAME_STATE.getCurrentPlanet();
    private final SolarSystem solarSystem = GAME_STATE.getCurrentSystem();
    private Market market = planet.getMarket();
    private final Player player = GAME_STATE.getPlayer();

    /**
     * Returns current planet
     *
     * @return planet
     */
    public Planet getPlanet() {
        return planet;
    }

    /**
     * Returns current market
     *
     * @return market
     */
    public Market getMarket() {
        return market;
    }

    /**
     * Returns current player
     *
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Return current solar system
     *
     * @return solar system
     */
    public SolarSystem getSolarSystem() {
        return solarSystem;
    }

    /**
     * Travel to new planet
     *
     * @param planet new planet
     * @param system planet's solar system
     */
    public void travel(Planet planet, SolarSystem system) {
        if (!planet.equals(this.planet)) {
            this.planet = planet;
            GAME_STATE.setCurrentPlanet(planet, system);
            market = planet.getMarket();
            player.removeFuel(1);

            //Check if we trigger a market event for this world
            if(Math.random() > -1) {
                market.updateMarket(ResourceModifier.getRandomEventMod());
            }
        }
    }
}

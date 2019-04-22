package com.order66.team66.spacetraderapp.viewmodels;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import com.order66.team66.spacetraderapp.models.*;

import java.util.List;
import java.util.Random;

public class MarketViewModel extends ViewModel {

    private Game GAME_STATE;
    private Planet planet;
    private SolarSystem solarSystem;
    private Market market;
    private Player player;

    public MarketViewModel() {
        GAME_STATE = Game.getInstance();
        planet = GAME_STATE.getCurrentPlanet();
        solarSystem = GAME_STATE.getCurrentSystem();
        market = GAME_STATE.getCurrentPlanet().getMarket();
        player = GAME_STATE.getPlayer();
    }

    public Planet getPlanet() {
        return planet;
    }

    public Market getMarket() {
        return market;
    }

    public Player getPlayer() {
        return player;
    }

    public SolarSystem getSolarSystem() {
        return solarSystem;
    }

    public void travel(Planet planet, SolarSystem system) {
        if (!planet.equals(this.planet)) {
            player.removeFuel(1);
            this.planet = planet;
            GAME_STATE.setCurrentPlanet(planet, system);
            market = planet.getMarket();

            //Check if we trigger a market event for this world
            if(Math.random() > .3) {
                market.updateMarket(ResourceModifier.getRandomEventMod());
            }

            //Check if we trigger a Trader/Police/Pirate encounter
            if(Math.random() > -1) { //TODO: make this not always true
                double rand = Math.random();
                Random random = new Random();

                if(rand < .33) {
                    //Pirate encounter
                    if(player.getCargoHold().getCurrentCapacity() != 0) {
                        Resource stolen = Resource.getRandomResource();
                        while (player.getCargoHold().getStock(stolen) == 0) {
                            stolen = Resource.getRandomResource();
                        }

                        int stolenAmt = random.nextInt(Math.min(9, player.getCargoHold().getStock(stolen) - 1)) + 1;

                        player.getCargoHold().decreaseStock(stolen, stolenAmt);

                        throw new RuntimeException("Got ambushed by pirates during travel! Lost " + stolenAmt
                            + " " + stolen.getName() + "!");
                    }
                } else if (rand < .66) {
                    //Police Encounter
                    int fineAmt = random.nextInt(Math.min(90, player.getCredits()));
                    player.setCredits(player.getCredits() - fineAmt);

                    throw new RuntimeException("Got ticketed by a Police cruiser! Paid a fine of " + fineAmt
                        + " credits.");

                } else {
                    //Trader Encounter
                    Resource gift = Resource.getRandomResource();
                    int giftAmt = random.nextInt(9) + 1;

                    player.getCargoHold().increaseStock(gift, giftAmt);

                    throw new RuntimeException("Met a trader during travel! Received a free sample of " + giftAmt
                        + " " + gift.getName() + "!");

                }
            }
        }
    }
}

package com.order66.team66.spacetraderapp.viewmodels;
import android.arch.lifecycle.ViewModel;
import com.order66.team66.spacetraderapp.models.Player;
import com.order66.team66.spacetraderapp.models.Market;
import com.order66.team66.spacetraderapp.models.Planet;

import java.util.List;

public class MarketViewModel extends ViewModel {

    private Player player;
    private Market market;
    private Planet planet;

    public MarketViewModel(Player player, Planet planet) {
        this.planet = planet;
        this.player = player;
        market = this.planet.getMarket();
    }

    public Planet getPlanet() {
        return planet;
    }

    public Market getMarket() {
        return market;
    }

    public Player getPlayer() { return player;}
}

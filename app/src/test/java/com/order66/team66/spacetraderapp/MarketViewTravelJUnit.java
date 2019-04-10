package com.order66.team66.spacetraderapp;

import com.order66.team66.spacetraderapp.models.*;
import com.order66.team66.spacetraderapp.viewmodels.MarketViewModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarketViewTravelJUnit {

    Planet p1, p2, p3, p4;
    SolarSystem s1, s2, s3;
    MarketViewModel viewModel;
    private final Game GAME_STATE = Game.getInstance();

    @Before
    public void setup() {
        Planet p1 = new Planet("one", TechLevel.AGRICULTURE, ResourceModifier.ARTISTIC);
        Planet p2 = new Planet("two", TechLevel.AGRICULTURE, ResourceModifier.ARTISTIC);
        Planet p3 = new Planet("one", TechLevel.AGRICULTURE, ResourceModifier.ARTISTIC);
        Planet p4 = new Planet("four", TechLevel.AGRICULTURE, ResourceModifier.ARTISTIC);

        SolarSystem s1 = new SolarSystem("one", 0, 0);
        SolarSystem s2 = new SolarSystem("two", 0, 0);
        SolarSystem s3 = new SolarSystem("three", 0, 0);

        s1.addPlanet(p1);
        s1.addPlanet(p2);

        s2.addPlanet(p1);
        s2.addPlanet(p3);

        s3.addPlanet(p1);
        s3.addPlanet(p2);
        s3.addPlanet(p3);
        s3.addPlanet(p4);

        viewModel = new MarketViewModel();
        GAME_STATE.setCurrentPlanet(p1, s1);
    }

    @Test
    public void testDifferentPlanetSameSystem() {
        assertEquals(GAME_STATE.getCurrentPlanet() == p1, true);
        assertEquals(GAME_STATE.getCurrentSystem() == s1, true);
        viewModel.travel(p2, s1);
        assertEquals(GAME_STATE.getCurrentPlanet() == p2, true);
        assertEquals(GAME_STATE.getCurrentSystem() == s1, true);
    }
}

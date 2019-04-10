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
        p1 = new Planet("one", TechLevel.AGRICULTURE, ResourceModifier.ARTISTIC);
        p2 = new Planet("two", TechLevel.AGRICULTURE, ResourceModifier.ARTISTIC);
        p3 = new Planet("one", TechLevel.AGRICULTURE, ResourceModifier.ARTISTIC);
        p4 = new Planet("four", TechLevel.AGRICULTURE, ResourceModifier.ARTISTIC);

        s1 = new SolarSystem("one", 0, 0);
        s2 = new SolarSystem("two", 0, 0);
        s3 = new SolarSystem("three", 0, 0);

        s1.addPlanet(p1);
        s1.addPlanet(p2);

        s2.addPlanet(p1);
        s2.addPlanet(p3);

        s3.addPlanet(p1);
        s3.addPlanet(p2);
        s3.addPlanet(p3);
        s3.addPlanet(p4);

        GAME_STATE.setCurrentPlanet(p1, s1);
        GAME_STATE.setPlayer(new Player("a", Skill.PILOT, Skill.FIGHTER, Skill.TRADER, Skill.ENGINEER));
    }

    @Test
    public void testDifferentPlanetSameSystem() {
        viewModel = new MarketViewModel();
        assertEquals(true, GAME_STATE.getCurrentPlanet() == p1);
        assertEquals(true, GAME_STATE.getCurrentSystem() == s1);
        viewModel.travel(p2, s1);
        assertEquals(true, GAME_STATE.getCurrentPlanet() == p2);
        assertEquals(true, GAME_STATE.getCurrentSystem() == s1);
    }

    @Test
    public void testSamePlanetSameSystem() {
        GAME_STATE.setCurrentPlanet(p1, s2);
        viewModel = new MarketViewModel();
        assertEquals(true, GAME_STATE.getCurrentPlanet() == p1);
        assertEquals(true, GAME_STATE.getCurrentSystem() == s2);
        // should not travel
        viewModel.travel(p3, s2);
        assertEquals(true, GAME_STATE.getCurrentPlanet() == p1);
        assertEquals(true, GAME_STATE.getCurrentSystem() == s2);
    }

    @Test
    public void testDifferentPlanetDifferentSystem() {
        GAME_STATE.setCurrentPlanet(p1, s1);
        viewModel = new MarketViewModel();
        assertEquals(true, GAME_STATE.getCurrentPlanet() == p1);
        assertEquals(true, GAME_STATE.getCurrentSystem() == s1);
        viewModel.travel(p4, s3);
        assertEquals(true, GAME_STATE.getCurrentPlanet() == p4);
        assertEquals(true, GAME_STATE.getCurrentSystem() == s3);
    }

    @Test
    public void testSamePlanetDifferentSystem() {
        GAME_STATE.setCurrentPlanet(p1, s1);
        viewModel = new MarketViewModel();
        assertEquals(true, GAME_STATE.getCurrentPlanet() == p1);
        assertEquals(true, GAME_STATE.getCurrentSystem() == s1);
        viewModel.travel(p3, s3);
        assertEquals(true, GAME_STATE.getCurrentPlanet() == p1);
        assertEquals(true, GAME_STATE.getCurrentSystem() == s1);
    }
}

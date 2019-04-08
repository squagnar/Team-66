package com.order66.team66.spacetraderapp.tests;
import com.order66.team66.spacetraderapp.models.Resource;
import com.order66.team66.spacetraderapp.models.ResourceModifier;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

import static junit.framework.Assert.assertEquals;


public class GetPriceTest {

    FakeRandom fakeRand = new FakeRandom();
    int price;
    int techLevel = 7;
    int genPrice;

    Resource testable = Resource.FOOD;

    public class FakeRandom extends Random {

        public FakeRandom(){
            super();
        }

        @Override
        public int nextInt(int bound) {
            return 1;
        }

        @Override
        public int nextInt() {
            return 1;
        }

        @Override
        public boolean nextBoolean() {
            return true;
        }
    }

    @Before
    public void setup(){
        price = Resource.FOOD.getBasePrice()
                + (Resource.FOOD.getPriceChangePerTech() * (techLevel - Resource.FOOD.getMinTechUse())) - 1;
        genPrice = 0;
    }

    @Test
    public void testNone() {
        genPrice = testable.getPrice(techLevel, ResourceModifier.NULL, ResourceModifier.NULL, fakeRand);
        assertEquals(price, genPrice);
    }

    @Test
    public void testShortage() {
        price *= 2;

        genPrice = testable.getPrice(techLevel, testable.getShortageEvent(), ResourceModifier.NULL, fakeRand);
        assertEquals(price, genPrice);

        genPrice = testable.getPrice(techLevel, ResourceModifier.NULL, testable.getShortageEvent(), fakeRand);
        assertEquals(price, genPrice);
    }

    @Test
    public void testSurplus() {
        price *= .5;

        genPrice = testable.getPrice(techLevel, testable.getSurplusEvent(), ResourceModifier.NULL, fakeRand);
        assertEquals(price, genPrice);

        genPrice = testable.getPrice(techLevel, ResourceModifier.NULL, testable.getSurplusEvent(), fakeRand);
        assertEquals(price, genPrice);
    }

    @Test
    public void testExpensive() {
        price *= 1.5;

        genPrice = testable.getPrice(techLevel, testable.getExpensiveEvent(), ResourceModifier.NULL, fakeRand);
        assertEquals(price, genPrice);

        genPrice = testable.getPrice(techLevel, ResourceModifier.NULL, testable.getExpensiveEvent(), fakeRand);
        assertEquals(price, genPrice);
    }

    @Test
    public void testShortageSurplus() {
        price *= 2;
        price *= .5;

        genPrice = testable.getPrice(techLevel, testable.getShortageEvent(), testable.getSurplusEvent(), fakeRand);
        assertEquals(price, genPrice);

        genPrice = testable.getPrice(techLevel, testable.getSurplusEvent(), testable.getShortageEvent(), fakeRand);
        assertEquals(price, genPrice);
    }

    @Test
    public void testShortageExpensive() {
        price *= 2;
        price *= 1.5;

        genPrice = testable.getPrice(techLevel, testable.getShortageEvent(), testable.getExpensiveEvent(), fakeRand);
        assertEquals(price, genPrice);

        genPrice = testable.getPrice(techLevel, testable.getExpensiveEvent(), testable.getShortageEvent(), fakeRand);
        assertEquals(price, genPrice);
    }

    @Test
    public void testSurplusExpensive() {
        price *= .5;
        price *= 1.5;

        genPrice = testable.getPrice(techLevel, testable.getSurplusEvent(), testable.getExpensiveEvent(), fakeRand);
        assertEquals(price, genPrice);

        genPrice = testable.getPrice(techLevel, testable.getExpensiveEvent(), testable.getSurplusEvent(), fakeRand);
        assertEquals(price, genPrice);
    }

}

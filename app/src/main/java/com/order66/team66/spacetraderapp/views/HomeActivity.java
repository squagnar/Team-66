package com.order66.team66.spacetraderapp.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.order66.team66.spacetraderapp.R;
import com.order66.team66.spacetraderapp.models.Game;
import com.order66.team66.spacetraderapp.models.Planet;
import com.order66.team66.spacetraderapp.viewmodels.MarketViewModel;

/**
 * Represents Home Screen
 */
public class HomeActivity extends Activity {

    private final Game GAME_STATE = Game.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MarketViewModel viewModel = new MarketViewModel();
        Planet planet = viewModel.getPlanet();

        TextView planetText = findViewById(R.id.planet_home_text);
        planetText.setText(viewModel.getPlanetName());
    }

    /**
     * Leaves the game
     *
     * @param view exit button
     */
    public void exitGame(View view) {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }

    /**
     * Goes to the market
     *
     * @param view market button
     */
    public void goToMarket(View view) {
        Intent intent = new Intent(HomeActivity.this, MarketActivity.class);
        startActivity(intent);
    }

    /**
     * Goes to travel
     *
     * @param view travel button
     */
    public void goToTravel(View view) {
        Intent intent = new Intent(HomeActivity.this, TravelActivity.class);
        startActivity(intent);
    }

    /**
     * Saves the game
     *
     * @param view save button
     */
    public void saveGame(View view) {
        GAME_STATE.writeUserData();
    }
}

package com.order66.team66.spacetraderapp.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.order66.team66.spacetraderapp.R;
import com.order66.team66.spacetraderapp.models.Planet;
import com.order66.team66.spacetraderapp.viewmodels.MarketViewModel;

public class HomeActivity extends Activity {

    private TextView planetText;
    private MarketViewModel viewModel;
    private Planet planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewModel = new MarketViewModel();
        planet = viewModel.getPlanet();

        planetText = findViewById(R.id.planet_home_text);
        planetText.setText(planet.getName());
    }
    
    public void exitGame(View view) {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }

    public void goToMarket(View view) {
        Intent intent = new Intent(HomeActivity.this, MarketActivity.class);
        startActivity(intent);
    }

    public void goToTravel(View view) {
        Intent intent = new Intent(HomeActivity.this, TravelActivity.class);
        startActivity(intent);
    }
}

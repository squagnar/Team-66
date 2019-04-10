package com.order66.team66.spacetraderapp.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.order66.team66.spacetraderapp.R;
import com.order66.team66.spacetraderapp.models.Game;
import com.order66.team66.spacetraderapp.models.Planet;
import com.order66.team66.spacetraderapp.viewmodels.MarketViewModel;
import org.w3c.dom.Text;

public class HomeActivity extends Activity {

    private TextView planetText;
    private MarketViewModel viewmodel;
    private Planet planet;
    private Game GAME_STATE = Game.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewmodel = new MarketViewModel();
        planet = viewmodel.getPlanet();

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
        Log.d("playerdata", Game.getInstance().getPlayer().getName());
        Intent intent = new Intent(HomeActivity.this, MarketActivity.class);
        startActivity(intent);
    }

    public void goToTravel(View view) {
        Intent intent = new Intent(HomeActivity.this, TravelActivity.class);
        startActivity(intent);
    }

    public void saveGame(View view) {
        GAME_STATE.writeUserData();
    }
}

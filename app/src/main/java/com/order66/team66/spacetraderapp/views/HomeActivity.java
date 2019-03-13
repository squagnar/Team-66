package com.order66.team66.spacetraderapp.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.order66.team66.spacetraderapp.R;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
        Intent intent = new Intent(HomeActivity.this, MarketActivity.class);
        startActivity(intent);
    }
}

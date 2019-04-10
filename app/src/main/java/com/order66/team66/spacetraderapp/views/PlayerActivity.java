package com.order66.team66.spacetraderapp.views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.order66.team66.spacetraderapp.R;
import com.order66.team66.spacetraderapp.models.Game;
import com.order66.team66.spacetraderapp.models.Player;
import com.order66.team66.spacetraderapp.viewmodels.ConfigurationViewModel;
import com.order66.team66.spacetraderapp.viewmodels.MarketViewModel;

public class PlayerActivity extends AppCompatActivity {

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Game.getInstance().readUserData();

    }

    public void goToCreatePlayer(View view) {
        Intent intent = new Intent(PlayerActivity.this, ConfigurationActivity.class);
        startActivity(intent);
    }

    public void loadPlayer(View view) {
        Game.getInstance().updateUserData();

        Intent intent = new Intent(PlayerActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}

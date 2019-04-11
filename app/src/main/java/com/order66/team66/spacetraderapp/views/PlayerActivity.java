package com.order66.team66.spacetraderapp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.order66.team66.spacetraderapp.R;
import com.order66.team66.spacetraderapp.models.Game;
import com.order66.team66.spacetraderapp.models.Player;
import com.order66.team66.spacetraderapp.viewmodels.ConfigurationViewModel;

/**
 * Represents Load Screen
 */
public class PlayerActivity extends AppCompatActivity {

    private final Game GAME_STATE = Game.getInstance();
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        ConfigurationViewModel viewModel = new ConfigurationViewModel();
    }

    /**
     * Make a new player
     *
     * @param view new player button
     */
    public void goToCreatePlayer(View view) {
        Intent intent = new Intent(PlayerActivity.this, ConfigurationActivity.class);
        startActivity(intent);
    }

    /**
     * Loads an existing player
     *
     * @param view load player button
     */
//    public void loadPlayer(View view) {
//        GAME_STATE.readUserData();
//
//        Intent intent = new Intent(PlayerActivity.this, HomeActivity.class);
//        startActivity(intent);
//    }
}

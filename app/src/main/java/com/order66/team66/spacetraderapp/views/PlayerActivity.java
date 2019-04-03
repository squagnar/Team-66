package com.order66.team66.spacetraderapp.views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.order66.team66.spacetraderapp.R;
import com.order66.team66.spacetraderapp.models.Game;
import com.order66.team66.spacetraderapp.models.Player;
import com.order66.team66.spacetraderapp.viewmodels.ConfigurationViewModel;

public class PlayerActivity extends AppCompatActivity {

    private Game GAME_STATE = Game.getInstance();
    private ConfigurationViewModel viewmodel;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        viewmodel = new ConfigurationViewModel();
    }

    public void goToCreatePlayer(View view) {
        Intent intent = new Intent(PlayerActivity.this, ConfigurationActivity.class);
        startActivity(intent);
    }

    public void loadPlayer(View view) {
        GAME_STATE.readUserData();

        Intent intent = new Intent(PlayerActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}

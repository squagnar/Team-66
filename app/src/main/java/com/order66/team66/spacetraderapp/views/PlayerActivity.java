package com.order66.team66.spacetraderapp.views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.order66.team66.spacetraderapp.R;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
    }

    public void goToCreatePlayer(View view) {
        Intent intent = new Intent(PlayerActivity.this, ConfigurationActivity.class);
        startActivity(intent);
    }

    public void loadPlayer(View view) {
        Intent intent = new Intent(PlayerActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}

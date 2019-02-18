package com.order66.team66.spacetraderapp.views;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.order66.team66.spacetraderapp.R;
import com.order66.team66.spacetraderapp.models.Difficulty;
import com.order66.team66.spacetraderapp.models.Player;
import org.w3c.dom.Text;

public class ConfigurationActivity extends AppCompatActivity {
    private ConfigurationActivity viewModel;

    private Player player;
    private Difficulty difficulty;

    // Widgets to get info
    private EditText nameField;
    // private Button difficultyField;
    private TextView pointsFighter;
    private TextView pointsTrader;
    private TextView pointsPilot;
    private TextView pointsEngineer;

    // point retrieval for point system
    int pointVal = 0;

    public void increasePoint(View view) {
        pointVal++;
        // display(pointVal);
    }

    public void decreasePoint(View view) {
        pointVal--;
        // display(pointVal);
    }
    public void display(int value, TextView id) {
        TextView pointDisplay = (TextView) findViewById(id.getId());
        pointDisplay.setText("" + value);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_configuration);

        int pointVal = 0;

        // widgets
        nameField = findViewById(R.id.player_name_input);
        pointsFighter = findViewById(R.id.fighter_points);
        pointsPilot = findViewById(R.id.pilot_points);
        pointsTrader = findViewById(R.id.trader_points);
        pointsEngineer = findViewById(R.id.engineer_points);

        // get int value
        int pointsPilotInt = Integer.parseInt(pointsPilot.getText().toString());
        int pointsFighterInt = Integer.parseInt(pointsFighter.getText().toString());
        int pointsTraderInt = Integer.parseInt(pointsTrader.getText().toString());
        int pointsEngineerInt = Integer.parseInt(pointsEngineer.getText().toString());

        // create new player
        // need to connect to viewModel
        player = new Player(nameField.getText().toString(), pointsPilotInt,
                pointsFighterInt, pointsTraderInt, pointsEngineerInt);

    }
}

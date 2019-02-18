package com.order66.team66.spacetraderapp.views;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;
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
    private TextView pointsFighter;
    private TextView pointsTrader;
    private TextView pointsPilot;
    private TextView pointsEngineer;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button button;

    int pointValPilot = 0;
    int pointValFighter = 0;
    int pointValTrader = 0;
    int pointValEngineer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_configuration);

        // widgets
        nameField = findViewById(R.id.player_name_input);
        pointsFighter = findViewById(R.id.fighter_points);
        pointsPilot = findViewById(R.id.pilot_points);
        pointsTrader = findViewById(R.id.trader_points);
        pointsEngineer = findViewById(R.id.engineer_points);

        // addListenerOnButton();
        // increase/decrease button

        viewModel.savePlayer();
    }

    // pilot points
    public void increasePointPilot(View view) {
        pointValPilot++;
        displayPilotPoints(pointValPilot);
    }

    public void decreasePointPilot(View view) {
        pointValPilot--;
        displayPilotPoints(pointValPilot);
    }

    public void displayPilotPoints(int value) {
        TextView pointDisplay = (TextView) findViewById(R.id.pilot_points);
        pointDisplay.setText("" + value);
    }

    // fighter points
    public void increasePointFighter(View view) {
        pointValFighter++;
        displayFighterPoints(pointValFighter);
    }

    public void decreasePointFighter(View view) {
        pointValFighter--;
        displayFighterPoints(pointValFighter);
    }

    public void displayFighterPoints(int value) {
        TextView pointDisplay = (TextView) findViewById(R.id.fighter_points);
        pointDisplay.setText("" + value);
    }

    // trader points
    public void increasePointTrader(View view) {
        pointValTrader++;
        displayTraderPoints(pointValTrader);
    }

    public void decreasePointTrader(View view) {
        pointValTrader--;
        displayTraderPoints(pointValTrader);
    }

    public void displayTraderPoints(int value) {
        TextView pointDisplay = (TextView) findViewById(R.id.trader_points);
        pointDisplay.setText("" + value);
    }

    // engineer points
    public void increasePointEngineer(View view) {
        pointValEngineer++;
        displayEngineerPoints(pointValEngineer);
    }

    public void decreasePointEngineer(View view) {
        pointValEngineer--;
        displayEngineerPoints(pointValEngineer);
    }

    public void displayEngineerPoints(int value) {
        TextView pointDisplay = (TextView) findViewById(R.id.engineer_points);
        pointDisplay.setText("" + value);
    }

    private void savePlayer() {
        // get int value
        int pointsPilotInt = Integer.parseInt(pointsPilot.getText().toString());
        int pointsFighterInt = Integer.parseInt(pointsFighter.getText().toString());
        int pointsTraderInt = Integer.parseInt(pointsTrader.getText().toString());
        int pointsEngineerInt = Integer.parseInt(pointsEngineer.getText().toString());

        // set attributes ?
        player.setName(nameField.getText().toString());
        player.setPilot(pointsPilotInt);
        player.setFighter(pointsFighterInt);
        player.setTrader(pointsTraderInt);
        player.setEngineer(pointsEngineerInt);
    }
}

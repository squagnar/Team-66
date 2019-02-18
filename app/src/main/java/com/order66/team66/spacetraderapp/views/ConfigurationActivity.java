package com.order66.team66.spacetraderapp.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.order66.team66.spacetraderapp.R;
import com.order66.team66.spacetraderapp.models.Difficulty;
import com.order66.team66.spacetraderapp.models.Player;
import com.order66.team66.spacetraderapp.viewmodels.ConfigurationViewModel;

/**
 * Class for adding a new player
 */
public class ConfigurationActivity extends AppCompatActivity {
    /**
     * The view model
     */
    private ConfigurationViewModel viewModel;

    /**
     * Data for player and difficulty being edited
     */
    private Player player;
    private Difficulty difficulty;

    /**
     * Widgets to get info from
      */
    private EditText nameField;
    private TextView pointsFighter;
    private TextView pointsTrader;
    private TextView pointsPilot;
    private TextView pointsEngineer;
    private Spinner difficultySpinner;

    /**
     * Initial point values for Pilot, Fighter, Trader, Engineer, and total remaining points
     */
    int pointValPilot = 0;
    int pointValFighter = 0;
    int pointValTrader = 0;
    int pointValEngineer = 0;
    int pointValTotal = 16;

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

        // bind with difficulty spinner
        // put enums from Difficulty into spinner
        difficultySpinner = findViewById(R.id.difficulty_spinner);
        ArrayAdapter<Difficulty> difficultyAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Difficulty.values());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyAdapter);
    }

    /**
     * Increases pilot points and decreases total remaining points when + button is pressed
      * @param view button that was pressed
     */
    public void increasePointPilot(View view) {
        if (pointValPilot >= 0 && pointValPilot <= 16 && pointValTotal > 0 && pointValTotal <= 16) {
            pointValPilot++;
            pointValTotal--;
            displayPilotPoints(pointValPilot);
            displayPointsRemaining(pointValTotal);
        }
    }

    /**
     * Decreases pilot points and increases total remaining points when - is pressed
     * @param view the button that was pressed
     */
    public void decreasePointPilot(View view) {
        if (pointValPilot > 0 && pointValPilot <= 16 && pointValTotal >= 0 && pointValTotal < 16) {
            pointValPilot--;
            pointValTotal++;
            displayPilotPoints(pointValPilot);
            displayPointsRemaining(pointValTotal);
        }
    }

    /**
     * Displays current pilot points
     * @param value current pilot points
     */
    public void displayPilotPoints(int value) {
        TextView pointDisplay = (TextView) findViewById(R.id.pilot_points);
        pointDisplay.setText("" + value);
    }

    /**
     * Increases fighter points and decreases total remaining points when + button is pressed
     * @param view button that was pressed
     */
    public void increasePointFighter(View view) {
        if (pointValFighter >= 0 && pointValFighter <= 16 && pointValTotal > 0 && pointValTotal <= 16) {
            pointValFighter++;
            pointValTotal--;
            displayFighterPoints(pointValFighter);
            displayPointsRemaining(pointValTotal);
        }
    }

    /**
     * Decreases fighter points and increases total remaining points when - is pressed
     * @param view the button that was pressed
     */
    public void decreasePointFighter(View view) {
        if (pointValFighter > 0 && pointValFighter <= 16 && pointValTotal >= 0 && pointValTotal < 16) {
            pointValFighter--;
            pointValTotal++;
            displayFighterPoints(pointValFighter);
            displayPointsRemaining(pointValTotal);
        }
    }

    /**
     * Displays current fighter points
     * @param value current fighter points
     */
    public void displayFighterPoints(int value) {
        TextView pointDisplay = (TextView) findViewById(R.id.fighter_points);
        pointDisplay.setText("" + value);
    }

    /**
     * Increases trader points and decreases total remaining points when + button is pressed
     * @param view button that was pressed
     */
    public void increasePointTrader(View view) {
        if (pointValTrader >= 0 && pointValTrader <= 16 && pointValTotal > 0 && pointValTotal <= 16) {
            pointValTrader++;
            pointValTotal--;
            displayTraderPoints(pointValTrader);
            displayPointsRemaining(pointValTotal);
        }
    }

    /**
     * Decreases trader points and increases total remaining points when - is pressed
     * @param view the button that was pressed
     */
    public void decreasePointTrader(View view) {
        if (pointValTrader > 0 && pointValTrader <= 16 && pointValTotal >= 0 && pointValTotal < 16) {
            pointValTrader--;
            pointValTotal++;
            displayTraderPoints(pointValTrader);
            displayPointsRemaining(pointValTotal);
        }
    }

    /**
     * Displays current trader points
     * @param value current trader points
     */
    public void displayTraderPoints(int value) {
        TextView pointDisplay = (TextView) findViewById(R.id.trader_points);
        pointDisplay.setText("" + value);
    }

    /**
     * Increases engineer points and decreases total remaining points when + button is pressed
     * @param view button that was pressed
     */
    public void increasePointEngineer(View view) {
        if (pointValEngineer >= 0 && pointValEngineer <= 16 && pointValTotal > 0 && pointValTotal <= 16) {
            pointValEngineer++;
            pointValTotal--;
            displayEngineerPoints(pointValEngineer);
            displayPointsRemaining(pointValTotal);
        }
    }

    /**
     * Decreases engineer points and increases total remaining points when - is pressed
     * @param view the button that was pressed
     */
    public void decreasePointEngineer(View view) {
        if (pointValEngineer > 0 && pointValEngineer <= 16 && pointValTotal >= 0 && pointValTotal < 16) {
            pointValEngineer--;
            pointValTotal++;
            displayEngineerPoints(pointValEngineer);
            displayPointsRemaining(pointValTotal);
        }
    }

    /**
     * Displays current engineer points
     * @param value current engineer points
     */
    public void displayEngineerPoints(int value) {
        TextView pointDisplay = (TextView) findViewById(R.id.engineer_points);
        pointDisplay.setText("" + value);
    }

    /**
     * Displays total points remaining
     * @param value current total points remaining
     */
    public void displayPointsRemaining(int value) {
        TextView pointDisplay = (TextView) findViewById(R.id.points_remaining);
        pointDisplay.setText("" + value);
    }

    /**
     * Button handler for add new player button
     * @param view the button that was pressed
     */
    public void onAddPressed(View view) {
        // get int value
        int pointsPilotInt = Integer.parseInt(pointsPilot.getText().toString());
        int pointsFighterInt = Integer.parseInt(pointsFighter.getText().toString());
        int pointsTraderInt = Integer.parseInt(pointsTrader.getText().toString());
        int pointsEngineerInt = Integer.parseInt(pointsEngineer.getText().toString());

        difficulty.setDifficulty((String) difficultySpinner.getSelectedItem());

        viewModel.createPlayer(nameField.getText().toString(), pointsPilotInt,
                pointsFighterInt, pointsTraderInt, pointsEngineerInt);

        Log.d("New player added", "Player data: " + player);
    }
}

package com.order66.team66.spacetraderapp.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.order66.team66.spacetraderapp.R;
import com.order66.team66.spacetraderapp.models.Difficulty;
import com.order66.team66.spacetraderapp.models.Player;
import com.order66.team66.spacetraderapp.models.Skill;
import com.order66.team66.spacetraderapp.viewmodels.ConfigurationViewModel;
import java.util.ArrayList;

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

    // Widgets to get info
    private EditText nameFieldText;
    private TextView pointsPilotText;
    private TextView pointsFighterText;
    private TextView pointsTraderText;
    private TextView pointsEngineerText;
    private TextView pointsUnspentText;
    private Spinner difficultySpinner;

    private ArrayList<TextView> skillDisplays;

    private Skill pilot;
    private Skill fighter;
    private Skill trader;
    private Skill engineer;
    final int TOTAL_POINTS = 16;
    int pointsUnspent = TOTAL_POINTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_configuration);
        viewModel = new ConfigurationViewModel();

        //Create the skill objects to edit and pass to the player later on
        pilot = Skill.PILOT;
        fighter = Skill.FIGHTER;
        trader = Skill.TRADER;
        engineer = Skill.ENGINEER;

        //Assign widgets to variables
        nameFieldText = findViewById(R.id.player_name_input);
        pointsPilotText = findViewById(R.id.pilot_points);
        pointsFighterText = findViewById(R.id.fighter_points);
        pointsTraderText = findViewById(R.id.trader_points);
        pointsEngineerText = findViewById(R.id.engineer_points);
        pointsUnspentText = findViewById(R.id.points_remaining);
        difficultySpinner = findViewById(R.id.difficulty_spinner);

        //Assign tags to skill display textViews
        pointsPilotText.setTag(pilot);
        pointsFighterText.setTag(fighter);
        pointsTraderText.setTag(trader);
        pointsEngineerText.setTag(engineer);

        //Add skill display textViews to an ArrayList to search through later
        skillDisplays = new ArrayList<>();
        skillDisplays.add(pointsPilotText);
        skillDisplays.add(pointsFighterText);
        skillDisplays.add(pointsTraderText);
        skillDisplays.add(pointsEngineerText);

        //Assign tags to skill edit buttons
        Button pilotUp = findViewById(R.id.increase_button_pilot);
        pilotUp.setTag(pilot);
        Button pilotDown = findViewById(R.id.decrease_button_pilot);
        pilotDown.setTag(pilot);
        Button fighterUp = findViewById(R.id.increase_button_fighter);
        fighterUp.setTag(fighter);
        Button fighterDown = findViewById(R.id.decrease_button_fighter);
        fighterDown.setTag(fighter);
        Button traderUp = findViewById(R.id.increase_button_trader);
        traderUp.setTag(trader);
        Button traderDown = findViewById(R.id.decrease_button_trader);
        traderDown.setTag(trader);
        Button engineerUp = findViewById(R.id.increase_button_engineer);
        engineerUp.setTag(engineer);
        Button engineerDown = findViewById(R.id.decrease_button_engineer);
        engineerDown.setTag(engineer);

        //Set the values of the difficulty spinner
        ArrayAdapter<Difficulty> difficultyAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Difficulty.values());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyAdapter);
    }

    public void levelUpSkill(View view) {
        Skill skill = (Skill)view.getTag();
        if(pointsUnspent > 0 && skill.getLevel() != TOTAL_POINTS) {
            skill.levelUp();
            pointsUnspent--;
            TextView skillDisplay;

            updatePointsDisplay(skill);
        }
    }

    public void levelDownSkill(View view) {
        Skill skill = (Skill)view.getTag();
        if(pointsUnspent < 16 && skill.getLevel() != 0) {
            skill.levelDown();
            pointsUnspent++;
            updatePointsDisplay(skill);
        }
    }

    private void updatePointsDisplay(Skill skill) {
        pointsUnspentText.setText(String.format("%s", pointsUnspent));
        TextView skillDisplay = null;
        for(TextView display : skillDisplays) {
            if(display.getTag().equals(skill)){
                skillDisplay = display;
                break;
            }
        }
        if(skillDisplay == null) {
            throw new NullPointerException(String.format("Did not find the textView with the tag %s", skill.getName()));
        }
        skillDisplay.setText(String.format("%s", skill.getLevel()));
    }

    public void onAddPressed(View view) {
        //difficulty.setDifficulty((String) difficultySpinner.getSelectedItem());

        if (pointsUnspent > 0) {
            Toast.makeText(this, "Please allocate all skill points!", Toast.LENGTH_LONG).show();
        } else {
            viewModel.createPlayer(nameFieldText.getText().toString(), pilot, fighter, trader, engineer);
            Log.d("New player added", "Player data: \n" + viewModel.getPlayer());
            viewModel.createSolarSystems();
            Log.d("New solar systems added", "Solar System data: \n" + viewModel.getSolarSystems());
            finish();
        }
    }
}
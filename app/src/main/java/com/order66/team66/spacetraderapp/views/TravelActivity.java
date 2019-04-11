package com.order66.team66.spacetraderapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.order66.team66.spacetraderapp.R;
import com.order66.team66.spacetraderapp.models.CargoHold;
import com.order66.team66.spacetraderapp.models.Planet;
import com.order66.team66.spacetraderapp.models.Player;
import com.order66.team66.spacetraderapp.models.SolarSystem;
import com.order66.team66.spacetraderapp.viewmodels.MarketViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents Travel Screen
 */
public class TravelActivity extends AppCompatActivity {

    private Spinner planetSpinner;
    private MarketViewModel viewModel;
    private SolarSystem solarSystem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        viewModel = new MarketViewModel();
        Planet planet = viewModel.getPlanet();
        solarSystem = viewModel.getSolarSystem();
        Player player = viewModel.getPlayer();
        CargoHold cargo = player.getCargoHold();

        TextView currentPlanet = findViewById(R.id.current_planet_text);
        TextView shipType = findViewById(R.id.ship_type_text);
        TextView fuelRemaining = findViewById(R.id.fuel_remaining_amount_text);
        TextView cargoRemaining = findViewById(R.id.available_cargo_amount_text);
        planetSpinner = findViewById(R.id.planet_spinner);
        Button travelButton = findViewById(R.id.travel_button);

        currentPlanet.setText(planet.getName());
        shipType.setText(player.getSpaceship().getName());
        fuelRemaining.setText(String.format("%s", player.getCurrentFuel()));
        cargoRemaining.setText(String.format("%s", (player.getCargoHold().getMaxCapacity() -
                player.getCargoHold().getCurrentCapacity())));


        List<String> planetNames = new ArrayList<>();
        for (Planet p : solarSystem.getPlanets()) {
            planetNames.add(p.getName());
        }

        ArrayAdapter<String> planetAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, planetNames);
        planetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        planetSpinner.setAdapter(planetAdapter);

        planetSpinner.setSelection(planetNames.indexOf(planet.getName()));
    }

    /**
     * Travel on confirmation
     *
     * @param view travel button
     */
    public void onClick(View view) {
        try {
            viewModel.travel(solarSystem.getPlanet(planetSpinner.getSelectedItemPosition()), solarSystem);
            Intent intent = new Intent(TravelActivity.this, HomeActivity.class);
            startActivity(intent);
        } catch (RuntimeException e) {
            Toast.makeText(this,"You don't have enough fuel for that!", Toast.LENGTH_LONG).show();
        }
    }
}

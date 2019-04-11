package com.order66.team66.spacetraderapp.views;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.order66.team66.spacetraderapp.R;
import com.order66.team66.spacetraderapp.models.*;
import com.order66.team66.spacetraderapp.viewmodels.MarketViewModel;

/**
 * Represents Market Screen
 */
public class MarketActivity extends AppCompatActivity {

    private MarketViewModel viewModel;

    private Resource water;
    private Resource fur;
    private Resource food;
    private Resource ore;
    private Resource games;
    private Resource firearms;
    private Resource medicine;
    private Resource machines;
    private Resource narcotics;
    private Resource robots;

    private Market market;
    private CargoHold cargo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        viewModel = new MarketViewModel();

        market = viewModel.getMarket();
        Player player = viewModel.getPlayer();
        cargo = viewModel.getCargoHold();

        water = Resource.WATER;
        fur = Resource.FURS;
        food = Resource.FOOD;
        ore = Resource.ORE;
        games = Resource.GAMES;
        firearms = Resource.FIREARMS;
        medicine = Resource.MEDICINE;
        machines = Resource.MACHINES;
        narcotics = Resource.NARCOTICS;
        robots = Resource.ROBOTS;

        // bind buttons to variables
        Button waterButton = findViewById(R.id.water_button);
        waterButton.setTag(water);
        Button furButton = findViewById(R.id.furs_button);
        furButton.setTag(fur);
        Button foodButton = findViewById(R.id.food_button);
        foodButton.setTag(food);
        Button oreButton = findViewById(R.id.ore_button);
        oreButton.setTag(ore);
        Button gamesButton = findViewById(R.id.games_button);
        gamesButton.setTag(games);
        Button firearmsButton = findViewById(R.id.firearms_button);
        firearmsButton.setTag(firearms);
        Button medicineButton = findViewById(R.id.medicine_button);
        medicineButton.setTag(medicine);
        Button machinesButton = findViewById(R.id.machines_button);
        machinesButton.setTag(machines);
        Button narcoticsButton = findViewById(R.id.narcotics_button);
        narcoticsButton.setTag(narcotics);
        Button robotsButton = findViewById(R.id.robots_button);
        robotsButton.setTag(robots);

        // bind prices to TextView and set tags
        TextView waterPrice = findViewById(R.id.water_price_text);
        waterPrice.setText(String.format("%s", market.getPrice(water)));
        waterPrice.setTag(water);

        TextView furPrice = findViewById(R.id.furs_price_text);
        furPrice.setText(String.format("%s", market.getPrice(fur)));
        furPrice.setTag(fur);

        TextView foodPrice = findViewById(R.id.food_price_text);
        foodPrice.setText(String.format("%s", market.getPrice(food)));
        foodPrice.setTag(food);

        TextView orePrice = findViewById(R.id.ore_price_text);
        orePrice.setText(String.format("%s", market.getPrice(ore)));
        orePrice.setTag(ore);

        TextView gamesPrice = findViewById(R.id.games_price_text);
        gamesPrice.setText(String.format("%s", market.getPrice(games)));
        gamesPrice.setTag(games);

        TextView firearmsPrice = findViewById(R.id.firearms_price_text);
        firearmsPrice.setText(String.format("%s", market.getPrice(firearms)));
        firearmsPrice.setTag(firearms);

        TextView medicinePrice = findViewById(R.id.medicine_price_text);
        medicinePrice.setText(String.format("%s", market.getPrice(medicine)));
        medicinePrice.setTag(medicine);

        TextView machinesPrice = findViewById(R.id.machines_price_text);
        machinesPrice.setText(String.format("%s", market.getPrice(machines)));
        machinesPrice.setTag(machines);

        TextView narcoticsPrice = findViewById(R.id.narcotics_price_text);
        narcoticsPrice.setText(String.format("%s", market.getPrice(narcotics)));
        narcoticsPrice.setTag(narcotics);

        TextView robotsPrice = findViewById(R.id.robots_price_text);
        robotsPrice.setText(String.format("%s", market.getPrice(robots)));
        robotsPrice.setTag(robots);

        updateStocks();
    }

    @Override
    public void onResume(){
        super.onResume();
        updateStocks();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void updateStocks() {
        // bind market stock TextView widgets to variables
        TextView waterMarketStock = findViewById(R.id.water_market_text);
        waterMarketStock.setText(String.format("%s", market.getStock(water)));
        waterMarketStock.setTag(water);

        TextView furMarketStock = findViewById(R.id.furs_market_text);
        furMarketStock.setText(String.format("%s", market.getStock(fur)));
        furMarketStock.setTag(fur);

        TextView foodMarketStock = findViewById(R.id.food_market_text);
        foodMarketStock.setText(String.format("%s", market.getStock(food)));
        foodMarketStock.setTag(food);

        TextView oreMarketStock = findViewById(R.id.ore_market_text);
        oreMarketStock.setText(String.format("%s", market.getStock(ore)));
        oreMarketStock.setTag(ore);

        TextView gamesMarketStock = findViewById(R.id.games_market_text);
        gamesMarketStock.setText(String.format("%s", market.getStock(games)));
        gamesMarketStock.setTag(games);

        TextView firearmsMarketStock = findViewById(R.id.firearms_market_text);
        firearmsMarketStock.setText(String.format("%s", market.getStock(firearms)));
        firearmsMarketStock.setTag(firearms);

        TextView medicineMarketStock = findViewById(R.id.medicine_market_text);
        medicineMarketStock.setText(String.format("%s", market.getStock(medicine)));
        medicineMarketStock.setTag(medicine);

        TextView machinesMarketStock = findViewById(R.id.machines_market_text);
        machinesMarketStock.setText(String.format("%s", market.getStock(machines)));
        machinesMarketStock.setTag(machines);

        TextView narcoticsMarketStock = findViewById(R.id.narcotics_market_text);
        narcoticsMarketStock.setText(String.format("%s", market.getStock(narcotics)));
        narcoticsMarketStock.setTag(narcotics);

        TextView robotsMarketStock = findViewById(R.id.robots_market_text);
        robotsMarketStock.setText(String.format("%s", market.getStock(robots)));
        robotsMarketStock.setTag(robots);

        // bind cargo stock TextView widgets to variables
        TextView waterCargoStock = findViewById(R.id.water_cargo_text);
        waterCargoStock.setText(String.format("%s", cargo.getStock(water)));
        waterCargoStock.setTag(water);

        TextView furCargoStock = findViewById(R.id.furs_cargo_text);
        furCargoStock.setText(String.format("%s", cargo.getStock(fur)));
        furCargoStock.setTag(fur);

        TextView foodCargoStock = findViewById(R.id.food_cargo_text);
        foodCargoStock.setText(String.format("%s", cargo.getStock(food)));
        foodCargoStock.setTag(food);

        TextView oreCargoStock = findViewById(R.id.ore_cargo_text);
        oreCargoStock.setText(String.format("%s", cargo.getStock(ore)));
        oreCargoStock.setTag(ore);

        TextView gamesCargoStock = findViewById(R.id.games_cargo_text);
        gamesCargoStock.setText(String.format("%s", cargo.getStock(games)));
        gamesCargoStock.setTag(games);

        TextView firearmsCargoStock = findViewById(R.id.firearms_cargo_text);
        firearmsCargoStock.setText(String.format("%s", cargo.getStock(firearms)));
        firearmsCargoStock.setTag(firearms);

        TextView medicineCargoStock = findViewById(R.id.medicine_cargo_text);
        medicineCargoStock.setText(String.format("%s", cargo.getStock(medicine)));
        medicineCargoStock.setTag(medicine);

        TextView machinesCargoStock = findViewById(R.id.machines_cargo_text);
        machinesCargoStock.setText(String.format("%s", cargo.getStock(machines)));
        machinesCargoStock.setTag(machines);

        TextView narcoticsCargoStock = findViewById(R.id.narcotics_cargo_text);
        narcoticsCargoStock.setText(String.format("%s", cargo.getStock(narcotics)));
        narcoticsCargoStock.setTag(narcotics);

        TextView robotsCargoStock = findViewById(R.id.robots_cargo_text);
        robotsCargoStock.setText(String.format("%s", cargo.getStock(robots)));
        robotsCargoStock.setTag(robots);

        TextView currentWorldEvent = findViewById(R.id.planet_market_text);
        ResourceModifier worldModifier = viewModel.getWorldModifier();
        currentWorldEvent.setText(worldModifier.toString());

        ResourceModifier eventModifier = viewModel.getEventModifier();
        TextView eventMod = findViewById(R.id.event_market_text);
        eventMod.setText(eventModifier.toString());
    }

    /**
     * Submit resources to buy
     *
     * @param view trade button
     */
    public void onClick(View view) {
        Resource resource = (Resource) view.getTag();
        boolean canUse = market.canUse(resource);

        if(canUse) {
            Intent intent = new Intent(MarketActivity.this, BuyActivity.class);
            intent.putExtra("Resource", resource);

            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(this,"This planet cannot trade that resource!", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}

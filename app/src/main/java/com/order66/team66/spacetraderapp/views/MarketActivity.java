package com.order66.team66.spacetraderapp.views;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import com.order66.team66.spacetraderapp.R;
import com.order66.team66.spacetraderapp.models.*;
import com.order66.team66.spacetraderapp.viewmodels.MarketViewModel;
import org.w3c.dom.Text;

public class MarketActivity extends AppCompatActivity {

    private MarketViewModel viewmodel;

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
    private Player player;


    private Button waterButton;
    private Button furButton;
    private Button foodButton;
    private Button oreButton;
    private Button gamesButton;
    private Button firearmsButton;
    private Button medicineButton;
    private Button machinesButton;
    private Button narcoticsButton;
    private Button robotsButton;

    private TextView waterPrice;
    private TextView furPrice;
    private TextView foodPrice;
    private TextView orePrice;
    private TextView gamesPrice;
    private TextView firearmsPrice;
    private TextView medicinePrice;
    private TextView machinesPrice;
    private TextView narcoticsPrice;
    private TextView robotsPrice;

    private TextView waterMarketStock;
    private TextView furMarketStock;
    private TextView foodMarketStock;
    private TextView oreMarketStock;
    private TextView gamesMarketStock;
    private TextView firearmsMarketStock;
    private TextView medicineMarketStock;
    private TextView machinesMarketStock;
    private TextView narcoticsMarketStock;
    private TextView robotsMarketStock;

    private TextView waterCargoStock;
    private TextView furCargoStock;
    private TextView foodCargoStock;
    private TextView oreCargoStock;
    private TextView gamesCargoStock;
    private TextView firearmsCargoStock;
    private TextView medicineCargoStock;
    private TextView machinesCargoStock;
    private TextView narcoticsCargoStock;
    private TextView robotsCargoStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        viewmodel = new MarketViewModel();

        market = viewmodel.getMarket();
        player = viewmodel.getPlayer();
        cargo = player.getCargoHold();

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
        waterButton = findViewById(R.id.water_button);
        waterButton.setTag(water);
        furButton = findViewById(R.id.furs_button);
        furButton.setTag(fur);
        foodButton = findViewById(R.id.food_button);
        foodButton.setTag(food);
        oreButton = findViewById(R.id.ore_button);
        oreButton.setTag(ore);
        gamesButton = findViewById(R.id.games_button);
        gamesButton.setTag(games);
        firearmsButton = findViewById(R.id.firearms_button);
        firearmsButton.setTag(firearms);
        medicineButton = findViewById(R.id.medicine_button);
        medicineButton.setTag(medicine);
        machinesButton = findViewById(R.id.machines_button);
        machinesButton.setTag(machines);
        narcoticsButton = findViewById(R.id.narcotics_button);
        narcoticsButton.setTag(narcotics);
        robotsButton = findViewById(R.id.robots_button);
        robotsButton.setTag(robots);

        // bind prices to TextView and set tags
        waterPrice = findViewById(R.id.water_price_text);
        waterPrice.setText(String.format("%s", market.getPrice(water)));
        waterPrice.setTag(water);

        furPrice = findViewById(R.id.furs_price_text);
        furPrice.setText(String.format("%s", market.getPrice(fur)));
        furPrice.setTag(fur);

        foodPrice = findViewById(R.id.food_price_text);
        foodPrice.setText(String.format("%s", market.getPrice(food)));
        foodPrice.setTag(food);

        orePrice = findViewById(R.id.ore_price_text);
        orePrice.setText(String.format("%s", market.getPrice(ore)));
        orePrice.setTag(ore);

        gamesPrice = findViewById(R.id.games_price_text);
        gamesPrice.setText(String.format("%s", market.getPrice(games)));
        gamesPrice.setTag(games);

        firearmsPrice = findViewById(R.id.firearms_price_text);
        firearmsPrice.setText(String.format("%s", market.getPrice(firearms)));
        firearmsPrice.setTag(firearms);

        medicinePrice = findViewById(R.id.medicine_price_text);
        medicinePrice.setText(String.format("%s", market.getPrice(medicine)));
        medicinePrice.setTag(medicine);

        machinesPrice = findViewById(R.id.machines_price_text);
        machinesPrice.setText(String.format("%s", market.getPrice(machines)));
        machinesPrice.setTag(machines);

        narcoticsPrice = findViewById(R.id.narcotics_price_text);
        narcoticsPrice.setText(String.format("%s", market.getPrice(narcotics)));
        narcoticsPrice.setTag(narcotics);

        robotsPrice = findViewById(R.id.robots_price_text);
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
        waterMarketStock = findViewById(R.id.water_market_text);
        waterMarketStock.setText(String.format("%s", market.getStock(water)));
        waterMarketStock.setTag(water);

        furMarketStock = findViewById(R.id.furs_market_text);
        furMarketStock.setText(String.format("%s", market.getStock(fur)));
        furMarketStock.setTag(fur);

        foodMarketStock = findViewById(R.id.food_market_text);
        foodMarketStock.setText(String.format("%s", market.getStock(food)));
        foodMarketStock.setTag(food);

        oreMarketStock = findViewById(R.id.ore_market_text);
        oreMarketStock.setText(String.format("%s", market.getStock(ore)));
        oreMarketStock.setTag(ore);

        gamesMarketStock = findViewById(R.id.games_market_text);
        gamesMarketStock.setText(String.format("%s", market.getStock(games)));
        gamesMarketStock.setTag(games);

        firearmsMarketStock = findViewById(R.id.firearms_market_text);
        firearmsMarketStock.setText(String.format("%s", market.getStock(firearms)));
        firearmsMarketStock.setTag(firearms);

        medicineMarketStock = findViewById(R.id.medicine_market_text);
        medicineMarketStock.setText(String.format("%s", market.getStock(medicine)));
        medicineMarketStock.setTag(medicine);

        machinesMarketStock = findViewById(R.id.machines_market_text);
        machinesMarketStock.setText(String.format("%s", market.getStock(machines)));
        machinesMarketStock.setTag(machines);

        narcoticsMarketStock = findViewById(R.id.narcotics_market_text);
        narcoticsMarketStock.setText(String.format("%s", market.getStock(narcotics)));
        narcoticsMarketStock.setTag(narcotics);

        robotsMarketStock = findViewById(R.id.robots_market_text);
        robotsMarketStock.setText(String.format("%s", market.getStock(robots)));
        robotsMarketStock.setTag(robots);

        // bind cargo stock TextView widgets to variables
        waterCargoStock = findViewById(R.id.water_cargo_text);
        waterCargoStock.setText(String.format("%s", cargo.getStock(water)));
        waterCargoStock.setTag(water);

        furCargoStock = findViewById(R.id.furs_cargo_text);
        furCargoStock.setText(String.format("%s", cargo.getStock(fur)));
        furCargoStock.setTag(fur);

        foodCargoStock = findViewById(R.id.food_cargo_text);
        foodCargoStock.setText(String.format("%s", cargo.getStock(food)));
        foodCargoStock.setTag(food);

        oreCargoStock = findViewById(R.id.ore_cargo_text);
        oreCargoStock.setText(String.format("%s", cargo.getStock(ore)));
        oreCargoStock.setTag(ore);

        gamesCargoStock = findViewById(R.id.games_cargo_text);
        gamesCargoStock.setText(String.format("%s", cargo.getStock(games)));
        gamesCargoStock.setTag(games);

        firearmsCargoStock = findViewById(R.id.firearms_cargo_text);
        firearmsCargoStock.setText(String.format("%s", cargo.getStock(firearms)));
        firearmsCargoStock.setTag(firearms);

        medicineCargoStock = findViewById(R.id.medicine_cargo_text);
        medicineCargoStock.setText(String.format("%s", cargo.getStock(medicine)));
        medicineCargoStock.setTag(medicine);

        machinesCargoStock = findViewById(R.id.machines_cargo_text);
        machinesCargoStock.setText(String.format("%s", cargo.getStock(machines)));
        machinesCargoStock.setTag(machines);

        narcoticsCargoStock = findViewById(R.id.narcotics_cargo_text);
        narcoticsCargoStock.setText(String.format("%s", cargo.getStock(narcotics)));
        narcoticsCargoStock.setTag(narcotics);

        robotsCargoStock = findViewById(R.id.robots_cargo_text);
        robotsCargoStock.setText(String.format("%s", cargo.getStock(robots)));
        robotsCargoStock.setTag(robots);
<<<<<<< HEAD
=======

        currentPlanet = findViewById(R.id.planet_market_text);
        currentPlanet.setText(viewmodel.getMarket().getWorldModifier().toString());

        eventMod = findViewById(R.id.event_market_text);
        eventMod.setText(viewmodel.getMarket().getEventModifier().toString());
>>>>>>> parent of 32f878d... fixed code checker issues w/ xml files
    }

    public void onClick(View view) {
        Resource resource = (Resource) view.getTag();
        boolean canUse = market.canUse(resource);

        if(canUse) {
            Intent intent = new Intent(MarketActivity.this, BuyActivity.class);
            intent.putExtra("Resource", resource);

            startActivity(intent);
        } else {
            Toast.makeText(this,"This planet cannot trade that resource!", Toast.LENGTH_LONG).show();
        }
    }
}

package com.order66.team66.spacetraderapp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.order66.team66.spacetraderapp.R;
import com.order66.team66.spacetraderapp.models.*;
import com.order66.team66.spacetraderapp.viewmodels.MarketViewModel;

import java.util.EnumMap;
import java.util.Set;

public class MarketActivity extends AppCompatActivity {
    private MarketViewModel viewmodel;

    private Market market;
    private CargoHold cargo;

    private TextView priceHeader;
    private TextView priceText;
    private TextView marketStockHeader;
    private TextView marketStockText;
    private TextView cargoStockHeader;
    private TextView cargoStockText;
    private TextView quantityHeader;
    private TextView quantityText;
    private Button decreaseQuantity;
    private Button increaseQuantity;
    private Button buy;
    private LinearLayout quantitySelector;
    private Spinner resourcesSpinner;

    private int quantity = 0;
    private int remainingQuantity;
    private Resource resource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        resourcesSpinner = findViewById(R.id.resources_spinner);
        priceHeader = findViewById(R.id.price_header);
        priceText = findViewById(R.id.price_text);
        marketStockHeader = findViewById(R.id.market_stock_header);
        marketStockText = findViewById(R.id.market_stock_text);
        cargoStockHeader = findViewById(R.id.ship_stock_header);
        cargoStockText = findViewById(R.id.ship_stock_text);
        quantityHeader = findViewById(R.id.quantity_header);
        quantityText = findViewById(R.id.remaining_quantity_text);
        decreaseQuantity = findViewById(R.id.decrease_quantity);
        increaseQuantity = findViewById(R.id.increase_quantity);
        quantitySelector = findViewById(R.id.quantity_selector);

        Resource[] resources = market.getAvailableResources().toArray(new Resource[market.getAvailableResources().size()]);

        final ArrayAdapter<Resource> resourcesAdapter = new ArrayAdapter<Resource>(this,
                android.R.layout.simple_spinner_item, resources);
        resourcesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resourcesSpinner.setAdapter(resourcesAdapter);

        resourcesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resource = resourcesAdapter.getItem(position);
                remainingQuantity = market.getStock(resource);

                priceText.setText(market.getPrice(resource));
                marketStockText.setText(market.getStock(resource));
                cargoStockText.setText(cargo.getStock(resource));

                // sets visibility of attributes
                priceHeader.setVisibility((priceHeader.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
                priceText.setVisibility((priceText.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
                marketStockHeader.setVisibility((marketStockHeader.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
                marketStockText.setVisibility((marketStockText.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
                cargoStockHeader.setVisibility((cargoStockHeader.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
                cargoStockText.setVisibility((cargoStockText.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
                quantityHeader.setVisibility((quantityHeader.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
                quantitySelector.setVisibility((quantitySelector.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

//    private void updateQuantity(Integer stock) {
//        quantityText.setText(String.format("%s", remainingQuantity));
//        TextView skillDisplay = null;
//        for(TextView display : skillDisplays) {
//            if(display.getTag().equals(skill)){
//                skillDisplay = display;
//                break;
//            }
//        }
//        skillDisplay.setText(String.format("%s", market.decreaseStock(resource, );));
//    }

    public void increaseQuantity(View view) {
        if (quantity <= remainingQuantity) {
            remainingQuantity--;
            quantity++;
            updateQuantity(remainingQuantity);
        }
    }

    public void decreaseQuantity(View view) {
        if (quantity > 0) {
            remainingQuantity++;
            quantity--;
            updateQuantity(remainingQuantity);
        }
    }

    private void updateQuantity(int quantity) {
        quantityText.setText(String.format("%s", remainingQuantity));
    }

    private void onAddPressed(View view) {
        viewmodel.getMarket().decreaseStock(resource, quantity);
        viewmodel.getPlayer().getCargoHold().increaseStock(resource, quantity);
        Intent intent = new Intent(MarketActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}

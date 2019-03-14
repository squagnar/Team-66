package com.order66.team66.spacetraderapp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.order66.team66.spacetraderapp.R;
import com.order66.team66.spacetraderapp.models.CargoHold;
import com.order66.team66.spacetraderapp.models.Market;
import com.order66.team66.spacetraderapp.models.Player;
import com.order66.team66.spacetraderapp.models.Resource;
import com.order66.team66.spacetraderapp.viewmodels.MarketViewModel;

public class BuyActivity extends AppCompatActivity {
    private MarketViewModel viewmodel;

    private TextView resourceText;
    private TextView resourcePriceText;
    private Button decreaseBuyQuantity;
    private TextView buyQuantityText;
    private Button increaseBuyQuantity;
    private Button decreaseSellQuantity;
    private TextView sellQuantityText;
    private Button increaseSellQuantity;
    private TextView marketBuyText;
    private TextView marketSellText;
    private Button tradeButton;

    Intent intent = getIntent();
    Resource resource = intent.getParcelableExtra("Resource");

    private Market market;
    private CargoHold cargo;
    private Player player;


    private int buyQuantity;
    private int sellQuantity;
    private int remainingBuyQuantity;
    private int remainingSellQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        viewmodel = new MarketViewModel();

        market = viewmodel.getMarket();
        player = viewmodel.getPlayer();
        cargo = player.getCargoHold();

        remainingSellQuantity = cargo.getStock(resource);
        remainingBuyQuantity = market.getStock(resource);


        resourceText = findViewById(R.id.resource_header);
        resourcePriceText = findViewById(R.id.resource_price_text);
        decreaseBuyQuantity = findViewById(R.id.decrease_buy_quantity);
        buyQuantityText = findViewById(R.id.buy_quantity_text);
        increaseBuyQuantity = findViewById(R.id.increase_buy_quantity);
        decreaseSellQuantity = findViewById(R.id.decrease_sell_quantity);
        sellQuantityText = findViewById(R.id.sell_quantity_text);
        increaseSellQuantity = findViewById(R.id.increase_sell_quantity);
        marketBuyText = findViewById(R.id.resource_stock_market_text);
        marketSellText = findViewById(R.id.resource_stock_cargo_text);
        tradeButton = findViewById(R.id.trade_button);
    }

    public void confirmTrade(View view) {
        int creditChange = (sellQuantity - buyQuantity) * market.getPrice(resource);
        if (player.getCredits() + creditChange < 0) {
            Toast.makeText(this, "You don't have enough credits for that!", Toast.LENGTH_LONG).show();
        } else {
            player.setCredits(player.getCredits() + creditChange);
            market.decreaseStock(resource, buyQuantity - sellQuantity);
        }
    }

    public void increaseBuyQuantity(View view) {
        if (remainingBuyQuantity > 0) {
            remainingBuyQuantity--;
            buyQuantity++;
            updateRemainingBuyQuantity();
        }
    }

    public void increaseSellQuantity(View view) {
        if (remainingSellQuantity > 0) {
            remainingSellQuantity--;
            sellQuantity++;
            updateRemainingSellQuantity();
        }
    }

    public void decreaseBuyQuantity(View view) {
        if (buyQuantity > 0) {
            remainingBuyQuantity++;
            buyQuantity--;
            updateRemainingBuyQuantity();
        }
    }

    public void decreaseSellQuantity(View view) {
        if (sellQuantity > 0) {
            remainingSellQuantity++;
            sellQuantity--;
            updateRemainingSellQuantity();
        }
    }

    private void updateRemainingBuyQuantity() {
        buyQuantityText.setText(String.format("%s", remainingBuyQuantity));
    }

    private void updateRemainingSellQuantity() {
        sellQuantityText.setText(String.format("%s", remainingSellQuantity));
    }
}

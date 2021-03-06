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
    private TextView totalTransactionText;
    private TextView playerCashText;
    private TextView remainingBuyQuantityText;
    private TextView remainingSellQuantityText;

    Intent intent;
    Resource resource;

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

        intent = getIntent();
        resource = (Resource) intent.getExtras().get("Resource");
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
        tradeButton = findViewById(R.id.trade_button);
        totalTransactionText = findViewById(R.id.total_transaction_text);
        playerCashText = findViewById(R.id.player_cash_text);
        remainingBuyQuantityText = findViewById(R.id.resource_stock_market_text);
        remainingSellQuantityText = findViewById(R.id.resource_stock_cargo_text);

        resourcePriceText.setText(String.format("%s", market.getPrice(resource)));

        updateRemainingBuyQuantity();
        updateRemainingSellQuantity();
        updateRemainingPlayerCash();
        updateTotalTradeCost();
    }

    public void confirmTrade(View view) {
        int creditChange = (sellQuantity - buyQuantity) * market.getPrice(resource);
        if (player.getCredits() + creditChange < 0) {
            Toast.makeText(this, "You don't have enough credits for that!", Toast.LENGTH_LONG).show();
        } else if ((buyQuantity - sellQuantity + cargo.getCurrentCapacity()) > cargo.getMaxCapacity()) {
            Toast.makeText(this, "You don't have enough cargo space for that!", Toast.LENGTH_LONG).show();
        } else {
            player.setCredits(player.getCredits() + creditChange);
            market.decreaseStock(resource, buyQuantity - sellQuantity);
            cargo.increaseStock(resource, buyQuantity - sellQuantity);
            finish();
        }
    }

    public void increaseBuyQuantity(View view) {
        if (remainingBuyQuantity > 0) {
            remainingBuyQuantity--;
            buyQuantity++;
            updateRemainingBuyQuantity();
            updateTotalTradeCost();
        }
    }

    public void increaseSellQuantity(View view) {
        if (remainingSellQuantity > 0) {
            remainingSellQuantity--;
            sellQuantity++;
            updateRemainingSellQuantity();
            updateTotalTradeCost();
        }
    }

    public void decreaseBuyQuantity(View view) {
        if (buyQuantity > 0) {
            remainingBuyQuantity++;
            buyQuantity--;
            updateRemainingBuyQuantity();
            updateTotalTradeCost();
        }
    }

    public void decreaseSellQuantity(View view) {
        if (sellQuantity > 0) {
            remainingSellQuantity++;
            sellQuantity--;
            updateRemainingSellQuantity();
            updateTotalTradeCost();
        }
    }

    private void updateRemainingBuyQuantity() {
        buyQuantityText.setText(String.format("%s", buyQuantity));
        remainingBuyQuantityText.setText(String.format("%s", remainingBuyQuantity));
    }

    private void updateRemainingSellQuantity() {
        sellQuantityText.setText(String.format("%s", sellQuantity));
        remainingSellQuantityText.setText(String.format("%s", remainingSellQuantity));
    }

    private void updateRemainingPlayerCash() { playerCashText.setText(String.format("%s", player.getCredits()));}

    private void updateTotalTradeCost() {
        Integer tradeCost = ((sellQuantity - buyQuantity) * market.getPrice(resource));
        totalTransactionText.setText(String.format("%s", tradeCost));
    }
}

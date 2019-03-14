package com.order66.team66.spacetraderapp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

    private int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        viewmodel = new MarketViewModel();

        market = viewmodel.getMarket();
        player = viewmodel.getPlayer();
        cargo = player.getCargoHold();

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

//        public void increaseQuantity(View view) {
//            if (quantity <= remainingQuantity) {
//                remainingQuantity--;
//                quantity++;
//                updateQuantity(remainingQuantity);
//            }
//        }
//
//        public void decreaseQuantity(View view) {
//            if (quantity > 0) {
//                remainingQuantity++;
//                quantity--;
//                updateQuantity(remainingQuantity);
//            }
//        }
//
//        private void updateQuantity(int quantity) {
//            quantityText.setText(String.format("%s", remainingQuantity));
//        }
    }
}

package com.example.cashreg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HistoryInfoActivity extends AppCompatActivity {
    TextView Product, Price, Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Product = (TextView) findViewById(R.id.hProd);
        Price = (TextView) findViewById(R.id.hPrice);
        Date = (TextView) findViewById(R.id.hDate);

        History history =(History) getIntent().getSerializableExtra("HISTORY_INFO");

        Product.setText(history.task);
        Price.setText(history.price);
        Date.setText(history.purchase_date);

    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
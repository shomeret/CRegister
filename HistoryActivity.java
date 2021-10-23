package com.example.cashreg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    TasksAdapter histAdapt;

    RecyclerView listItem;
    TextView prodName, prodQty, prodPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<Tasks> lst = (ArrayList<Tasks>) args.getSerializable("Arraylist");
        ArrayList<History> lst_history = (ArrayList<History>) args.getSerializable("LIST_HISTORY_PG");
        prodName = (TextView) findViewById(R.id.prod_list);
        prodQty = (TextView) findViewById(R.id.prod_list2);
        prodPrice = (TextView) findViewById(R.id.prod_list3);
        listItem = findViewById((R.id.viewListHistory));
        histAdapt = new TasksAdapter(this, lst, new TasksAdapter.TaskListener() {
            @Override
            public void onTaskClick(int position) {
                Intent intent = new Intent(HistoryActivity.this,HistoryInfoActivity.class);
                intent.putExtra("HISTORY_INFO",lst_history.get(position));
                startActivity(intent);
            }
        });
        listItem.setAdapter(histAdapt);



    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
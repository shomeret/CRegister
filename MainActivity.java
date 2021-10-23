package com.example.cashreg;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    int qtyPosition, qtyStock, usrQty, newQty, overStock;
    double price, totalPrice;
    String newQtyStr = "";
    String indx ="";
    String prodStr = "";
    String totalStr = "";
    String stockStr = "";
    TextView total;
    RecyclerView item;
    ArrayList<Tasks> listOfTasks, listOfHistory;
    ArrayList<History> listHistoryPg;
    TasksAdapter adapter;
    HistoryAdapter historyAdapter;
    int stockFlag = 0;
    int viewListFlag = 0;
    int badInputFlag = 0;
    int globalPos = -1;
    String qnt_str = "";
    String product_list[] = new String[]{};
    String product_price[] = new String[]{};
    String product_quantity[] = new String[]{};
    TextView item_name;
    TextView quant_view;
    TextView prod_type;
    AlertDialog.Builder builder;
    Button OneB, TwoB, ThreeB, FourB, FiveB, SixB, SevenB, EightB, NineB, ZeroB, ClearB, BuyB, ManagerB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new AlertDialog.Builder(this);
        // Find all the ID's and set the variable = ID
        item =  (RecyclerView) findViewById((R.id.viewList));
        item_name = (TextView) findViewById(R.id.prod_list);
        quant_view = (TextView) findViewById(R.id.viewQuant);
        prod_type = (TextView) findViewById(R.id.viewProdType);
        total =  (TextView) findViewById(R.id.viewTotal);

        ZeroB = (Button) findViewById(R.id.bZero);
        OneB = (Button) findViewById(R.id.bOne);
        TwoB = (Button) findViewById(R.id.bTwo);
        ThreeB = (Button) findViewById(R.id.bThree);
        FourB = (Button) findViewById(R.id.bFour);
        FiveB = (Button) findViewById(R.id.bFive);
        SixB = (Button) findViewById(R.id.bSix);
        SevenB = (Button) findViewById(R.id.bSeven);
        EightB = (Button) findViewById(R.id.bEight);
        NineB = (Button) findViewById(R.id.bNine);
        ClearB = (Button) findViewById(R.id.bClear);
        BuyB = (Button) findViewById(R.id.bBuy);
        ManagerB = (Button) findViewById(R.id.bManager);

        /*product_list = new String[] {"Pante", "Shoes", "Hats"};
        product_price = new String[]{"20.44", "10.44", "5.9"};
        product_quantity = new String[]{"10", "100", "30"};*/

        listHistoryPg = new ArrayList<>(1);
        historyAdapter = new HistoryAdapter(this, listHistoryPg);
        listOfTasks = new ArrayList<>(1);
        listOfHistory = new ArrayList<>(1);
        listOfTasks.add(new Tasks("Pante", "20.44", "10"));
        listOfTasks.add(new Tasks("Shoes", "10.44", "100"));
        listOfTasks.add(new Tasks("Hats", "5.9", "30"));
        adapter = new TasksAdapter(this, listOfTasks, new TasksAdapter.TaskListener() {
            @Override
            public void onTaskClick(int position) {
                viewListFlag = 1;
                globalPos = position;
                Tasks tas = listOfTasks.get(position);
                prodStr = tas.task;
                prod_type.setText(tas.task);

                if (!qnt_str.isEmpty()) {
                    usrQty = Integer.parseInt(qnt_str);
                    totalPrice = Double.parseDouble(tas.price) * usrQty;
                    totalStr = String.format("%.2f", totalPrice);
                    total.setText(totalStr);
                }
            }
        });
        item.setAdapter(adapter);





        ClearB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalPos = -1;
                prod_type.setText("Product Type");
                qnt_str = "";
                prodStr = "";
                quant_view.setText("Quantity");
                total.setText("Total");
                stockFlag = 0;
            }
        });

        OneB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qnt_str = qnt_str + "1";
                quant_view.setText(qnt_str);
            }
        });

        TwoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qnt_str = qnt_str + "2";
                quant_view.setText(qnt_str);
            }
        });

        ThreeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qnt_str = qnt_str + "3";
                quant_view.setText(qnt_str);
            }
        });


        FourB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qnt_str = qnt_str + "4";
                quant_view.setText(qnt_str);
            }
        });


        FiveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qnt_str = qnt_str + "5";
                quant_view.setText(qnt_str);
            }
        });


        SixB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qnt_str = qnt_str + "6";
                quant_view.setText(qnt_str);
            }
        });


        SevenB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qnt_str = qnt_str + "7";
                quant_view.setText(qnt_str);
            }
        });

        EightB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qnt_str = qnt_str + "8";
                quant_view.setText(qnt_str);
            }
        });


        NineB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qnt_str = qnt_str + "9";
                quant_view.setText(qnt_str);
            }
        });

        ZeroB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qnt_str = qnt_str + "0";
                quant_view.setText(qnt_str);
            }
        });


        BuyB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                overStock = 0;

                badInputFlag = 0;
                if (qnt_str.isEmpty() || viewListFlag == 0) {
                    Toast.makeText(context, "All fields are required", Toast.LENGTH_LONG).show();
                    badInputFlag = 1;

                }

                if (badInputFlag != 1){
                    if (globalPos != -1) {
                        //Log.d("MyMsg", usrQty + " is the usrQty");
                        Tasks tmpTask = listOfTasks.get(globalPos);
                        usrQty = Integer.parseInt(qnt_str);
                        qtyStock = Integer.parseInt(tmpTask.qty);

                        if (qtyStock < usrQty) {
                            Toast.makeText(context,"Not enough quantity in stock!!!", Toast.LENGTH_LONG).show();
                            overStock = 1;
                        }
                        totalPrice = Double.parseDouble(tmpTask.price) * usrQty;
                        totalStr = String.format("%.2f", totalPrice);
                        total.setText(totalStr);

                    }

                    if (overStock != 1) {
                        Tasks tmpTask = listOfTasks.get(globalPos);
                        builder.create();
                        builder.setTitle("Thank You for your purchase");
                        builder.setMessage("Your purchase is " + qnt_str + " " + prodStr + " for " + totalStr);
                        builder.show();
                        newQty = qtyStock - usrQty;
                        String newQtyStr = Integer.toString(newQty);
                        tmpTask.qty = newQtyStr;
                        listOfTasks.set(globalPos, tmpTask);
                        String timeStamp = new SimpleDateFormat("E MMM dd HH:mm:ss 'EDT' yyyy").format(new Date());
                        listOfHistory.add(new Tasks(prodStr, totalStr, qnt_str));
                        listHistoryPg.add(new History(prodStr, totalStr, qnt_str, timeStamp));
                        adapter.notifyDataSetChanged();

                        //Same as clearB
                        globalPos = -1;
                        prod_type.setText("Product Type");
                        qnt_str = "";
                        prodStr = "";
                        quant_view.setText("Quantity");
                        total.setText("Total");
                        stockFlag = 0;

                    }


                }
            }
        });


    }



    public void manager_click(View view) {
        Intent myint = new Intent(this, HistoryActivity.class);
        Bundle args = new Bundle();
        args.putSerializable("Arraylist", (Serializable)listOfHistory);
        args.putSerializable("LIST_HISTORY_PG",listHistoryPg);
        myint.putExtra("BUNDLE", args);
        startActivity(myint);



    }
}
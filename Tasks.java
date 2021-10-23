package com.example.cashreg;
import android.os.Parcelable;

import org.parceler.Parcel;
import java.io.Serializable;


public class Tasks implements Serializable {
    public String task;
    public String price;
    public String qty;

    public Tasks(String task, String price, String qty) {
        this.task = task;
        this.price = price;
        this.qty = qty;
    }
}

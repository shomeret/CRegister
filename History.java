package com.example.cashreg;

import java.io.Serializable;
import java.util.Date;

public class History implements Serializable {
    public String task;
    public String price;
    public String qty;
    public String purchase_date;

    public History(String task, String price, String qty, String purchase_date) {
        this.task = task;
        this.price = price;
        this.qty = qty;
        this.purchase_date = purchase_date;
    }
}

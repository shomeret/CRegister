package com.example.cashreg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

        Context context;
        ArrayList<History> histories;

        public HistoryAdapter(Context context, ArrayList<History> histories) {
            this.context = context;
            this.histories = histories;
        }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_view, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.bindData(position);
    }



    @Override
    public int getItemCount() {
        return histories.size();
    }

         class ViewHolder extends RecyclerView.ViewHolder{
            View view;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                this.view = itemView;
            }

            public void bindData(int i){
                TextView txtName = (TextView) view.findViewById(R.id.hProd);
                TextView txtPrice = (TextView) view.findViewById(R.id.hPrice);
                TextView txtDate = (TextView) view.findViewById(R.id.hDate);

                txtName.setText(histories.get(i).task);
                txtPrice.setText(histories.get(i).price);
                txtDate.setText((histories.get(i).purchase_date).toString());
            }


        }
    }


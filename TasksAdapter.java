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

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {

    Context context;
    ArrayList<Tasks> tasks;
    TaskListener listener;

    public TasksAdapter(Context context, ArrayList<Tasks> tasks, TaskListener listener) {
        this.context = context;
        this.tasks = tasks;
        this.listener = listener;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
    }


    @Override
    public int getItemCount() {
        return tasks.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }

        public void bindData(int i) {
            TextView txtName = (TextView) view.findViewById(R.id.prod_list);
            TextView txtPrice = (TextView) view.findViewById(R.id.prod_list2);
            TextView txtQty = (TextView) view.findViewById(R.id.prod_list3);

            txtName.setText(tasks.get(i).task);
            txtPrice.setText(tasks.get(i).price);
            txtQty.setText(tasks.get(i).qty);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onTaskClick(i);
                }
            });
        }
        }

        interface TaskListener{
        void onTaskClick(int position);
        }



}

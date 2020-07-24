package com.myexample.fire_base;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataHolder extends RecyclerView.ViewHolder {
    View view;
    public DataHolder(@NonNull View itemView) {
        super(itemView);
        view  = itemView;
    }
    public void setView(Context context, String name, int roll, String email, String add, String branch)
    {
        TextView sname=view.findViewById(R.id.name);
        TextView sroll=view.findViewById(R.id.roll_no);
        TextView semail=view.findViewById(R.id.email);
        TextView sadd=view.findViewById(R.id.add);
        TextView sbranch=view.findViewById(R.id.branch);
        sname.setText(name);
        sroll.setText(String.valueOf(roll));
        semail.setText(email);
        sadd.setText(add);
        sbranch.setText(branch);
    }
}

package com.example.todolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TodoAdapter extends ArrayAdapter<Todo> {

    Context contextto;
    int res = R.layout.row;
    List<Todo> items;
    //private Object LayoutInflater;

    public TodoAdapter(@NonNull Context context, int resource, @NonNull List<Todo> todos) {
        super(context, resource, todos);
        contextto=context;
        res=resource;
        items=todos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        LayoutInflater layInflater = (LayoutInflater)contextto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = layInflater.inflate(res,parent,false);
        TextView tittle = row.findViewById(R.id.tv_tittle);
        tittle.setText(items.get(position).getTittle());
        TextView describ = row.findViewById(R.id.tv_description);
        describ.setText(items.get(position).getDescription());
        ImageView image = row.findViewById(R.id.imageView);
        image.setImageResource(items.get(position).getImage());
        return row;
    }
}

package com.example.todolistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
TodoAdapter  arrayAdapter;
//String [] arr = {"Frist","Scond"};
ArrayList<Todo> arrayTodo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.myLlist);

        arrayTodo = new ArrayList<>();
        arrayTodo.add(new Todo("1","describe 1",R.mipmap.ic_launcher_round));
        arrayTodo.add(new Todo("2","describe 2",R.mipmap.ic_launcher));
        arrayTodo.add(new Todo("3","describe 3",R.mipmap.ic_launcher));
        arrayTodo.add(new Todo("4","describe 4",R.drawable.ic_launcher_background));
        arrayTodo.add(new Todo("5","describe 5",R.mipmap.ic_launcher_round));
        arrayTodo.add(new Todo("6","describe 6",R.mipmap.ic_launcher));
        arrayTodo.add(new Todo("7","describe 7",R.mipmap.ic_launcher_round));
        arrayTodo.add(new Todo("8","describe 8",R.mipmap.ic_launcher));
        arrayTodo.add(new Todo("9","describe 9",R.mipmap.ic_launcher_round));
        arrayTodo.add(new Todo("10","describe 10",R.mipmap.ic_launcher));
        arrayTodo.add(new Todo("11","describe 11",R.mipmap.ic_launcher_round));
        arrayTodo.add(new Todo("12","describe 12",R.mipmap.ic_launcher_round));
        arrayTodo.add(new Todo("13","describe 13",R.mipmap.ic_launcher_round));
        arrayTodo.add(new Todo("14","describe 14",R.mipmap.ic_launcher));
        arrayTodo.add(new Todo("15","describe 15",R.mipmap.ic_launcher));
        arrayTodo.add(new Todo("16","describe 16",R.mipmap.ic_launcher_round));
        arrayAdapter   = new TodoAdapter(this,R.layout.row,arrayTodo);
        listView.setAdapter(arrayAdapter);



// open new activity

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,ScondPage.class);
                intent.putExtra("tittle",arrayTodo.get(i).getTittle());
                intent.putExtra("describe",arrayTodo.get(i).getDescription());
                intent.putExtra("image",arrayTodo.get(i).getImage());
                startActivityForResult(intent,10);
                //startActivity(intent);
            }
        });



 // longe Onclick
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                CreatAlart(i);
                return true;
            }
        });
    }


    // Method Alart For delete Item ^_^
    private void CreatAlart(int position) {
        final int positionToRemove = position;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete Item")
                .setMessage("Are you sure Ya Fatema to delete this item ^_^ ?")
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayTodo.remove(positionToRemove);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
package com.example.todolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ScondPage extends AppCompatActivity {
Button back;
TextView tit;
TextView des;
ImageView img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scond_page);

        tit = findViewById(R.id.tv_tittle2);
        des = findViewById(R.id.tv_description2);
        img2 = findViewById(R.id.image2);
        back = findViewById(R.id.button);


        tit.setText(getIntent().getStringExtra("tittle"));
        des.setText(getIntent().getStringExtra("describe"));


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(15,intent);
                finish();
            }
        });
    }
}
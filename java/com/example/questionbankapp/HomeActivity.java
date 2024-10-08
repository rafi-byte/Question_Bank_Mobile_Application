package com.example.questionbankapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    ImageButton buetButtonId,kuetButtonId,duButtonId,juButtonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versity);

        buetButtonId=(ImageButton)  findViewById(R.id.buetButton);
        kuetButtonId=(ImageButton) findViewById(R.id.kuetButton);
        duButtonId=(ImageButton) findViewById(R.id.duButton);
        juButtonId=(ImageButton) findViewById(R.id.juButton);

        buetButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,SubjectActivity.class);
                startActivity(intent);
            }
        });

        kuetButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,SubjectActivity.class);
                startActivity(intent);
            }
        });

        duButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,SubjectActivity.class);
                startActivity(intent);
            }
        });

        juButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,SubjectActivity.class);
                startActivity(intent);
            }
        });

    }

}

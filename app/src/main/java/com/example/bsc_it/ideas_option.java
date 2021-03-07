package com.example.bsc_it;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ideas_option extends AppCompatActivity {
    Button uploadfiles;
    Button viewuploadedfiles;
    Button ai_ml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideas_option);

        uploadfiles=findViewById(R.id.uploadfiles);
        viewuploadedfiles=findViewById(R.id.viewuploadedfiles);
        ai_ml=findViewById(R.id.ai_ml);

        uploadfiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ideas_option.this,android_ideas.class);
                startActivity(intent);
            }
        });

        viewuploadedfiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ideas_option.this,website_ideas.class);
                startActivity(intent);

            }
        });

        ai_ml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ideas_option.this,AI_ML_ideas.class);
                startActivity(intent);


            }
        });
    }


    }


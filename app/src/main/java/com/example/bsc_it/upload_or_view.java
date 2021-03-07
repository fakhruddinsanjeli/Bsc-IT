package com.example.bsc_it;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class upload_or_view extends AppCompatActivity {
    Button uploadfiles;
    Button viewuploadedfiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_or_view);
        uploadfiles=findViewById(R.id.uploadfiles);
        viewuploadedfiles=findViewById(R.id.viewuploadedfiles);

        uploadfiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(upload_or_view.this,upload_sem_option.class);
                startActivity(intent);
            }
        });

        viewuploadedfiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(upload_or_view.this,view_upload_sem_option.class);
                startActivity(intent);

            }
        });
    }


}

package com.example.bsc_it;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.net.URI;

public class MainActivity extends AppCompatActivity {
    GridLayout maingrid;
    ImageView info;
    private long backpressedtime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maingrid=findViewById(R.id.maingrid);
        setsinglevent(maingrid);
        info=findViewById(R.id.information);


        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, com.example.bsc_it.info.class);
                startActivity(intent);
            }
        });


        }

    @Override
    public void onBackPressed() {

        if(backpressedtime +2000> System.currentTimeMillis()){
            super.onBackPressed();
            return;


        }
        else {

            Toast.makeText(getApplicationContext(),"Press back again to Exit",Toast.LENGTH_SHORT).show();

        }
        backpressedtime=System.currentTimeMillis();

    }

    private  void setsinglevent(GridLayout maingrid){
        for(int i=0;i<maingrid.getChildCount();i++){

            CardView cardview=(CardView) maingrid.getChildAt(i);
            final int final1=i;

            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(final1==0){

                        Intent intent=new Intent(MainActivity.this,pastpapers_sem_option.class);
                        startActivity(intent);





                    }

                    else if(final1==1){

                        Intent intent=new Intent(MainActivity.this,upload_or_view.class);
                        startActivity(intent);





                    }
                    else if(final1==2){

                        Intent intent=new Intent(MainActivity.this,notes_sem_option.class);
                        startActivity(intent);





                    }
                    else if(final1==3){

                        Intent intent=new Intent(MainActivity.this,ideas_option.class);
                        startActivity(intent);





                    }
                }
            });


        }


    }


}

package com.example.bsc_it;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;

public class android_ideas extends AppCompatActivity {
    ListView itemlist;
    String [] ideas={"Mall navigation map","Tip Calculator app","Food recommendation app","Parking space finder app",
            "Virtual study group app","Language learning app","Gift suggestion for friend app",
    "What’s in your fridge app","Toy-exchanging app","Loaned money tracking app","Best vacation spot finder app",
    "Water-reminder app","Warranty-expiry alerts app"," Food donation app for restaurants","Task-scheduling and motivation app",
    "School notices app"," Scan and convert to pdf app"," LIFE HACKS APP","SYNC CAMERA to see your pose",
            "public toilet finder","Recipes by Ingredients"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_ideas);
        itemlist = findViewById(R.id.android_ideas);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ideas) {


            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = super.getView(position, convertView, parent);
                TextView mytext = view.findViewById(android.R.id.text1);
                mytext.setTextColor(Color.BLACK);
                mytext.setAllCaps(true);


                return view;
            }
        };


        itemlist.setAdapter(adapter);
    }





    }


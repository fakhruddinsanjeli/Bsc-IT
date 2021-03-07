package com.example.bsc_it;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class website_ideas extends AppCompatActivity {
    ListView itemlist;
    String [] ideas={"Detecting Phishing Websites Using ML","Secure Online Auction System",
            "Internet based Discussion Forum","Online Charity Management System","How-To-Do-Something website",
    "Online Portfolio","Origami Website","Meme Site","Quotes Website","Quiz Website","Student Information Chatbot ",
    "Intelligent Chat Bot","Automated Timetable Generator Php"," Campus Recruitment System",
            "college fest promotion","Bikes & Scooters Rental System"," Online Election System Project"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_ideas);





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

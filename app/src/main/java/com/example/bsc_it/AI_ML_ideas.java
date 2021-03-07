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

public class AI_ML_ideas extends AppCompatActivity {
    ListView itemlist;
    String [] ideas={"Price Negotiator Ecommerce ChatBot System","College Enquiry Chat Bot","Customer Targeted E-Commerce","Fake Product Review Monitoring",
    "Stock Market Analysis and Prediction","Online AI Shopping With M-Wallet System","Your Personal Nutritionist Using FatSecret API",
    "Question paper generator system","Content Summary Generation Using NLP","Next word predictor","Fake News Detection",
            "Artificial Intelligence Dietician","TV Show Popularity Analysis","Lane-Line Detection System in Python",
            "Real Estate Search Based On Data Mining"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_i__m_l_ideas);







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

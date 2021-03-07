package com.example.bsc_it;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

public class upload_sem_option extends AppCompatActivity {
    GridLayout maingrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_sem_option);
        maingrid=findViewById(R.id.maingrid);
        setsinglevent(maingrid);
    }
    private  void setsinglevent(GridLayout maingrid){
        for(int i=0;i<maingrid.getChildCount();i++){

            CardView cardview=(CardView) maingrid.getChildAt(i);
            final int final1=i;

            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(final1==0){

                        Intent intent=new Intent(upload_sem_option.this,upload_sem1.class);


                        startActivity(intent);




                    }

                    else if(final1==1){

                        Intent intent=new Intent(upload_sem_option.this,upload_sem2.class);


                        startActivity(intent);




                    }
                    else if(final1==2){

                        Intent intent=new Intent(upload_sem_option.this,upload_sem3.class);
                        startActivity(intent);




                    }
                    else if(final1==3){

                        Intent intent=new Intent(upload_sem_option.this,upload_sem4.class);
                        startActivity(intent);




                    }

                    else if(final1==4){

                        Intent intent=new Intent(upload_sem_option.this,upload_sem5.class);
                        startActivity(intent);




                    }
                    else if(final1==5){

                        Intent intent=new Intent(upload_sem_option.this,upload_sem6.class);
                        startActivity(intent);




                    }
                }
            });


        }


    }
}

package com.example.bsc_it;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class view_notes_sem5 extends AppCompatActivity {
    ListView mListView;
    DatabaseReference mDatabaseReference;
    List<uploadPDF> mUploadPDFS;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notes_sem5);

        mListView=findViewById(R.id.sem1_upload_listview);

        mUploadPDFS=new ArrayList<>();



        viewallfiles();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                uploadPDF muploadPDF= mUploadPDFS.get(i);


                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(muploadPDF.getUrl()));
                startActivity(intent);

            }
        });
    }

    private void viewallfiles() {
        mProgressBar=findViewById(R.id.progressbar);

        mDatabaseReference= FirebaseDatabase.getInstance().getReference("sem5_notes");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postsnapshot: dataSnapshot.getChildren()){
                    uploadPDF uploadPDF=postsnapshot.getValue(com.example.bsc_it.uploadPDF.class);
                    mUploadPDFS.add(uploadPDF);


                }

                String[] uploads= new String[mUploadPDFS.size()];
                for(int i=0;i<uploads.length;i++){
                    uploads[i] = mUploadPDFS.get(i).getName();


                }
                mProgressBar.setVisibility(View.GONE);
                ArrayAdapter<String> adapter= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads){

                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                        View view=super.getView(position, convertView, parent);
                        TextView mytext= view.findViewById(android.R.id.text1);
                        mytext.setTextColor(Color.BLACK);
                        mytext.setAllCaps(true);


                        return view;
                    }
                };
                mListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    }


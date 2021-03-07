package com.example.bsc_it;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class sem2_upload extends AppCompatActivity {
    ListView mListView;
    DatabaseReference mDatabaseReference;
    List<uploadPDF> mUploadPDFS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem2_upload);
        mListView=findViewById(R.id.sem2_upload_listview);

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

        mDatabaseReference= FirebaseDatabase.getInstance().getReference("sem2");
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
                ArrayAdapter<String> adapter= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads);
                mListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

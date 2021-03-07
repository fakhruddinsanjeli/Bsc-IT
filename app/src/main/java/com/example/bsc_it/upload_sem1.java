package com.example.bsc_it;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class upload_sem1 extends AppCompatActivity {
    EditText mEditText;
    Button uploadbtn;

    StorageReference mStorageReference;
    DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_sem1);
        mEditText=findViewById(R.id.txt_pdfname);
        uploadbtn=findViewById(R.id.btn_upload);


        mStorageReference= FirebaseStorage.getInstance().getReference();

       Intent intent = getIntent();
        String str = intent.getStringExtra("value");



        mDatabaseReference= FirebaseDatabase.getInstance().getReference("sem1_upload");



        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sUsername = mEditText.getText().toString();
                if (sUsername.matches("")) {
                    Toast.makeText(getApplicationContext(), "Enter the Name of PDF", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    selectPDFfile();




                }
            }
        });
    }
    private void selectPDFfile(){


        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select PDF File"),1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode== RESULT_OK && data!=null && data.getData()!= null){


            uploadPDffile(data.getData());
        }

    }

    private void uploadPDffile(Uri data) {

        final ProgressDialog progressDialog= new ProgressDialog(this);
        progressDialog.setTitle("Uploading....");
        progressDialog.show();
        StorageReference reference=mStorageReference.child("sem2/"+System.currentTimeMillis()+".pdf");
        reference.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Task<Uri> uri= taskSnapshot.getStorage().getDownloadUrl();
                while(!uri.isComplete());
                Uri url=uri.getResult();

                uploadPDF uploadPDF= new uploadPDF(mEditText.getText().toString(),url.toString());
                mDatabaseReference.child(mDatabaseReference.push().getKey()).setValue(uploadPDF);
                Toast.makeText(getApplicationContext(),"File Uploaded",Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                mEditText.getText().clear();


            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                double progress =(100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();

                progressDialog.setMessage("Uploaded: "+(int)progress+ "%");

            }
        });
    }
    public void btn_view_files(View view) {

        startActivity(new Intent(getApplicationContext(),sem1_upload.class));
    }
}

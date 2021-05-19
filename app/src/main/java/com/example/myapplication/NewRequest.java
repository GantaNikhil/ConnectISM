package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class NewRequest extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public EditText sub, cont;
    public Button Choose,Upload,Submit;
    public ImageView Image;

    StorageReference mStorageRef;
    DatabaseReference myRef;
    private StorageTask uploadTask;

    Details details;

    public Uri imguri;
    long maxid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_request);

        mStorageRef= FirebaseStorage.getInstance().getReference("Images");



        sub= findViewById(R.id.subject);
        cont= findViewById(R.id.content);
        Submit= findViewById(R.id.submitbtn);
        Choose= findViewById(R.id.choosebtn);
        Upload= findViewById(R.id.uploadbtn);
        Image= findViewById(R.id.image);

        details= new Details();
        myRef= FirebaseDatabase.getInstance().getReference().child("Details");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    maxid=snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filechooser();
            }
        });

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uploadTask!=null && uploadTask.isInProgress()){
                    Toast.makeText(NewRequest.this,"Upload in progress",Toast.LENGTH_SHORT).show();
                }else{
                    FileUploader();
                }
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details.setSubject(sub.getText().toString().trim());
                details.setDetails(cont.getText().toString().trim());
                myRef.child(String.valueOf(maxid+1)).setValue(details);
                Toast.makeText(NewRequest.this,"Grievance filed successfully",Toast.LENGTH_SHORT).show();
            }
        });

        Spinner spinner1= findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.grievance, android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        Spinner spinner2= findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2= ArrayAdapter.createFromResource(this,R.array.visibility, android.R.layout.simple_dropdown_item_1line);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);
    }

    private  String getExtension(Uri uri){
        ContentResolver cr= getContentResolver();
        MimeTypeMap mimeTypeMap= MimeTypeMap.getSingleton();
        return  mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }

    private void FileUploader() {
        StorageReference Ref= mStorageRef.child(System.currentTimeMillis()+"."+getExtension(imguri));

        uploadTask= Ref.putFile(imguri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        //Get a URL to the uploaded content
                        //Uri downloadUrl= taskSnapshot.getDownloadUrl();
                        Toast.makeText(NewRequest.this,"Image Uploaded Successfully",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void Filechooser() {
        Intent intent= new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            imguri= data.getData();
            Image.setImageURI(imguri);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId()==R.id.spinner1){
            String text1=parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(),text1,Toast.LENGTH_SHORT).show();
        }else if(parent.getId()==R.id.spinner2){
            String text2=parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(),text2,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
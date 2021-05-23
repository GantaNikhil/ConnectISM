package com.example.myapplication;

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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageTask;

import java.util.HashMap;
import java.util.Map;

public class NewRequest extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public EditText sub, cont;
    String category,visibility;
    public Button Choose,Upload,Submit;
    public ImageView Image;
    FirebaseFirestore fstore;
    String userID,admissionno;
    //StorageReference mStorageRef;
    //DatabaseReference myRef;
    private StorageTask uploadTask;

    Details details;

    public Uri imguri;
    long maxid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_request);

      //  mStorageRef= FirebaseStorage.getInstance().getReference("Images");
        fstore=FirebaseFirestore.getInstance();

       // category = "Non-Academic Problems";
       // visibility = "Private";
        sub= findViewById(R.id.subject);
        cont= findViewById(R.id.content);
        Submit= findViewById(R.id.submitbtn);
        Choose= findViewById(R.id.choosebtn);
        Upload= findViewById(R.id.uploadbtn);
        Image= findViewById(R.id.image);
        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        details= new Details();


        DocumentReference documentReference = fstore.collection("students").document(userID);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
           admissionno = documentSnapshot.getString("admissionno");
            }
        });
     /*   DocumentReference documentReference = fstore.collection("request").document();
        Map<String,Object> request = new HashMap<>();
        request.put("subject",sub.getText().toString());
        request.put("content",cont.getText().toString());
        request.put("category",category);
        request.put("visibility",visibility);
        documentReference.set(request).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(NewRequest.this, "Done", Toast.LENGTH_SHORT).show();
            }
        });*/


      /*  myRef= FirebaseDatabase.getInstance().getReference().child("Details");
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
        });*/

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
               /* details.setSubject(sub.getText().toString().trim());
                details.setDetails(cont.getText().toString().trim());
                myRef.child(String.valueOf(maxid+1)).setValue(details);
                Toast.makeText(NewRequest.this,"Grievance filed successfully",Toast.LENGTH_SHORT).show();*/

                DocumentReference documentReference = fstore.collection("request").document();
                Map<String,Object> request = new HashMap<>();
                request.put("subject",sub.getText().toString().trim());
                request.put("content",cont.getText().toString().trim());
                request.put("category",category);
                request.put("visibility",visibility);
                request.put("admissionno",admissionno);
                request.put("uid",userID);
                documentReference.set(request).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(NewRequest.this, "Grievance filed successfully", Toast.LENGTH_SHORT).show();
                    }
                });
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
        /*StorageReference Ref= mStorageRef.child(System.currentTimeMillis()+"."+getExtension(imguri));

        uploadTask= Ref.putFile(imguri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        //Get a URL to the uploaded content
                        //Uri downloadUrl= taskSnapshot.getDownloadUrl();
                        Toast.makeText(NewRequest.this,"Image Uploaded Successfully",Toast.LENGTH_SHORT).show();
                    }
                });*/
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
             category=parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(),category,Toast.LENGTH_SHORT).show();
        }else if(parent.getId()==R.id.spinner2){
            visibility=parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(),visibility,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpAdmActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText  nameAdm, emailAdm, password1Adm, password2Adm;
    private Button SignUpButton;
    TextView mHaveAccountAdm;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminsignup);
        firebaseAuth = FirebaseAuth.getInstance();
        nameAdm= findViewById(R.id.nameadm);
        emailAdm = findViewById(R.id.emailadm);
        password1Adm = findViewById(R.id.password1adm);
        password2Adm = findViewById(R.id.password2adm);
        SignUpButton = findViewById(R.id.registeradm);
        mHaveAccountAdm= findViewById(R.id.have_accountadm);
        progressDialog = new ProgressDialog(this);

        Spinner spinner= findViewById(R.id.spinner);
        ArrayAdapter<CharSequence>adapter= ArrayAdapter.createFromResource(this,R.array.admins, android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                register();
            }
        });
        //handle login textview click listener
        mHaveAccountAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpAdmActivity.this,SignInAdmActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SignUpAdmActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void register() {
        String name= nameAdm.getText().toString();
        String email = emailAdm.getText().toString();
        String password1 = password1Adm.getText().toString();
        String password2 = password2Adm.getText().toString();

        String[] separated = email.split("@");
        if(TextUtils.isEmpty(name)){
            nameAdm.setError("Enter name");
            return;
        }else if (TextUtils.isEmpty(email)) {
            emailAdm.setError("Enter your Mail");
            return;
        } else if ((!separated[1].equals("iitism.ac.in"))) {
            emailAdm.setError("Enter Your College Email");
            return;
        } else if (TextUtils.isEmpty(password1)) {
            password1Adm.setError("Enter your Password");
            return;
        } else if (TextUtils.isEmpty(password2)) {
            password2Adm.setError("Confirm the password");
            return;
        } else if (!password1.equals(password2)) {
            password2Adm.setError("Different passwords");
            return;
        } else if (password1.length() < 4) {
            password1Adm.setError("Password is too short");
            return;
        } else if (!isValidEmail(email)) {
            emailAdm.setError("Invalid Email");
            return;
        }
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.createUserWithEmailAndPassword(email, password1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUpAdmActivity.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignUpAdmActivity.this, DashBoardActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SignUpAdmActivity.this, "Registration Failed!", Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });
    }

    private boolean isValidEmail(String email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

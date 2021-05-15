package com.example.myapplication;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInStuActivity extends AppCompatActivity {
    private EditText mEmailEt, mPasswordEt;
    private Button mLoginBtn;
    TextView notHaveAccntTv;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentsignin);
        firebaseAuth = FirebaseAuth.getInstance();

        mEmailEt= findViewById(R.id.emailEt);
        mPasswordEt= findViewById(R.id.passwordEt);
        mLoginBtn= findViewById(R.id.loginBtn);
        notHaveAccntTv= findViewById(R.id.nothave_accountTv);

        progressDialog = new ProgressDialog(this);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        //not have an account textview click
        notHaveAccntTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInStuActivity.this,SignUpStuActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SignInStuActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void login() {
        String email = mEmailEt.getText().toString();
        String password = mPasswordEt.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailEt.setError("Enter your Mail");
            return;

        } else if (TextUtils.isEmpty(password)) {
            mPasswordEt.setError("Enter your Password");
            return;
        }

        progressDialog.setMessage("Please wait.....");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignInStuActivity.this, "Successfully Signed In", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignInStuActivity.this, DashBoardActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SignInStuActivity.this, "Login Failed!", Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });
    }
}
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

public class SignInAdmActivity extends AppCompatActivity {
    private EditText emailAdm, passwordAdm;
    private Button SignInButton;
    TextView notHaveAccntAdm;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminsignin);
        firebaseAuth = FirebaseAuth.getInstance();

        emailAdm = findViewById(R.id.emailadm);
        passwordAdm = findViewById(R.id.passwordadm);
        SignInButton = findViewById(R.id.loginadm);
        notHaveAccntAdm= findViewById(R.id.nothave_accountAdm);

        progressDialog = new ProgressDialog(this);
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        //not have an account textview click
        notHaveAccntAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInAdmActivity.this,SignUpAdmActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SignInAdmActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void login() {
        String email = emailAdm.getText().toString();
        String password = passwordAdm.getText().toString();
        if (TextUtils.isEmpty(email)) {
            emailAdm.setError("Enter your Mail");
            return;

        } else if (TextUtils.isEmpty(password)) {
            passwordAdm.setError("Enter your Password");
            return;
        }

        progressDialog.setMessage("Please wait.....");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignInAdmActivity.this, "Successfully Signed In", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignInAdmActivity.this, DashBoardActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SignInAdmActivity.this, "Login Failed!", Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });
    }
}
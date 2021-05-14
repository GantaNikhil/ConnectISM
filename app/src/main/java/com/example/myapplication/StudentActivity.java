package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class StudentActivity extends AppCompatActivity {
    private TextView SignInStu, SignUpStu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student);
        SignInStu = findViewById(R.id.signinstu);
        SignUpStu = findViewById(R.id.signupstu);
        SignInStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, SignInStuActivity.class);
                startActivity(intent);
                finish();
            }
        });
        SignUpStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, SignUpStuActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(StudentActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
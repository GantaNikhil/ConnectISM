package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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

public class SignUpStuActivity extends AppCompatActivity {
    private EditText nameStu, admnumStu, emailStu, password1Stu, password2Stu;
    private Button SignUpButton;
    TextView mHaveAccountTv;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentsignup);
        firebaseAuth = FirebaseAuth.getInstance();
        nameStu= findViewById(R.id.namestu);
        admnumStu= findViewById(R.id.admnumstu);
        emailStu = findViewById(R.id.emailstu);
        password1Stu = findViewById(R.id.password1stu);
        password2Stu = findViewById(R.id.password2stu);
        SignUpButton = findViewById(R.id.registerstu);
        mHaveAccountTv= findViewById(R.id.have_accountTv);
        progressDialog = new ProgressDialog(this);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                register();
            }
        });
        //handle login textview click listener
        mHaveAccountTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpStuActivity.this,SignInStuActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SignUpStuActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void register() {
        String name= nameStu.getText().toString();
        String admno= admnumStu.getText().toString();
        String email = emailStu.getText().toString();
        String password1 = password1Stu.getText().toString();
        String password2 = password2Stu.getText().toString();

        String[] separated = email.split("@");
        if(TextUtils.isEmpty(name)){
            nameStu.setError("Enter name");
            return;
        }else if(TextUtils.isEmpty(admno)){
            admnumStu.setError("Enter Admission Number");
            return;
        } else if (TextUtils.isEmpty(email)) {
            emailStu.setError("Enter your Mail");
            return;
        } else if (!((separated[1].equals("am.iitism.ac.in")) || (separated[1].equals("cse.iitism.ac.in")) ||
                (separated[1].equals("ece.iitism.ac.in")) || (separated[1].equals("ee.iitism.ac.in")) ||
                (separated[1].equals("pe.iitism.ac.in")) || (separated[1].equals("ce.iitism.ac.in")) ||
                (separated[1].equals("cve.iitism.ac.in")) || (separated[1].equals("mme.iitism.ac.in")) ||
                (separated[1].equals("mech.iitism.ac.in"))||(separated[1].equals("agl.iitism.ac.in"))||
                (separated[1].equals("agp.iitism.ac.in"))||(separated[1].equals("ap.iitism.ac.in"))||
                (separated[1].equals("me.iitism.ac.in"))||(separated[1].equals("ese.iitism.ac.in"))||
                (separated[1].equals("fme.iitism.ac.in")))) {
            emailStu.setError("Enter Your College Email");
            return;
        } else if (TextUtils.isEmpty(password1)) {
            password1Stu.setError("Enter your Password");
            return;
        } else if (TextUtils.isEmpty(password2)) {
            password2Stu.setError("Confirm the password");
            return;
        } else if (!password1.equals(password2)) {
            password2Stu.setError("Different passwords");
            return;
        } else if (password1.length() < 4) {
            password1Stu.setError("Password is too short");
            return;
        } else if (!isValidEmail(email)) {
            emailStu.setError("Invalid Email");
            return;
        }
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.createUserWithEmailAndPassword(email, password1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUpStuActivity.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignUpStuActivity.this, BackgroundActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SignUpStuActivity.this, "Registration Failed!", Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });
    }

    private boolean isValidEmail(String email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}

package com.edusy.eatco.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.edusy.eatco.MainActivity;
import com.edusy.eatco.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {


    EditText lemail,lpassword;
    Button llogin,lregister;
    ProgressBar lprogressBar;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lemail=findViewById(R.id.lemail);
        lpassword=findViewById(R.id.lpassword);
        llogin=findViewById(R.id.llogin);
        lregister=findViewById(R.id.lregisterrr);
        lprogressBar=findViewById(R.id.lprogressBar);
        fauth= FirebaseAuth.getInstance();
        getSupportActionBar().hide();



        llogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email=lemail.getText().toString().trim();
                String password=lpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email))
                {
                    lemail.setError("email is required");
                    return;
                }
                if (TextUtils.isEmpty(password))
                {
                    lpassword.setError("password is required");
                    return;
                }
                if (password.length()<6)
                {
                    lpassword.setError("password should be gratter than 6");
                    return;
                }
                llogin.setVisibility(View.INVISIBLE);
                lprogressBar.setVisibility(View.VISIBLE);



                fauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(Login.this, "logged in", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();

                        }
                        else
                        {
                            Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
                            AlertDialog.Builder builder=new AlertDialog.Builder(Login.this);
                            builder.setMessage("Please Check your\nPassword or Email or Internet Connection \nHappy to Help You");
                            builder.setTitle("Login Error !");
                            builder.setIcon(R.drawable.ic_baseline_error_24);
                            builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            builder.create().show();

                            lprogressBar.setVisibility(View.GONE);
                            llogin.setVisibility(View.VISIBLE);
                        }

                    }
                });




            }
        });





        lregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
                finish();
            }
        });




    }





}
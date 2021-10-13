package com.edusy.eatco.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Register extends AppCompatActivity {


    EditText email,name,password,phonenumber;
    Button register,login;
    ProgressBar progressBar;
    FirebaseAuth mauth;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email=findViewById(R.id.email);
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        phonenumber=findViewById(R.id.phonenumber);
        register=findViewById(R.id.register);
        login=findViewById(R.id.login);
        progressBar=findViewById(R.id.progressBar);
         getSupportActionBar().hide();
        mauth=FirebaseAuth.getInstance();



        if(mauth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Email=email.getText().toString().trim();
                final String Password=password.getText().toString().trim();
                final String Name=name.getText().toString();
                final String Phonenumber=phonenumber.getText().toString();

                if (TextUtils.isEmpty(Name))
                {
                    name.setError("Name is Necessary");
                }

                if(TextUtils.isEmpty(Email))
                {
                    email.setError("email is necessary");
                    return;
                }

                if (TextUtils.isEmpty(Password))
                {
                    password.setError("password is necessary");
                    return;
                }
                if (Password.length() < 6)
                {
                    password.setError("password must be gratter than 6");
                    return;
                }

                if (TextUtils.isEmpty(Phonenumber))
                {

                    phonenumber.setError("phone number is necessary");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                register.setVisibility(View.INVISIBLE);

                mauth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Register.this,"user created",Toast.LENGTH_SHORT).show();
                            String remail=email.getText().toString();
                            String rname=name.getText().toString();
                            String rpassword=password.getText().toString();
                            String rphonenumber=phonenumber.getText().toString();

                            Userinfo userinfo=new Userinfo(

                                    rname,remail,rpassword,rphonenumber

                            );

                            userID=mauth.getCurrentUser().getUid();

                            FirebaseDatabase.getInstance().getReference("Store To Door User").child(userID).child("user Info")
                                    .setValue(userinfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful())
                                    {
                                        Toast.makeText(Register.this,"saved Account",Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(Register.this,"Please connect to internet",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                            startActivity(new Intent(getApplicationContext(),Login.class));
                            finish();


                        }
                        else
                        {
                            Toast.makeText(Register.this,"error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                            register.setVisibility(View.VISIBLE);
                        }

                    }
                });

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Register.this,Login.class);
                startActivity(intent);
                finish();
            }
        });


    }









}
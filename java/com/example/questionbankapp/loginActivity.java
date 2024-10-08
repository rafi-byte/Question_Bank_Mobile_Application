package com.example.questionbankapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {
    EditText username,password;
    Button btnlogin,signUp;
    authDbhelper DB;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView((R.layout.signin));

        username=(EditText) findViewById(R.id.username1);
        password=(EditText) findViewById(R.id.password1);
        password =(EditText) findViewById(R.id.password1);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        btnlogin=(Button) findViewById(R.id.btnsignin1);
        signUp=(Button) findViewById(R.id.btnSignup);
        DB=new authDbhelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(loginActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserpass = DB.checkPassword(user, pass);
                    if (checkuserpass) {
                        // Display a loading dialog
                        final ProgressDialog progressDialog = new ProgressDialog(loginActivity.this);
                        progressDialog.setMessage("Signing in...");
                        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                        progressDialog.show();

                        // Dismiss the dialog after 1 second
                        new android.os.Handler().postDelayed(
                                new Runnable() {
                                    public void run() {
                                        progressDialog.dismiss();
                                        Toast.makeText(loginActivity.this, "Signing in Successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                        startActivity(intent);
                                    }
                                },
                                1000 // 1 second delay
                        );
                    } else {
                        Toast.makeText(loginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


       signUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(loginActivity.this,SignupActivity.class);
               startActivity(intent);
           }
       });
    }
}

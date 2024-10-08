package com.example.questionbankapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    EditText usernameEditText, passwordEditText, rePasswordEditText;

    authDbhelper DB;
    Button signUpButton,SigninButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        usernameEditText =(EditText) findViewById(R.id.username);
        passwordEditText =(EditText) findViewById(R.id.password);
        passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        rePasswordEditText = (EditText) findViewById(R.id.repassword);
        rePasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        signUpButton =(Button) findViewById(R.id.btnsignup);
        SigninButton=(Button) findViewById(R.id.btnsignin);

        DB=new authDbhelper(this);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=usernameEditText.getText().toString();
                String pass=passwordEditText.getText().toString();
                String repassword=rePasswordEditText.getText().toString();

                if(user.equals("")||pass.equals("")||repassword.equals("")){
                    Toast.makeText(SignupActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(repassword)){
                        Boolean checkuser=DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert= DB.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(SignupActivity.this,"Register Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(), loginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SignupActivity.this,"registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignupActivity.this,"User already existis!",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignupActivity.this,"Password is not matching!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        SigninButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), loginActivity.class);
                startActivity(intent);
            }
        });
    }
}

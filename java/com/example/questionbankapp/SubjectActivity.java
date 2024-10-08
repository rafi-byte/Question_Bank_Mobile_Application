package com.example.questionbankapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SubjectActivity extends AppCompatActivity {
     Button banglabtnID,englishbtnID,mathBtnId;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

         banglabtnID = (Button) findViewById(R.id.bangla);
         englishbtnID = (Button) findViewById(R.id.English);
         mathBtnId =(Button) findViewById(R.id.Math);

        banglabtnID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPaymentGatewayActivity();
            }
        });

        englishbtnID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPaymentGatewayActivity();
            }
        });

        mathBtnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubjectActivity.this, paymentGateWay.class);
                startActivity(intent);
            }
        });
    }

    private void startPaymentGatewayActivity() {
        Intent intent = new Intent(SubjectActivity.this, paymentGateWay.class);
        startActivityForResult(intent, 1); // Use any positive integer as a request code
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) { // The request code used when starting the paymentGateWay
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Back to Subject List", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();

            }
        }
    }



}

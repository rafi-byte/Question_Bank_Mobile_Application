package com.example.questionbankapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.questionbankapp.MainActivity;
import com.google.android.material.snackbar.Snackbar;

public class paymentGateWay extends AppCompatActivity {
    EditText payAmount;
    Button makePayment;
    public int payment = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        makePayment = findViewById(R.id.buttonMakePayment);
        payAmount = findViewById(R.id.editTextPaymentAmount);

        makePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String paymentAmountStr = payAmount.getText().toString();
                if (!TextUtils.isEmpty(paymentAmountStr)) {
                    int paymentAmount = Integer.parseInt(paymentAmountStr);
                    if (paymentAmount == 150) {
                        // Show loading ProgressDialog
                        ProgressDialog progressDialog = new ProgressDialog(paymentGateWay.this);
                        progressDialog.setMessage("Loading...");
                        progressDialog.setCancelable(false); // Prevent dismiss on touch outside
                        progressDialog.show();

                        // Simulate API call delay (Replace this actual API call)
                        // Here we use handler thread
                        new android.os.Handler().postDelayed(
                                new Runnable() {
                                    public void run() {
                                        // Dismiss the ProgressDialog
                                        progressDialog.dismiss();// Start MainActivity
                                        Intent intent = new Intent(paymentGateWay.this, MainActivity.class);
                                        startActivity(intent);

                                        // Set the result and finish the activity
                                        setResult(RESULT_OK);

                                        // Finish the current activity
                                        finish();
                                    }
                                },
                                2000
                        );
                    } else {
                        Snackbar insufficientAmountSnackbar = Snackbar.make(v, "Insufficient amount", Snackbar.LENGTH_SHORT);
                        View snackbarView = insufficientAmountSnackbar.getView();
                        insufficientAmountSnackbar.show();
                    }
                } else {
                    Toast.makeText(paymentGateWay.this, "Please enter a payment amount", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

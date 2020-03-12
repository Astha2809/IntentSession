package com.example.intentsession;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.intentsession.BundleConstants.ARG_EMAIL;
import static com.example.intentsession.BundleConstants.ARG_NAME;
import static com.example.intentsession.BundleConstants.ARG_PASSWORD;
import static com.example.intentsession.BundleConstants.ARG_PHONE;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText email;
    EditText password;
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        Button button = findViewById(R.id.signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dataPass();


            }
        });

    }

    void dataPass() {
        String fullName = name.getText().toString();
        String fullEmail = email.getText().toString();
        String fullPassword = password.getText().toString();
        String fullPhone = phone.getText().toString();
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra(ARG_NAME, fullName);
        intent.putExtra(ARG_EMAIL, fullEmail);
        intent.putExtra(ARG_PASSWORD, fullPassword);
        intent.putExtra(ARG_PHONE, fullPhone);
        startActivity(intent);

    }
}

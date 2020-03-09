package com.example.intentsession;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText name=findViewById(R.id.name);
        final EditText email=findViewById(R.id.email);
        final EditText password=findViewById(R.id.password);
        final EditText phone=findViewById(R.id.phone);
        Button button=findViewById(R.id.signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname=name.getText().toString();
                String fullemail=email.getText().toString();
                String fullpassword=password.getText().toString();
                String fullphone=phone.getText().toString();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("name",fullname);
                intent.putExtra("email",fullemail);
                intent.putExtra("password",fullpassword);
                intent.putExtra("phone",fullphone);
                startActivity(intent);

            }
        });

    }
}

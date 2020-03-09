package com.example.intentsession;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tv1 = findViewById(R.id.name1);
        TextView tv2 = findViewById(R.id.email1);
        TextView tv3 = findViewById(R.id.number1);
        TextView tv4 = findViewById(R.id.password1);
        final EditText ed = findViewById(R.id.url);
        Button button2 = findViewById(R.id.search);
        Button button3 = findViewById(R.id.permission);
        final WebView webView = findViewById(R.id.web);
        //wv1.setWebViewClient(new MyBrowser());

        Intent intent = getIntent();
        String firstname = intent.getStringExtra("name");
        String firstemail = intent.getStringExtra("email");
        String firstphone = intent.getStringExtra("phone");
        String firstpassword = intent.getStringExtra("password");
        tv1.setText(firstname);
        tv2.setText(firstemail);
        tv3.setText(firstphone);
        tv4.setText(firstpassword);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//        Intent viewIntent=new Intent("android.intent.action.VIEW", Uri.parse("http://www.stackoverflow.com/"));
//        startActivity(viewIntent);
//        try {
//            Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
//            myWebLink.setData(Uri.parse(url1));
//
//            startActivity(myWebLink);
//        }
//        catch (ActivityNotFoundException exception) {
//            Toast.makeText(Main2Activity.this, "Error text", Toast.LENGTH_SHORT).show();
//        }
                String url = ed.getText().toString();
                webView.loadUrl("http://" + url);


            }
        });
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CODE);
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "camera permission granted", Toast.LENGTH_SHORT).show();
                }


            }

        });
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera Permission granted", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

package com.example.intentsession;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.intentsession.utils.BundleConstants.ARG_EMAIL;
import static com.example.intentsession.utils.BundleConstants.ARG_NAME;
import static com.example.intentsession.utils.BundleConstants.ARG_PASSWORD;
import static com.example.intentsession.utils.BundleConstants.ARG_PHONE;

public class Main2Activity extends AppCompatActivity {
    private static final int REQUEST_CODE_CAMERA = 100;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    EditText ed;
    Button button2;
    Button button3;
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initUi();

        //wv1.setWebViewClient(new MyBrowser());

        Intent intent = getIntent();
        String firstName = intent.getStringExtra(ARG_NAME);
        String firstEmail = intent.getStringExtra(ARG_EMAIL);
        String firstPhone = intent.getStringExtra(ARG_PHONE);
        String firstPassword = intent.getStringExtra(ARG_PASSWORD);
        tv1.setText(firstName);
        tv2.setText(firstEmail);
        tv3.setText(firstPhone);
        tv4.setText(firstPassword);

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
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CODE_CAMERA);
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "camera permission granted", Toast.LENGTH_SHORT).show();
                }


            }

        });
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_CAMERA) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera Permission granted", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    void initUi() {
        tv1 = findViewById(R.id.name1);
        tv2 = findViewById(R.id.email1);
        tv3 = findViewById(R.id.number1);
        tv4 = findViewById(R.id.password1);
        ed = findViewById(R.id.url);
        button2 = findViewById(R.id.search);
        button3 = findViewById(R.id.permission);
        webView = findViewById(R.id.webview_main);

    }

}

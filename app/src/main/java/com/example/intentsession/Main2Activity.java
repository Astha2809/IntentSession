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
    //class variables should always be declare final.
    private static final int REQUEST_CODE_CAMERA = 100;
   private TextView textViewname;
    private TextView textViewemail;
    private TextView textViewnumber;
    private TextView textViewpassword;
    private EditText editText;
    private Button button2;
    private Button button3;
   private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initUi();
        receiveData();

        //wv1.setWebViewClient(new MyBrowser());



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
                String url = editText.getText().toString();
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

   private void initUi() {
        textViewname = findViewById(R.id.name1);
        textViewnumber = findViewById(R.id.email1);
        textViewemail = findViewById(R.id.number1);
        textViewpassword = findViewById(R.id.password1);
        editText = findViewById(R.id.url);
        button2 = findViewById(R.id.search);
        button3 = findViewById(R.id.permission);
        webView = findViewById(R.id.webview_main);

    }
    private void receiveData(){

        Intent intent = getIntent();
        String firstName = intent.getStringExtra(ARG_NAME);
        String firstEmail = intent.getStringExtra(ARG_EMAIL);
        String firstPhone = intent.getStringExtra(ARG_PHONE);
        String firstPassword = intent.getStringExtra(ARG_PASSWORD);
        textViewname.setText(firstName);
        textViewemail.setText(firstEmail);
        textViewnumber.setText(firstPhone);
        textViewpassword.setText(firstPassword);

    }

}

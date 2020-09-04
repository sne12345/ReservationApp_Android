package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    MaterialButton registerBtn;
    EditText etID, etPASSWD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("ORACLE");

        registerBtn = (MaterialButton)findViewById(R.id.btnLogin);
        etID = (EditText)findViewById(R.id.etID);
        etPASSWD = (EditText)findViewById(R.id.etPASSWD);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    String result;
                    String id = etID.getText().toString();
                    String pw = etPASSWD.getText().toString();

                    RegisterActivity task = new RegisterActivity();
                    result = task.execute(id, pw).get();
                } catch (Exception e) {
                    Log.i("DBtest", ".....ERROR.....!");
                }
            }
        });
    }
}
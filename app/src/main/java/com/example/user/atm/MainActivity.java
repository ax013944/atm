package com.example.user.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
    boolean logon = false;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (!logon) {

            Intent intent = new Intent(this, LoginActivity.class);

            startActivity(intent);

        }
    }
}

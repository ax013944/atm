package com.example.user.atm;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText ed_Userid = findViewById(R.id.ed_userid);
                String userid = getSharedPreferences("atm",MODE_PRIVATE)
                        .getString("USERID","");
                ed_Userid.setText(userid);
    }
    public void login(View view) {
        String userid = ((EditText)findViewById(R.id.ed_userid)).getText().toString();
        String passwd = ((EditText)findViewById(R.id.ed_password)).getText().toString();
        if ("jack".equals(userid) && "1234".equals(passwd)) {
            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show();
            getIntent().putExtra("Login_USERID",userid);
            getIntent().putExtra("Login_PASSWORD",passwd);
            setResult(RESULT_OK,getIntent());
            getSharedPreferences("USERID",MODE_PRIVATE)
                    .edit()
                    .putString("USERID",userid)
                    .apply();
            finish();
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("ATM")
                    .setMessage("登入失敗")
            .setPositiveButton("OK",null)
                    .show();

        }
    }
    public void cancel(View v){}
}
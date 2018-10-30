package com.example.user.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
    private static final int RC_LOGIN = 1;
    boolean logon = false;
    @Override

    protected void onActivityResult(int requestCode,int resultCode,Intent data){

        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==RC_LOGIN){
            if(resultCode == RESULT_OK){
                String uid=data.getStringExtra("Login_USERID");
                String pw=data.getStringExtra("Login_PASSWORD");
            }
        }
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!logon) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            startActivityForResult(intent,RC_LOGIN);
        }
    }
}

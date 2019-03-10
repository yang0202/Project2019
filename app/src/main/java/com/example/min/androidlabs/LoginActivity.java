package com.example.min.androidlabs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "LoginActivity";
   // String userEmail;
   private EditText loginName;
    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPref = getSharedPreferences( "LoginFile", Context.MODE_PRIVATE);
        loginName = (EditText) findViewById(R.id.editTextLogin);
        loginName.setText( sharedPref.getString("DefaultEmail",""));

        final Button loginBt = (Button) findViewById(R.id.buttonLogin);
        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor edit = sharedPref.edit();
                edit.putString("DefaultEmail",loginName.getText().toString());
                edit.commit();

                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                intent.putExtra( "defaultEmail", loginName.getText().toString());
                startActivity(intent);
            }
        });
        Log.e(ACTIVITY_NAME, "In onCreate()");
    }

    public void onStart(){
        super.onStart();
        Log.e(ACTIVITY_NAME, "In onStart()");
    }

    protected void onResume(){
        super.onResume();
        Log.e(ACTIVITY_NAME, "In onResume()");
    }


    protected void onPause(){
        super.onPause();
        SharedPreferences sharedPref = getSharedPreferences(
                "LoginFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPref.edit();
        EditText loginName = (EditText) findViewById(R.id.editTextLogin);
        edit.putString("DefaultEmail",loginName.getText().toString());
        edit.commit();
        Log.e(ACTIVITY_NAME, "In onPause()");
    }

    protected void onStop(){
        super.onStop();
        Log.e(ACTIVITY_NAME, "In onStop()");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.e(ACTIVITY_NAME, "In onDestroy()");
    }

}

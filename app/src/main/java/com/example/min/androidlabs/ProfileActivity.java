package com.example.min.androidlabs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.graphics.Bitmap;
import android.widget.EditText;
import android.provider.MediaStore;


public class ProfileActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "ProfileActivity";
    static final int REQUEST_IMAGE_CAPTURE = 1;

    EditText userEmail;


    ImageButton mImageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userEmail = findViewById( R.id.editText3 );
        userEmail.setText( getIntent().getStringExtra( "defaultEmail" ) );

        mImageButton = (ImageButton) findViewById(R.id.buttonTakePicture);

        mImageButton.setOnClickListener(new View.OnClickListener() {
            final int REQUEST_IMAGE_CAPTURE = 1;

            public void onClick(View view) {
                dispatchTakePictureIntent();
            }

            private void dispatchTakePictureIntent(){
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }

        });

        Button chatBt = (Button) findViewById(R.id.buttonGotoChat);
        chatBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, ChatRoomActivity.class);
                startActivity(intent);
            }
        });

        Button toolBt = (Button) findViewById(R.id.buttonGotoToolbar);
        toolBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, TestToolbar.class);
                startActivity(intent);
            }
        });


        Log.e(ACTIVITY_NAME, "In onCreate()");

        Log.e(ACTIVITY_NAME, "In onCreate()");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageButton.setImageBitmap(imageBitmap);
        }
        Log.e(ACTIVITY_NAME, "In onActivityResult()");
    }

}

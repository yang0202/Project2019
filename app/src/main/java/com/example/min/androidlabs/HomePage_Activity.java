package com.example.min.androidlabs;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

public class HomePage_Activity extends AppCompatActivity {

    private Toolbar tBar;
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_layout );

        tBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tBar);
        message = "This is the initial message";

        ImageButton dictionaryBt = (ImageButton) findViewById(R.id.dictionary_icon);
        dictionaryBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( HomePage_Activity.this, Dictionary_Activity.class);
                startActivity(intent);
            }
        });

        ImageButton newsBt = (ImageButton) findViewById(R.id.news_icon);

        newsBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( HomePage_Activity.this, News_Activity.class);
                startActivity(intent);
            }
        });


        ImageButton flightBt = (ImageButton) findViewById(R.id.fight_icon);
        flightBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( HomePage_Activity.this, Flight_Activity.class);
                startActivity(intent);
            }
        });

        ImageButton timerBt = (ImageButton) findViewById(R.id.timer_icon);
        timerBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( HomePage_Activity.this, Timer_Activity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            //what to do when the menu item is selected:
            case R.id.menuItem1:
                //Show the toast immediately:
               // Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent( HomePage_Activity.this, Dictionary_Activity.class);
                startActivity(intent1);



                break;

            case R.id.menuItem2:
                //Show the toast immediately:
                //Toast.makeText(this, "Welcome to Menu Example", Toast.LENGTH_LONG).show();
              //  messagePage();

                Intent intent2 = new Intent( HomePage_Activity.this, News_Activity.class);
                startActivity(intent2);


                break;



            case R.id.menuItem3:
                //Show the toast immediately:
                //Toast.makeText(this, "Welcome to Menu Example", Toast.LENGTH_LONG).show();
               // Snackbar sb = Snackbar.make(tBar, " ", Snackbar.LENGTH_LONG)
                    //    .setAction("GoBack", e ->{
                        //    Log.e("Menu Example", "Clicked Undo");
                       //     finish();
                     //   });
              //  sb.show();

                Intent intent3 = new Intent( HomePage_Activity.this, Flight_Activity.class);
                startActivity(intent3);


                break;
            case R.id.menuItem4:
                //Show the toast immediately:
               // Toast.makeText(this, "You clicked on the overflow menu", Toast.LENGTH_LONG).show();

                Intent intent4 = new Intent( HomePage_Activity.this, Timer_Activity.class);
                startActivity(intent4);

                break;
        }
        return true;
    }
    public void messagePage()
    {
        View middle = getLayoutInflater().inflate(R.layout.menu2_layout, null);

        EditText et = (EditText)middle.findViewById(R.id.view_edit_text);
        //btn.setOnClickListener( clk -> {et.setText("You clicked my button!");});

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("The Message")
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // What to do on Accept
                        message = et.getText().toString();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // What to do on Cancel
                    }
                }).setView(middle);

        builder.create().show();
    }


    public void onStart(){
        super.onStart();
    }

    public void onResume(){
        super.onResume();
    }

    public void onPause(){
        super.onPause();
    }

    protected void onStop(){
        super.onStop();
    }

    protected void onDestroy(){
        super.onDestroy();
    }




}


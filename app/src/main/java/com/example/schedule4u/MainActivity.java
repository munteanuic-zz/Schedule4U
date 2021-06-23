package com.example.schedule4u;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this block resets data each restart if 2nd argument is set to false
        Activity_S4U_Data_Accessor accessor = new Activity_S4U_Data_Accessor(getApplicationContext(),true);
        accessor.save(getApplicationContext());

        // to do's for today screen
        Button todo = (Button) findViewById(R.id.button2);
        todo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ToDos.class);
                startActivityForResult(myIntent, 0);
            }

        });

        // notifications screen
        Button notif = (Button) findViewById(R.id.button);
        notif.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Notifications.class);
                startActivityForResult(myIntent, 0);
            }

        });

        // recommendations screen
        Button recommend = (Button) findViewById(R.id.button3);
        recommend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Recommendations.class);
                startActivityForResult(myIntent, 0);
            }

        });

        // calendar screen
        Button calend = (Button) findViewById(R.id.button4);
        calend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Calendar.class);
                startActivityForResult(myIntent, 0);
            }

        });

        // productivity screen
        Button product = (Button) findViewById(R.id.button5);
        product.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Productivity.class);
                startActivityForResult(myIntent, 0);
            }

        });

        ImageButton scheduleAboutMe = findViewById(R.id.imageButton);
        scheduleAboutMe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ScheduleAboutMe.class);
                startActivityForResult(myIntent, 0);
            }

        });


        // deleted Items screen
//        Button delete = (Button) findViewById(R.id.button13);
//        delete.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent myIntent = new Intent(view.getContext(), DeletedItems.class);
//                startActivityForResult(myIntent, 0);
//            }
//
//        });

    }


}
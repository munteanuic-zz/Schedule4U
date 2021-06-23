package com.example.schedule4u;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Notifications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //for some reason I'm having trouble linking the button to the proper page.
        //when you link it to a page like the ToDos or something, it works fine. But not
        //for the class that I just created
        ImageButton notifAboutMe = (ImageButton) findViewById(R.id.imageButton2);
        notifAboutMe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), NotificationsAboutMe.class);
                startActivityForResult(myIntent, 0);
            }

        });

        //Be careful! This is code for image button not ordinarily button//
        ImageButton homebutton_4= (ImageButton) findViewById(R.id.homebutton4);
        homebutton_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
        //Be careful! This is code for image button not ordinarily button//

        // delete button for notification 1
        ImageButton notif_1 = (ImageButton) findViewById(R.id.image_button_1);
        TextView time_1 = (TextView) findViewById(R.id.notif_1_time);
        TextView message_1 = (TextView) findViewById(R.id.notification_1);

        // delete button for notification 2
        ImageButton notif_2 = (ImageButton) findViewById(R.id.image_button_2);
        TextView time_2 = (TextView) findViewById(R.id.notif_2_time);
        TextView message_2 = (TextView) findViewById(R.id.notification_2);

        notif_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
//                startActivityForResult(myIntent, 0);
                notif_1.setVisibility(view.INVISIBLE);
                time_1.setVisibility(view.INVISIBLE);
                message_1.setVisibility(view.INVISIBLE);

                // crude way to move second notification up
                notif_2.setX(notif_1.getX());
                notif_2.setY(notif_1.getY());
                time_2.setX(time_1.getX());
                time_2.setY(time_1.getY());
                message_2.setX(message_1.getX());
                message_2.setY(message_1.getY());

            }
        });

        notif_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
//                startActivityForResult(myIntent, 0);
                notif_2.setVisibility(view.INVISIBLE);
                time_2.setVisibility(view.INVISIBLE);
                message_2.setVisibility(view.INVISIBLE);
            }
        });

    }
}
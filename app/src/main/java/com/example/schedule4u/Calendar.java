package com.example.schedule4u;

import android.widget.CalendarView;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class Calendar extends AppCompatActivity {
    public void setDisplayListApril1() {
        Activity_S4U_Data_Accessor accessor = new Activity_S4U_Data_Accessor(getApplicationContext(), true);
        List<Activity_S4U> displayList = accessor.lists.active;
        TextView textViewCalendarActivityName1 = (TextView) findViewById(R.id.textViewCalendarActivityName1);
        TextView textViewCalendarActivityName2 = (TextView) findViewById(R.id.textViewCalendarActivityName2);
        TextView textViewCalendarActivityName3 = (TextView) findViewById(R.id.textViewCalendarActivityName3);
        if (displayList.size() > 0) {
            textViewCalendarActivityName1.setText(displayList.get(0).name);
            //System.out.println(displayList.get(0).name);
        } else {
            textViewCalendarActivityName1.setText("");
        }

        try {
            if (displayList.size() > 1) {
                textViewCalendarActivityName2.setText(displayList.get(1).name);
            } else {
                textViewCalendarActivityName2.setText("");
            }
            if (displayList.size() > 2) {
                textViewCalendarActivityName3.setText(displayList.get(2).name);
            } else {
                textViewCalendarActivityName3.setText("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        // change to content layout
        setDisplayListApril1();
    CalendarView myCalendar = (CalendarView) findViewById(R.id.calendarView);
    long myDate = myCalendar.getDate();
    System.out.println (myDate);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton calendarAboutMe = (ImageButton) findViewById(R.id.button9);
        calendarAboutMe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), CalendarAboutMe.class);
                startActivityForResult(myIntent, 0);

            }

        });



        //Be careful! This is code for image button not ordinarily button//
        ImageButton homebutton_0= (ImageButton) findViewById(R.id.homebutton);
        homebutton_0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
        //Be careful! This is code for image button not ordinarily button//

        CalendarView myCalendar = (CalendarView) findViewById(R.id.calendarView);
        myCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                String  curDate = String.valueOf(dayOfMonth);
                String  Year = String.valueOf(year);
                String  Month = String.valueOf(month);
                if (curDate.equals("1")){
                    setDisplayListApril1();
                }
                else if (curDate.equals("2")){
                    TextView activity1 = (TextView) findViewById(R.id.textViewCalendarActivityName1);
                    activity1.setText("Cook burgers");
                    TextView activity2 = (TextView) findViewById(R.id.textViewCalendarActivityName2);
                    activity2.setText("Write essay");
                    TextView activity3 = (TextView) findViewById(R.id.textViewCalendarActivityName3);
                    activity3.setText("See grandma");
                }
                else if (curDate.equals("3")){
                    TextView activity1 = (TextView) findViewById(R.id.textViewCalendarActivityName1);
                    activity1.setText("Clean apartment");
                    TextView activity2 = (TextView) findViewById(R.id.textViewCalendarActivityName2);
                    activity2.setText("Hang out with Lily");
                    TextView activity3 = (TextView) findViewById(R.id.textViewCalendarActivityName3);
                    activity3.setText("Call mum");
                } else {
                    TextView activity1 = (TextView) findViewById(R.id.textViewCalendarActivityName1);
                    activity1.setText(" ");
                    TextView activity2 = (TextView) findViewById(R.id.textViewCalendarActivityName2);
                    activity2.setText(" ");
                    TextView activity3 = (TextView) findViewById(R.id.textViewCalendarActivityName3);
                    activity3.setText(" ");
                }


            }
        });
    }

}
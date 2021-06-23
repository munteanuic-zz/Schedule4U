package com.example.schedule4u;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class ToDos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_dos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
///////////////////////////////////////


        Intent intent = getIntent();
        TextView name = (TextView) findViewById(R.id.eventtitletobeadded);
        TextView time = (TextView) findViewById(R.id.timetobeadded);
        TextView importance = (TextView) findViewById(R.id.prioritytobeadded);
//        TextView location = (TextView)findViewById(R.id.locationtobeadded);

        // create the get Intent object


        // receive the value by getStringExtra() method
        // and key must be same which is send by first activity
        String Name = intent.getStringExtra("taskname");
        String Time = intent.getStringExtra("tasktime");
        String Importance = intent.getStringExtra("importancelevel");
        String Location = intent.getStringExtra("tasklocation");
        // display the string into textView
        name.setText(Name);
        time.setText(Time);
        importance.setText(Importance);
//        location.setText(Location);


///////////////////////
        TextView name_1 = (TextView) findViewById(R.id.titletobeedited);
        TextView time_1 = (TextView) findViewById(R.id.timetobeedited);
        TextView importance_1 = (TextView) findViewById(R.id.prioritytobechanged);
//        TextView location_1 = (TextView)findViewById(R.id.locationtobeedited);

        // create the get Intent object


        // receive the value by getStringExtra() method
        // and key must be same which is send by first activity
        String Name_1 = intent.getStringExtra("taskNM");
        String Time_1 = intent.getStringExtra("taskTM");
        String Importance_1 = intent.getStringExtra("importanceLv");
        String Location_1 = intent.getStringExtra("taskLc");
        // display the string into textView
        name_1.setText(Name_1);
        time_1.setText(Time_1);
        importance_1.setText(Importance_1);
//        location_1.setText(Location_1);


//        TextView name_ = (TextView)findViewById(R.id.titletobeedited);
//        TextView time_ = (TextView)findViewById(R.id.timetobeedited);
//        TextView importance_ = (TextView)findViewById(R.id.prioritytobechanged);
//        TextView location_ = (TextView)findViewById(R.id.locationtobeedited);
//
//        // create the get Intent object
//
//
//        // receive the value by getStringExtra() method
//        // and key must be same which is send by first activity
//        String Name_ = intent.getStringExtra("taskname_");
//        String Time_ = intent.getStringExtra("tasktime_");
//        String Importance_ = intent.getStringExtra("importancelevel_");
//        String Location_ = intent.getStringExtra("tasklocation_");
//        // display the string into textView
//        name_.setText(Name_);
//        time_.setText(Time_);
//        importance_.setText(Importance_);
//        location_.setText(Location_);


        ///////////////////////////
        // A TEST TO SEE IF TASK INFO CAN BE TRANSMITTED ACROSS DIFFERENT ACTIVITIES
//        TextView text = (TextView)findViewById(R.id.textView44);
//        Intent intent = getIntent();
//        String str = intent.getStringExtra("event");
//        text.setText(str);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        //for some reason I'm having trouble linking the button to the proper page.
        //when you link it to a page like the ToDos or something, it works fine. But not
        //for the class that I just created
        //ImageButton toDosAboutMe = (ImageButton) findViewById(R.id.todos_aboutme);
        ImageButton toDosAboutMe = (ImageButton) findViewById(R.id.todos_aboutme2);
        toDosAboutMe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ToDosAboutMe.class);
                startActivityForResult(myIntent, 0);
            }

        });

        //create a task page is populated when this button is clicked
        Button createTask = (Button) findViewById(R.id.addNewTask);
        createTask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), CreateTask.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button deletedItemsPage = (Button) findViewById(R.id.deletedItems);
        deletedItemsPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), DeletedItems.class);
                startActivityForResult(myIntent, 0);
            }

        });

        // the edit button is here
        Button editTask = (Button) findViewById(R.id.edit2);
        editTask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_S4U_Data_Accessor accessor = new Activity_S4U_Data_Accessor(getApplicationContext(), true);
                accessor.lists.edit_task_index = 1; // since this is 2nd editTask we want 2nd task
                accessor.save(getApplicationContext());
                Intent myIntent = new Intent(view.getContext(), create_event_edit.class);
                startActivityForResult(myIntent, 0);
            }

        });

        //Be careful! This is code for image button not ordinarily button//
        ImageButton homebutton_10 = (ImageButton) findViewById(R.id.homebutton10);

        homebutton_10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
        //Be careful! This is code for image button not ordinarily button//

        // delete 3rd task
        Button toDoDelete3 = (Button) findViewById(R.id.toDosDelete3);
        toDoDelete3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_S4U_Data_Accessor accessor = new Activity_S4U_Data_Accessor(
                        getApplicationContext(),true);
                List<Activity_S4U> displayList = accessor.lists.active;
                if (displayList.size()>2) {
                    List<Activity_S4U> deletedList = accessor.lists.deleted;
                    deletedList.add(displayList.get(2));
                    Intent myIntent = new Intent(view.getContext(), DeletedItems.class);
                    myIntent.putExtra("deletedItem", displayList.get(2).name);
                    displayList.remove(2);
                    accessor.save(getApplicationContext());
                    startActivityForResult(myIntent, 0);
                }
                displayDataFromSave();
            }
        });
        RadioButton checkTask1 = (RadioButton) findViewById(R.id.checkTask1);
        checkTask1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_S4U_Data_Accessor accessor = new Activity_S4U_Data_Accessor(
                        getApplicationContext(),true);
                List<Activity_S4U> displayList = accessor.lists.active;
                if (displayList.size()>0) {
                    if(checkTask1.isChecked() && displayList.get(0).completed) {
                        checkTask1.setChecked(false); } // remove check on 2nd click
                    displayList.get(0).completed = checkTask1.isChecked();
                    accessor.save(getApplicationContext());
                }
                displayDataFromSave();
            }
        });
        RadioButton checkTask2 = (RadioButton) findViewById(R.id.checkTask2);
        checkTask2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_S4U_Data_Accessor accessor = new Activity_S4U_Data_Accessor(
                        getApplicationContext(),true);
                List<Activity_S4U> displayList = accessor.lists.active;
                if (displayList.size()>1) {
                    if(checkTask2.isChecked() && displayList.get(1).completed) {
                        checkTask2.setChecked(false); } // remove check on 2nd click
                    displayList.get(1).completed = checkTask2.isChecked();
                    accessor.save(getApplicationContext());
                }
                displayDataFromSave();
            }
        });
        RadioButton checkTask3 = (RadioButton) findViewById(R.id.checkTask3);
        checkTask3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_S4U_Data_Accessor accessor = new Activity_S4U_Data_Accessor(
                        getApplicationContext(),true);
                List<Activity_S4U> displayList = accessor.lists.active;
                if (displayList.size()>2) {
                    if(checkTask3.isChecked() && displayList.get(2).completed) {
                        checkTask3.setChecked(false); } // remove check on 2nd click
                    displayList.get(2).completed = checkTask3.isChecked();
                    // System.out.println("displayList.get(2).completed is "+displayList.get(2).completed+"in ToDos.java::checkTask3 onClick");
                    accessor.save(getApplicationContext());
                }
                displayDataFromSave();
            }
        });
    }

    protected void displayDataFromSave() {
        // Starting code for transfering data across activities and displaying it =-----------------
        Activity_S4U_Data_Accessor accessor = new Activity_S4U_Data_Accessor(
                getApplicationContext(),true);
        List<Activity_S4U> displayList = accessor.lists.active;

        // will display first 3 values of displayList
        int displayCount = 0;
        if (displayList.size()>displayCount) {
            TextView textView44 = (TextView) findViewById(R.id.textView44);
            textView44.setText(displayList.get(displayCount).name);

            //get and display time
            String startString = displayList.get(displayCount).start_time.toString();
            String endString = displayList.get(displayCount).end_time.toString();
            // last 3 characters are seconds so dont display
            String timeString = "Time: " + startString.substring(0, startString.length()-3)
                    + " - " + endString.substring(0,endString.length()-3);
            TextView textView45 = (TextView) findViewById(R.id.textView45);
            textView45.setText(timeString);

            // set priority
            TextView textView47 = (TextView) findViewById(R.id.textView47);
            textView47.setText("Priority: "+displayList.get(displayCount).importance);

            RadioButton checkTask1 = (RadioButton) findViewById(R.id.checkTask1);
            checkTask1.setChecked(displayList.get(displayCount).completed);

        }
        if (displayList.size()>1) {
            displayCount = 1;
            TextView titletobeedited = (TextView) findViewById(R.id.titletobeedited);
            titletobeedited.setText(displayList.get(displayCount).name);

            //get and display time
            String startString = displayList.get(displayCount).start_time_string;
            String endString = displayList.get(displayCount).end_time_string;
            // last 3 characters are seconds so dont display
            //String timeString = startString.substring(0, startString.length()-3)
             //       + " - " + endString.substring(0,endString.length()-3);
            String timeString = startString + " - " + endString;
            TextView timetobeedited = (TextView) findViewById(R.id.timetobeedited);
            timetobeedited.setText(timeString);

            // set priority
            TextView prioritytobechanged = (TextView) findViewById(R.id.prioritytobechanged);
            prioritytobechanged.setText(""+displayList.get(displayCount).importance_string);

            RadioButton checkTask2 = (RadioButton) findViewById(R.id.checkTask2);
            checkTask2.setChecked(displayList.get(displayCount).completed);
        }
        if (displayList.size()>2) {
            displayCount = 2;
            TextView eventtitletobeadded = (TextView) findViewById(R.id.eventtitletobeadded);
            eventtitletobeadded.setText(displayList.get(displayCount).name);

            //get and display time
            //String startString = displayList.get(displayCount).start_time.toString();
            //String endString = displayList.get(displayCount).end_time.toString();
            String startString = displayList.get(displayCount).start_time_string;
            String endString = displayList.get(displayCount).end_time_string;
            // last 3 characters are seconds so dont display
            //String timeString = startString.substring(0, startString.length()-3)
            //        + " - " + endString.substring(0,endString.length()-3);
            String timeString = startString + " - " + endString;
            TextView timetobeadded = (TextView) findViewById(R.id.timetobeadded);
            timetobeadded.setText(timeString);

            // set priority
            TextView prioritytobeadded = (TextView) findViewById(R.id.prioritytobeadded);
            //prioritytobeadded.setText(""+displayList.get(displayCount).importance);
            prioritytobeadded.setText(""+displayList.get(displayCount).importance_string);

            RadioButton checkTask3 = (RadioButton) findViewById(R.id.checkTask3);
            checkTask3.setChecked(displayList.get(displayCount).completed);
        } else {
            TextView eventtitletobeadded = (TextView) findViewById(R.id.eventtitletobeadded);
            eventtitletobeadded.setText(" ");
            TextView timetobeadded = (TextView) findViewById(R.id.timetobeadded);
            timetobeadded.setText(" ");
            TextView prioritytobeadded = (TextView) findViewById(R.id.prioritytobeadded);
            prioritytobeadded.setText(" ");
            RadioButton checkTask3 = (RadioButton) findViewById(R.id.checkTask3);
            checkTask3.setChecked(false);

        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        displayDataFromSave();
    }
}
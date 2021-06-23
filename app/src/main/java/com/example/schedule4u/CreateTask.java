package com.example.schedule4u;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Time;

public class CreateTask extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createtask);

        ImageButton homebutton_create= (ImageButton) findViewById(R.id.homebutton3);
        homebutton_create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        ////////////



        Button addtask=(Button)findViewById(R.id.createNewTaskSubmit);
        EditText nameoftask=(EditText)findViewById(R.id.addTask);
        EditText timeoftask=(EditText)findViewById(R.id.startTime);
        EditText levelofimportance=(EditText)findViewById(R.id.levelofimportance);
        EditText location=(EditText)findViewById(R.id.extraDetails);
        EditText startTime = (EditText)findViewById(R.id.startTime);
        EditText endTime = (EditText)findViewById(R.id.endTime);

        addtask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Activity_S4U CreatedActivity = new Activity_S4U();
                    Activity_S4U_Data_Accessor accessor = new Activity_S4U_Data_Accessor(getApplicationContext(), true);

                    String taskname = nameoftask.getText().toString();
                    String tasktime = timeoftask.getText().toString();
                    String importancelevel = levelofimportance.getText().toString();
                    String tasklocation = location.getText().toString();
                    Intent intent = new Intent(getApplicationContext(), ToDos.class);
                    intent.putExtra("taskname", taskname);
                    intent.putExtra("tasktime", tasktime);
                    intent.putExtra("importancelevel", importancelevel);
                    intent.putExtra("tasklocation", tasklocation);
                    startActivity(intent);

                    CreatedActivity.name = taskname;
                    //CreatedActivity.time_alotted = Integer.parseInt(tasktime);
                    //CreatedActivity.importance = Integer.parseInt(importancelevel); These four lines lines cause error
                    //CreatedActivity.start_time = Time.valueOf(startTime.getText().toString());
                    //CreatedActivity.end_time = Time.valueOf(endTime.getText().toString());
                    CreatedActivity.start_time_string = startTime.getText().toString();
                    CreatedActivity.end_time_string = endTime.getText().toString();
                    CreatedActivity.importance_string = importancelevel;

                    // add created activity to data store and save
                    //accessor.lists.active.add(CreatedActivity); added above
                    accessor.lists.active.add(CreatedActivity);
                    accessor.save(getApplicationContext());
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e);
                    System.out.println("Invalid input on create task Activity");
                }

            }
        });

















        ///////////

//        Button submitNewTask = (Button) findViewById(R.id.createNewTaskSubmit);
//        submitNewTask.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                EditText taskName = (EditText)findViewById(R.id.addTask); //this line grabs the form input
//                String task = taskName.getText().toString(); //this line casts it to a string
//                EditText taskTime = (EditText)findViewById(R.id.timeForTask); //this line grabs the form input
//                String time = taskTime.getText().toString(); //this line casts it to a string
//                EditText taskDateBy = (EditText)findViewById(R.id.completeDay); //this line grabs the form input
//                String dateBy = taskDateBy.getText().toString(); //this line casts it to a string
//                RadioGroup importanceLevel = (RadioGroup)findViewById(R.id.importanceLevel);
//                int level = importanceLevel.getCheckedRadioButtonId();
//                String levelVal = Integer.valueOf(level).toString(); //convert the value of importance to a string val
//                EditText taskStartTime = (EditText)findViewById(R.id.startTime); //this line grabs the form input
//                String start = taskStartTime.getText().toString(); //this line casts it to a string
//                EditText taskEndTime = (EditText)findViewById(R.id.endTime); //this line grabs the form input
//                String end = taskEndTime.getText().toString(); //this line casts it to a string
//                EditText taskExtraDetails = (EditText)findViewById(R.id.extraDetails); //this line grabs the form input
//                String extraDetails = taskExtraDetails.getText().toString(); //this line casts it to a string
//                EditText taskDaysNum = (EditText)findViewById(R.id.taskDays); //this line grabs the form input
//                String daysNum = taskDaysNum.getText().toString(); //this line casts it to a string
//                Intent myIntent = new Intent(view.getContext(), ToDos.class);
//
//                // THIS IS A TEST TO SEE IF DATA IS SENT TO DIFFERENT ACTIVITIES
//                myIntent.putExtra("event", task);
//                startActivityForResult(myIntent, 0);
//            }
//
//        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        Activity_S4U currentTask = new Activity_S4U();
        String start = currentTask.start_time_string;
        String end = currentTask.end_time_string;
        if (start.length()>6) {
            start = currentTask.start_time_string.substring(0,currentTask.start_time_string.length()-3);
        }
        if (end.length()>6) {
            end = currentTask.end_time_string.substring(0,currentTask.end_time_string.length()-3);
        }
        TextView startTime = (TextView) findViewById(R.id.startTime);
        startTime.setText(start);
        TextView endTime = (TextView) findViewById(R.id.endTime);
        endTime.setText(end);

    }

}

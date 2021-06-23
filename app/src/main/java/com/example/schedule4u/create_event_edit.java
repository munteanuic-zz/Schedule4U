package com.example.schedule4u;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class create_event_edit extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createventedit);

        ImageButton homebutton_create= (ImageButton) findViewById(R.id.HOMEB3);
        homebutton_create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        ////////////

        Button edittask=(Button)findViewById(R.id.Editeventsubmit);
        edittask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Button edittask=(Button)findViewById(R.id.Editeventsubmit);
                EditText tasknameinput=(EditText)findViewById(R.id.AddTask);
                EditText timeinput=(EditText)findViewById(R.id.startTIME);
                EditText importanceinput=(EditText)findViewById(R.id.Levelofimportance);
                EditText locationinput=(EditText)findViewById(R.id.moreDetails);
                String taskname_1 = tasknameinput.getText().toString();
                String tasktime_1 = timeinput.getText().toString();
                String importancelevel_1= importanceinput.getText().toString();
                String tasklocation_1= locationinput.getText().toString();
                Intent intent = new Intent(getApplicationContext(), ToDos.class);
                intent.putExtra("taskNM", taskname_1);
                intent.putExtra("taskTM", tasktime_1);
                intent.putExtra("importanceLv", importancelevel_1);
                intent.putExtra("taskLc", tasklocation_1);
                startActivity(intent);
            }
        });

//        Button addtask=(Button)findViewById(R.id.CreateNewTaskSubmit);
//        EditText nameoftask=(EditText)findViewById(R.id.AddTask);
//        EditText timeoftask=(EditText)findViewById(R.id.startTIME);
//        EditText levelofimportance=(EditText)findViewById(R.id.Levelofimportance);
//        EditText location=(EditText)findViewById(R.id.moreDetails);
//        addtask.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                String taskname = nameoftask.getText().toString();
//                String tasktime = timeoftask.getText().toString();
//                String importancelevel= levelofimportance.getText().toString();
//                String tasklocation= location.getText().toString();
//                Intent intent = new Intent(getApplicationContext(), ToDos.class);
//                intent.putExtra("taskname", taskname);
//                intent.putExtra("tasktime", tasktime);
//                intent.putExtra("importancelevel", importancelevel);
//                intent.putExtra("tasklocation", tasklocation);
//                startActivity(intent);
//            }
//        });

        Button addtask=(Button)findViewById(R.id.Editeventsubmit);
        EditText nameoftask=(EditText)findViewById(R.id.AddTask);
        EditText timeoftask=(EditText)findViewById(R.id.TimeForTask);
        EditText levelofimportance=(EditText)findViewById(R.id.Levelofimportance);
        EditText location=(EditText)findViewById(R.id.moreDetails);
        EditText startTime = (EditText)findViewById(R.id.startTIME);
        EditText endTime = (EditText)findViewById(R.id.EndTime);
        addtask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Activity_S4U CreatedActivity = new Activity_S4U();
                    Activity_S4U_Data_Accessor accessor = new Activity_S4U_Data_Accessor(getApplicationContext(), true);
                    if (accessor.lists.active.size()>1) {
                        CreatedActivity = accessor.lists.active.get(1);
                    }

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

                    // save
                    accessor.save(getApplicationContext());
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e);
                    System.out.println("Invalid input on create task Activity");
                }

            }

        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        Activity_S4U_Data_Accessor accessor = new Activity_S4U_Data_Accessor(
                getApplicationContext(),true);
        Activity_S4U currentTask = accessor.lists.active.get(accessor.lists.edit_task_index);
        //currentTask = accessor.lists.active.get(1); // hacky fix because passing through edit_task_index didnt work for some reason Note: fixed this
        // System.out.println("Edit task index is " + accessor.edit_task_index + " and currentTask.name is" + currentTask.name + " in OnResume() create_event_edit.java"); // for debugging above issue

        TextView AddTask = (TextView) findViewById(R.id.AddTask);
        AddTask.setText(currentTask.name);

        TextView startTIME = (TextView) findViewById(R.id.startTIME);
        startTIME.setText(currentTask.start_time_string);
        TextView EndTime = (TextView) findViewById(R.id.EndTime);
        EndTime.setText(currentTask.end_time_string);

        TextView Levelofimportance = (TextView) findViewById(R.id.Levelofimportance);
        Levelofimportance.setText(currentTask.importance_string);

    }

}

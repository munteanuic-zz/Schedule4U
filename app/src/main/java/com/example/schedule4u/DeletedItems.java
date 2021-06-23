
package com.example.schedule4u;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class DeletedItems extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleted_items);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Activity_S4U_Data_Accessor accessor = new Activity_S4U_Data_Accessor(
                getApplicationContext(), true);
        List<Activity_S4U> displayList = accessor.lists.deleted;

        if (displayList.size()>0) {
            TextView textView56 = (TextView) findViewById(R.id.textView56);
            TextView textView23 = (TextView) findViewById(R.id.textView23);
            textView56.setText(displayList.get(displayList.size()-1).name);
            textView23.setText(displayList.get(displayList.size()-1).details);

        }

//        Intent intent = getIntent();
//        String Name = intent.getStringExtra("deletedItem");
//        System.out.print("printing message");
//        System.out.print(Name);
//        TextView textView56 = (TextView) findViewById(R.id.textView56);
//        textView56.setText(Name);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        //Be careful! This is code for image button not ordinarily button//
        ImageButton homebutton_2= (ImageButton) findViewById(R.id.homebutton2);
        homebutton_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        //Be careful! This is code for image button not ordinarily button//

        // re-add third task
        Button undoDelete = (Button) findViewById(R.id.button6);
        undoDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                    Activity_S4U CreatedActivity = new Activity_S4U();
                    Activity_S4U_Data_Accessor accessor = new Activity_S4U_Data_Accessor(getApplicationContext(), true);
                    List<Activity_S4U> activeList = accessor.lists.active;
                    TextView textView56 = (TextView) findViewById(R.id.textView56);
                    TextView textView23 = (TextView) findViewById(R.id.textView23);

                    textView56.setText("no deleted items");
                    textView23.setText("");
                    activeList.add(displayList.get(displayList.size()-1));
                    displayList.remove(2);

                    // save
                    accessor.save(getApplicationContext());

            }
        });

    }

    protected void displayDataFromSave() {
        // Starting code for transfering data across activities and displaying it =-----------------
        Activity_S4U_Data_Accessor accessor = new Activity_S4U_Data_Accessor(
                getApplicationContext(), true);
        List<Activity_S4U> displayList = accessor.lists.deleted;

        if (displayList.size()>0) {
            TextView textView56 = (TextView) findViewById(R.id.textView56);
            textView56.setText(displayList.get(0).name);
        }

    }

}
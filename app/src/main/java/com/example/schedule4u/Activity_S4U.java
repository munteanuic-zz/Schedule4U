package com.example.schedule4u;

import java.sql.Time;
import java.util.Date;
import java.io.Serializable;
public class Activity_S4U implements java.io.Serializable {
    // used Create Task page for reference
    public String name;
    public int time_alotted; // minutes
    public Date complete_task_by;
    public int importance;
    public Time start_time;
    public Time end_time;
    public String details;
    public int splitTask;
    public boolean completed;
    public String start_time_string;
    public String end_time_string;
    public String importance_string;

    // for now we just have a 0 argument constructor filled with dummy values
    public Activity_S4U() {
        this.name = "Name placeholder";
        this.time_alotted = 60;
        this.complete_task_by = new Date(System.currentTimeMillis());
        this.importance = 2;
        this.start_time = new Time(System.currentTimeMillis()+1000*60*60*1);
        this.end_time = new Time(System.currentTimeMillis()+1000*60*60*2);
        this.details = "Details placeholder";
        this.splitTask = 1;
        this.completed = false;
        start_time_string = start_time.toString().substring(0,start_time.toString().length()-3);
        end_time_string = end_time.toString().substring(0,end_time.toString().length()-3);
        importance_string = Integer.toString(importance);
    }

    public Activity_S4U(String placeholder, int time, Date completeBy, int importance, Time start, Time end, String extra, int split) {
        this.name = "Name placeholder";
        this.time_alotted = 60;
        this.complete_task_by = new Date(System.currentTimeMillis()+1000*60*60*24*7);
        this.importance = 2;
        this.start_time = new Time(System.currentTimeMillis()+1000*60*60*24*6);
        this.end_time = new Time(System.currentTimeMillis()+1000*60*60*24*7);
        this.details = "Details placeholder";
        this.splitTask = 1;
        this.completed = false;
        start_time_string = start_time.toString().substring(0,start_time.toString().length()-3);
        end_time_string = end_time.toString().substring(0,end_time.toString().length()-3);
        importance_string = Integer.toString(importance);
    }

    /*public static void main(String[] args) {
        Activity_S4U test_activity = new Activity_S4U();
        System.out.println(test_activity.time_alotted);
    }*/
}
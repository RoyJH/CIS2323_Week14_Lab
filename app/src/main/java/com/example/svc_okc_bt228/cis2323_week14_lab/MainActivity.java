package com.example.svc_okc_bt228.cis2323_week14_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper db = new dbHelper(context this);
        ListView lstTask = findViewById(R.id.lstTask);

        ArrayList<String> taskList = db.getTaskList();
        ArrayAdapter<String> mArrayAdaptor = new ArrayAdapter<String>(this, R.layout.row, R.id.task_title, taskList);
    }
}

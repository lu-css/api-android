package com.example.everyday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.models.History;
import com.example.storage.DatabaseHelper;

public class history extends AppCompatActivity {

    DatabaseHelper db;
    TextView txtFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);

        txtFrom = findViewById(R.id.txt_from);
        db = new DatabaseHelper(this);

        loadLastHistory();

    }

    private void loadLastHistory(){
        History h = db.getLastHistory();

        txtFrom.setText(h.moneyFrom);
    }
}
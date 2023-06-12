package com.example.everyday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


import com.example.models.History;
import com.example.storage.DatabaseHelper;

public class history extends AppCompatActivity {

    DatabaseHelper db;
    TextView txtFrom;

    ArrayList<History> journals = new ArrayList<>();
    ArrayAdapter<History> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);

        journals = new ArrayList<>();
        adapter = new ArrayAdapter<History>(this, R.layout.list_item_journal, journals) {
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_journal, parent, false);
            }

            History journal = getItem(position);

            TextView textName = convertView.findViewById(R.id.textName);
            TextView textDescription = convertView.findViewById(R.id.textDescription);

            textName.setText(journal.moneyFrom);
            textDescription.setText(journal.moneyTo);

            return convertView;
        }
    };

    ListView listView = findViewById(R.id.listView);
    listView.setAdapter(adapter);


        // txtFrom = findViewById(R.id.txt_from);
        db = new DatabaseHelper(this);

        loadLastHistory();

    }

  private void addJournal(String name, String description) {
    History journal = new History(0, name, description);
    journals.add(journal);
    adapter.notifyDataSetChanged();
  }


    private void loadLastHistory(){
        ArrayList<History> histories = db.getAllHistoryItens();

        for (int i = 0; i < histories.size(); i++){
          History h = histories.get(i);

          this.addJournal(h.moneyFrom, h.moneyTo);
        }
    }

    public void goBackActivity(View v){
        // addJournal("TA,", "FUNCIONANDO");
      
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

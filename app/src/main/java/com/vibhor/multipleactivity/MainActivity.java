package com.vibhor.multipleactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> myFriends;
    ArrayAdapter<String> userAdapter;
    Intent intent;

    public void jumptoMain2Activity(View view){


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(getApplicationContext(), Main2Activity.class);

        ListView listView = (ListView) findViewById(R.id.listViewTable);
        myFriends = new ArrayList<>(asList("Manjula", "Mayank", "VidyaSagar", "Vibhor"));
        userAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);

        listView.setAdapter(userAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String userName = myFriends.get(position);
                Log.i("userName :", userName);
                //Toast.makeText(MainActivity.this, "Hello " + myFriends.get(position), Toast.LENGTH_SHORT).show();
                intent.putExtra("Username", userName);
                startActivity(intent);
            }
        });

    }
}

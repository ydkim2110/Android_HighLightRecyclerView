package com.example.anti2110.highlightrecyclerview;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.anti2110.highlightrecyclerview.Adapter.CustomAdapter;
import com.example.anti2110.highlightrecyclerview.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Item> items = new ArrayList<>();
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NewActivity.class));
            }
        });


        //
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
    }

    private void getData() {
        // Generate data
        for(int i=0; i<10; i++) {
            Item item = new Item();
            item.setName("Item " + i);
            if(i%2 == 0) {
                item.setChecked(true);
            } else {
                item.setChecked(false);
            }
            items.add(item);
        }

        // Create Adapter
        CustomAdapter adapter = new CustomAdapter(items, this);
        recyclerView.setAdapter(adapter);
    }
}

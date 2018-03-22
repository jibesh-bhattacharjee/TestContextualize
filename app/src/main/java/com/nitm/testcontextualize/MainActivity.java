package com.nitm.testcontextualize;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView personsTextView;
    private TextView placesTextView;
    private TextView thingsTextView;
    //TextView displayTextView;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Article> articleItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_linear);

        personsTextView = (TextView) findViewById(R.id.personsTextView);
        placesTextView = (TextView) findViewById(R.id.placesTextView);
        thingsTextView = (TextView) findViewById(R.id.thingsTextView);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        articleItems = new ArrayList<>();

        for(int i=0;i<10;i++){
            Article a = new Article(i+"", "Description is"+i);
            articleItems.add(a);
        }

        adapter = new ArticleAdapter(articleItems, this);

        recyclerView.setAdapter(adapter);

        /*
        personsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //displayTextView = (TextView) findViewById(R.id.displayTextView);
                //displayTextView.setText("Displaying Persons");
            }
        });

        placesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //displayTextView = (TextView) findViewById(R.id.displayTextView);
                //displayTextView.setText("Displaying Places");
            }
        });

        thingsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //displayTextView = (TextView) findViewById(R.id.displayTextView);
                //displayTextView.setText("Displaying Things");
            }
        });
        */
    }

    public void nextActivity(View view){
        Intent intent = new Intent(this, ArticleActivity.class);
        startActivity(intent);
    }
}

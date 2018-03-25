package com.nitm.testcontextualize;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_linear);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Persons");
        mDatabase.keepSynced(true);

        personsTextView = (TextView) findViewById(R.id.personsTextView);
        placesTextView = (TextView) findViewById(R.id.placesTextView);
        thingsTextView = (TextView) findViewById(R.id.thingsTextView);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        /**
         * Static Adapter
         */
        /*
        articleItems = new ArrayList<>();

        for(int i=0;i<10;i++){
            Article a = new Article(i+"", "Description is"+i);
            articleItems.add(a);
        }

        adapter = new ArticleAdapter(articleItems, this);

        recyclerView.setAdapter(adapter);
        */
        /**
         * Static Adapter --END
         */


        personsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase = FirebaseDatabase.getInstance().getReference().child("Persons");
                FirebaseRecyclerAdapter<Article, ArticleViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Article, ArticleViewHolder>
                        (Article.class, R.layout.list_item, ArticleViewHolder.class, mDatabase) {
                    @Override
                    protected void populateViewHolder(ArticleViewHolder viewHolder, Article model, int position) {
                        viewHolder.setHeading(model.getHeading());
                        viewHolder.setDescription(model.getDescription());
                    }
                };

                recyclerView.setAdapter(firebaseRecyclerAdapter);
                //displayTextView = (TextView) findViewById(R.id.displayTextView);
                //displayTextView.setText("Displaying Persons");
            }
        });

        placesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase = FirebaseDatabase.getInstance().getReference().child("Places");
                FirebaseRecyclerAdapter<Article, ArticleViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Article, ArticleViewHolder>
                        (Article.class, R.layout.list_item, ArticleViewHolder.class, mDatabase) {
                    @Override
                    protected void populateViewHolder(ArticleViewHolder viewHolder, Article model, int position) {
                        viewHolder.setHeading(model.getHeading());
                        viewHolder.setDescription(model.getDescription());
                    }
                };

                recyclerView.setAdapter(firebaseRecyclerAdapter);
                //displayTextView = (TextView) findViewById(R.id.displayTextView);
                //displayTextView.setText("Displaying Places");
            }
        });

        thingsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase = FirebaseDatabase.getInstance().getReference().child("Things");
                FirebaseRecyclerAdapter<Article, ArticleViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Article, ArticleViewHolder>
                        (Article.class, R.layout.list_item, ArticleViewHolder.class, mDatabase) {
                    @Override
                    protected void populateViewHolder(ArticleViewHolder viewHolder, Article model, int position) {
                        viewHolder.setHeading(model.getHeading());
                        viewHolder.setDescription(model.getDescription());
                    }
                };

                recyclerView.setAdapter(firebaseRecyclerAdapter);
                //displayTextView = (TextView) findViewById(R.id.displayTextView);
                //displayTextView.setText("Displaying Things");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Article, ArticleViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Article, ArticleViewHolder>
                (Article.class, R.layout.list_item, ArticleViewHolder.class, mDatabase) {
            @Override
            protected void populateViewHolder(ArticleViewHolder viewHolder, Article model, int position) {
                viewHolder.setHeading(model.getHeading());
                viewHolder.setDescription(model.getDescription());
            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public ArticleViewHolder(View itemView){
            super(itemView);
            mView = itemView;
        }

        public void setHeading(String s){
            TextView cardHead = (TextView) mView.findViewById(R.id.cardHeading);
            cardHead.setText(s);
        }

        public void setDescription(String s){
            TextView cardDesc = (TextView) mView.findViewById(R.id.cardDescription);
            cardDesc.setText(s);
        }
    }

    public void nextActivity(View view){
        Intent intent = new Intent(this, ArticleActivity.class);
        startActivity(intent);
    }
}

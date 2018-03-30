package com.nitm.testcontextualize;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


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

                        final String head = model.getHeading();
                        final String desc = model.getDescription();

                        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "You clicked a View", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MainActivity.this, ArticleDetailsActivity.class);
                                intent.putExtra("Heading", head);
                                intent.putExtra("Description", desc);
                                startActivity(intent);
                            }
                        });
                    }

                };

                recyclerView.setAdapter(firebaseRecyclerAdapter);

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

                        final String head = model.getHeading();
                        final String desc = model.getDescription();

                        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "You clicked a View", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MainActivity.this, ArticleDetailsActivity.class);
                                intent.putExtra("Heading", head);
                                intent.putExtra("Description", desc);
                                startActivity(intent);
                            }
                        });
                    }
                };

                recyclerView.setAdapter(firebaseRecyclerAdapter);

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

                        final String head = model.getHeading();
                        final String desc = model.getDescription();

                        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "You clicked a View", Toast.LENGTH_LONG).show();

                                Intent intent = new Intent(MainActivity.this, ArticleDetailsActivity.class);
                                intent.putExtra("Heading", head);
                                intent.putExtra("Description", desc);
                                startActivity(intent);
                            }
                        });
                    }
                };

                recyclerView.setAdapter(firebaseRecyclerAdapter);

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

                final String head = model.getHeading();
                final String desc = model.getDescription();

                //viewHolder.itemView.setOnClickListener();
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "You clicked a View", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, ArticleDetailsActivity.class);
                        intent.putExtra("Heading", head);
                        intent.putExtra("Description", desc);
                        startActivity(intent);
                    }
                });
            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public LinearLayout listItemLinearLayout;


        public ArticleViewHolder(View itemView){
            super(itemView);
            mView = itemView;
            listItemLinearLayout = (LinearLayout) itemView.findViewById(R.id.listItemLinearLayout);
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

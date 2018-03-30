package com.nitm.testcontextualize;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ArticleDetailsActivity extends AppCompatActivity {

    private TextView head;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_article_details);

        head = (TextView) findViewById(R.id.headTextView);
        desc = (TextView) findViewById(R.id.descTextView);

        Intent intent = getIntent();
        head.setText(intent.getStringExtra("Heading"));
        desc.setText(intent.getStringExtra("Description"));
    }
}

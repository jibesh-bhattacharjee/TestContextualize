package com.nitm.testcontextualize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ArticleActivity extends AppCompatActivity {

    private Spinner tagsSpinner;
    private EditText headingEditText;
    private EditText descriptionEditText;
    private Button publishButton;
    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_new_article);

        tagsSpinner = (Spinner) findViewById(R.id.tagsSpinner);
        headingEditText = (EditText) findViewById(R.id.headingEditText);
        descriptionEditText = (EditText) findViewById(R.id.descriptionEditText);
        publishButton = (Button) findViewById(R.id.publishButton);
        //CONNECTING ALL WIDGETS --DONE
        publishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heading = headingEditText.getText().toString().trim();
                String description = descriptionEditText.getText().toString().trim();
                String tag = tagsSpinner.getSelectedItem().toString();
                mDatabaseReference = FirebaseDatabase.getInstance().getReference().child(tag);

                Article article = new Article(tag, heading, description);
                mDatabaseReference.push().setValue(article);
            }
        });
    }
}

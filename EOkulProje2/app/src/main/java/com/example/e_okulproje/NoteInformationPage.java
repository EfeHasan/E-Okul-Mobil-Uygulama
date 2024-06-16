package com.example.e_okulproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NoteInformationPage extends AppCompatActivity {
    TextView nameLabel, numLabel;
    ListView listView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_note_information_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nameLabel = (TextView) findViewById(R.id.nameLabel1);
        numLabel = (TextView) findViewById(R.id.numberLabel1);

        listView = findViewById(R.id.noteInformationListView);

        nameLabel.setText(MainActivity.studentName);
        numLabel.setText(MainActivity.studentClass + " " + MainActivity.studentNum);


    }

    public void backClick(View v)
    {
        intent = new Intent(NoteInformationPage.this, StudentInformationPage.class);
        startActivity(intent);
    }

    public void homeClick(View v)
    {
        intent = new Intent(NoteInformationPage.this, MainActivity.class);
        startActivity(intent);
    }
}
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

public class YearNotesPage extends AppCompatActivity {
    Intent intent;
    ListView listView;
    TextView nameLabel, numberLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_year_notes_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nameLabel = findViewById(R.id.nameLabel6);
        numberLabel = findViewById(R.id.numberLabel6);

        listView = findViewById(R.id.yearNotesListView);

        nameLabel.setText(MainActivity.studentName);
        numberLabel.setText(MainActivity.studentClass + " " + MainActivity.studentNum);

    }

    public void backClick(View v)
    {
        intent = new Intent(YearNotesPage.this, StudentInformationPage.class);
        startActivity(intent);
    }

    public void homeClick(View v)
    {
        intent = new Intent(YearNotesPage.this, MainActivity.class);
        startActivity(intent);
    }
}
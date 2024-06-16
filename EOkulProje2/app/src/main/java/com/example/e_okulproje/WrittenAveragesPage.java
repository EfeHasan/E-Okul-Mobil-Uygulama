package com.example.e_okulproje;

import android.annotation.SuppressLint;
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

public class WrittenAveragesPage extends AppCompatActivity {
    Intent intent;
    ListView listView;
    TextView nameLabel, numberLabel;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_written_averages_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nameLabel = findViewById(R.id.nameLabel5);
        numberLabel= findViewById(R.id.numberLabel5);

        listView = findViewById(R.id.writtenAveragesListView);

        nameLabel.setText(MainActivity.studentName);
        numberLabel.setText(MainActivity.studentClass + " " + MainActivity.studentNum);

    }

    public void backClick(View v)
    {
        intent = new Intent(WrittenAveragesPage.this, StudentInformationPage.class);
        startActivity(intent);
    }

    public void homeClick(View v)
    {
        intent = new Intent(WrittenAveragesPage.this, MainActivity.class);
        startActivity(intent);
    }
}
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

public class AbsenceInformationPage extends AppCompatActivity {

    TextView nameLabel, numberLabel;
    ListView listView;
    Intent intent;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_absence_information_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nameLabel = (TextView) findViewById(R.id.nameLabel2);
        numberLabel = (TextView) findViewById(R.id.numberLabel2);

        listView = findViewById(R.id.absenceInformationListView);

        nameLabel.setText(MainActivity.studentName);
        numberLabel.setText(MainActivity.studentClass + " " + MainActivity.studentNum);

    }
    public void backClick(View v)
    {
        intent = new Intent(AbsenceInformationPage.this, StudentInformationPage.class);
        startActivity(intent);
    }

    public void homeClick(View v)
    {
        intent = new Intent(AbsenceInformationPage.this, MainActivity.class);
        startActivity(intent);
    }
}
package com.example.e_okulproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;

public class StudentInformationPage extends AppCompatActivity {

    ListView listButton;
    cardAdapter adapter;
    TextView numLabel, nameLabel;
    String[] cardName = {"Ders Devamsızlıkları", "Nakil Bilgileri", "Sorumluluk Bilgileri", "Aldığı Belgeler"};
    String studentName;
    String studentInfo;
    int[] cardImages = {R.drawable.d, R.drawable.n, R.drawable.s, R.drawable.b};
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_information_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        studentName = MainActivity.studentName + " " + MainActivity.studentSurname;
        studentInfo = MainActivity.studentNum + " " + MainActivity.studentClass;

        listButton = (ListView) findViewById(R.id.ListView1);
        numLabel = (TextView) findViewById(R.id.numLabel);
        nameLabel = (TextView) findViewById(R.id.nameLabel);

        adapter = new cardAdapter(cardName, cardImages, this);

        listButton.setAdapter(adapter);



        numLabel.setText(studentInfo);
        nameLabel.setText(studentName);

    }

    public void backMenu(View v) {
        intent = new Intent(StudentInformationPage.this, MainActivity.class);
        startActivity(intent);
    }

    public void loginPanel(View view) {
        startActivity(login(view));


    }

    private Intent login(View v) {
        Intent intent_ = null;

        if (v.getId() == R.id.noteInformationBtn)
            intent_ = new Intent(StudentInformationPage.this, NoteInformationPage.class);

        if (v.getId() == R.id.absenceInformationBtn)
            intent_ = new Intent(StudentInformationPage.this, AbsenceInformationPage.class);


        if (v.getId() == R.id.courseProgramBtn)
            intent_ = new Intent(StudentInformationPage.this, CourseProgramPage.class);


        if (v.getId() == R.id.examDatesBtn)
            intent_ = new Intent(StudentInformationPage.this, ExamDatesPage.class);


        if (v.getId() == R.id.writtenAveragesBtn)
            intent_ = new Intent(StudentInformationPage.this, WrittenAveragesPage.class);


        if (v.getId() == R.id.yearNotesBtn)
            intent_ = new Intent(StudentInformationPage.this, YearNotesPage.class);

        return intent_;
    }

}
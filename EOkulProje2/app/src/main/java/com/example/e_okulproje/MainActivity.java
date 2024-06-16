package com.example.e_okulproje;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button addStudentButton;
    Intent intent;
    ListView studentListView;
    static SqlCommands commands;
    ArrayList<LoadPage> students;
    String[] studentsArray;
    public static String studentName;
    public static  String studentSurname;
    public static String studentClass;
    public static String studentNum;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        addStudentButton = (Button) findViewById(R.id.addStudent);
        studentListView = (ListView) findViewById(R.id.studentListView);
        commands = new SqlCommands();

        commands.openDatabase(this, "Students");
        commands.createTable("LoginTable", "studentName", "studentSurname", "studentNum", "studentClass");


        students = commands.tableReadLoadPage("LoginTable");

        if(students.size() > 0)
        {
            translateArray();
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentsArray);
            studentListView.setAdapter(adapter);

            studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    studentName = students.get(position).getStudentName();
                    studentSurname = students.get(position).getStudentSurname();
                    studentNum = students.get(position).getStudentNum();
                    studentClass = students.get(position).getStudentClass();


                    intent = new Intent(MainActivity.this, StudentInformationPage.class);
                    startActivity(intent);
                }
            });
            studentListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    commands.deleteStudent("LoginTable", students.get(position).getStudentName(), students.get(position).getStudentNum());
                    students.remove(position);

                    translateArray();
                    adapter =  new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, studentsArray);

                    Toast.makeText(getApplicationContext(), "Başarıyla Silinmiştir", Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void translateArray()
    {
        studentsArray = new String[students.size()];
        for(int i = 0; i < studentsArray.length; i++)
        {
            studentsArray[i] = students.get(i).getStudentName() + " " + students.get(i).getStudentSurname();
        }
    }

    public void addStudentOnClick(View v)
    {
        intent = new Intent(MainActivity.this, AddStudent.class);
        startActivity(intent);
    }
}
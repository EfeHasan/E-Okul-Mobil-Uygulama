package com.example.e_okulproje;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddStudent extends AppCompatActivity {
    Intent intent;
    EditText tcNumberBox, cardTextBox, schoolNumberBox, brithDayBox;
    Button addBtn;
    String tcNumber, cardNumber, schoolNumber, brithDay;
    Random random;
    SqlCommands commands;

    String[] studentNames = {
            "Ahmet", "Mehmet", "Ayşe", "Fatma", "Mustafa", "Ali", "Emine", "Hatice", "Hüseyin", "Özlem",
            "İbrahim", "Zeynep", "Murat", "Gülsüm", "Yusuf", "Elif", "Serkan", "Selin", "Tolga", "Derya",
            "Can", "Aslı", "Kemal", "Derya", "Ömer", "Esra", "Süleyman", "Meltem", "Fatih", "Seda",
            "Osman", "Yasemin", "Cem", "Ebru", "Gökhan", "İrem", "Erdem", "Nilüfer", "Mert", "Nur",
            "Barış", "Sevgi", "Ercan", "Deniz", "Furkan", "Büşra", "İsmail", "Aysun", "Umut", "Ceren"
    };

    String[] studentSurnames = {
            "Yılmaz", "Kaya", "Demir", "Çelik", "Kılıç", "Öztürk", "Arslan", "Koç", "Kurt", "Kaya",
            "Şahin", "Demirci", "Özdemir", "Doğan", "Kara", "Erdoğan", "Keskin", "Çetin", "Kocaoğlu", "Güneş",
            "Tekin", "Aslan", "Ay", "Yıldırım", "Karadağ", "Kaplan", "Özkan", "Sarı", "Turan", "Öz",
            "Cengiz", "Polat", "Kurtuluş", "Şimşek", "Güler", "Can", "Öztürk", "Karabulut", "Güzel", "Yıldız",
            "Taş", "Aydın", "Aksoy", "Ateş", "Çalışkan", "Aktaş", "Kılıç", "Duman", "Bulut", "Keser"
    };

    String[] studentClass = {
            "9/A", "9/B", "9/C", "9/D", "9/E", "9/F", "9/G", "9/H", "9/I", "9/J",
            "10/A", "10/B", "10/C", "10/D", "10/E", "10/F", "10/G", "10/H", "10/I", "10/J",
            "11/A", "11/B", "11/C", "11/D", "11/E", "11/F", "11/G", "11/H", "11/I", "11/J",
            "12/A", "12/B", "12/C", "12/D", "12/E", "12/F", "12/G", "12/H", "12/I", "12/J",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {


            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_add_student);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            commands = new SqlCommands();
            intent = new Intent(AddStudent.this, MainActivity.class);
            addBtn = (Button) findViewById(R.id.ekleBtn);
            random = new Random();


            tcNumberBox = (EditText) findViewById(R.id.tcTextBox);
            cardTextBox = (EditText) findViewById(R.id.kimlikTextBox);
            schoolNumberBox = (EditText) findViewById(R.id.okulNoTextBox);
            brithDayBox = (EditText) findViewById(R.id.dogumTextBox);

            commands.openDatabase(this, "Students");
            commands.createTable("Student","studentName", "studentSurname", "studentNum", "studentTcNum", "studentBirthDay", "studentCardNum");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addClick(View v)
    {
        try {

            tcNumber = tcNumberBox.getText().toString();
            cardNumber = cardTextBox.getText().toString();
            schoolNumber = schoolNumberBox.getText().toString();
            brithDay = brithDayBox.getText().toString();

           if(!tcNumber.isEmpty() && tcNumber.length() == 11)
            {
                if (!cardNumber.isEmpty() && cardNumber.length() == 9)
                {
                    if(!schoolNumber.isEmpty() && schoolNumber.length() == 4)
                    {
                        if (!brithDay.isEmpty() && brithDay.length() == 10)
                        {
                            int sayi1 = random.nextInt(50);
                            int sayi2 = random.nextInt(50);
                            int sayi3 = random.nextInt(50);

                            ContentValues values = new ContentValues();
                            values.put("studentName", studentNames[sayi1]);
                            values.put("studentSurname", studentSurnames[sayi2]); // giriş sayfası kaydı
                            values.put("studentNum", schoolNumber);
                            values.put("studentClass", studentClass[sayi3]);


                            ContentValues values1 = new ContentValues();
                            values.put("studentName", studentNames[sayi1]);
                            values.put("studentSurname", studentSurnames[sayi2]); // giriş sayfası kaydı
                            values.put("studentNum", schoolNumber);
                            values.put("studentClass", studentClass[sayi3]);

                            commands.addStudent("LoginTable",values1);

                            commands.addStudent("LoginTable",values);
                            Toast.makeText(getApplicationContext(), "Başarıyla Giriş Yaptınız", Toast.LENGTH_LONG).show();

                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Doğum Günü Kutucuğu Boş Bırakılamaz Veya Eksik Yazılımaz", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Okul Numarası Kutucuğu Boş Bırakılamaz Veya Eksik Yazılamaz", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Kimlik Seri Numarası Boş Bırakılamaz Veya Eksik Yazılamaz", Toast.LENGTH_SHORT).show();
                }
            }
           else
           {
               Toast.makeText(getApplicationContext(), "Tc Kimlik Kutusu Boş Bırakılamaz Veya Eksik Yazılamaz", Toast.LENGTH_SHORT).show();
           }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
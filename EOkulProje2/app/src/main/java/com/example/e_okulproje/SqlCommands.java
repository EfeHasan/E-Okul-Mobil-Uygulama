package com.example.e_okulproje;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.time.Year;
import java.util.ArrayList;

public class SqlCommands {
    private SQLiteDatabase database;

    public void openDatabase(Context context, String databaseName) {
        database = context.openOrCreateDatabase(databaseName, Context.MODE_PRIVATE, null);

    }

    public void closeDatabase() {
        // Veritabanını kapat
        if (database != null && database.isOpen()) {
            database.close();
        }
    }


    public void addStudent(String tableName, ContentValues content) {
        database.insert(tableName, null, content);
    }
    /*
        ContentValues values = new ContentValues();
        values.put("isim", "Ahmet");
        values.put("yas", 30); // Kullanımı
        values.put("email", "ahmet@example.com");
        databaseManager.kullaniciEkle("kayitlar", values);

    */

    /*
    public HashMap<Product, Product> tableReady(String tableName, String placeHolder, String placeHolder1, String value, String value1, String ... columnName) {
        HashMap<Product, Product> a = new HashMap<>();

        String query = String.format("SELECT * FROM %s WHERE %s=? AND %s=?", tableName, placeHolder, placeHolder1);
        Cursor cursor = database.rawQuery(query, new String[]{value, value1});


        if (cursor != null && cursor.moveToFirst()) {
            do {

                Product keyProduct = new Product(columnName[0], columnName[1], columnName[2]);//key ile deneme geliştirilmesi gerekiyor

                Product valueProduct = new Product(cursor.getString(cursor.getColumnIndex("isim")), email, yas);

                a.put(keyProduct, valueProduct);
            } while (cursor.moveToNext());
        }

        if (cursor != null) {
            cursor.close();
        }

        return a;
    }

     */

    public void deleteStudent(String tableName ,String name, String num) {
        if (database != null) {
            String whereClause = "studentName = ? and studentNum = ?";
            String[] whereArgs = {name, num};

            // Silme işlemi
            database.delete(tableName, whereClause, whereArgs);
        }
    }


    public int searchStudent(String tableName, String placeHolder, String placeHolder1, String value, String value1) {// table isimi istenecek ve sorgu

        String query = String.format("SELECT * FROM %s WHERE %s=? AND %s=?", tableName, placeHolder, placeHolder1);
        Cursor cursor = database.rawQuery(query, new String[]{value, value1});
        int bulundu = cursor.getCount();
        return bulundu;
    }

    public void createTable(String tableName, String... columns) {
        StringBuilder createTableQuery = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append(tableName)
                .append(" (id INTEGER PRIMARY KEY AUTOINCREMENT, "); // Otomatik artan bir id alanı ekliyoruz

        for (String column : columns) {
            createTableQuery.append(column).append(", ");
        }

        createTableQuery.delete(createTableQuery.length() - 2, createTableQuery.length());
        createTableQuery.append(")");

        database.execSQL(createTableQuery.toString());
    }

    public ArrayList<Student> tableReadStudent(String tableName, String placeHolder, String placeHolder1, String value, String value1) {// table isimi istenecek ve sorgu

        // Veritabanını aç
        ArrayList<Student> list = new ArrayList<>();

        try {
            String query = String.format("SELECT * FROM %s WHERE %s=? AND %s=?", tableName, placeHolder, placeHolder1);
            Cursor cursor = database.rawQuery(query, new String[]{value, value1});
            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String studentName = cursor.getString(cursor.getColumnIndex("studentName"));
                    @SuppressLint("Range") String studentSurname = cursor.getString(cursor.getColumnIndex("studentSurname"));
                    @SuppressLint("Range") String studentNum = cursor.getString(cursor.getColumnIndex("studentNum"));
                    @SuppressLint("Range") String studentTcNum = cursor.getString(cursor.getColumnIndex("studentTcNum"));
                    @SuppressLint("Range") String studentBirthDay = cursor.getString(cursor.getColumnIndex("studentBirthDay"));
                    @SuppressLint("Range") String studentCardNum = cursor.getString(cursor.getColumnIndex("studentCardNum"));

                    Student product = new Student(studentName, studentSurname, studentNum, studentTcNum, studentBirthDay, studentCardNum);
                    list.add(product);
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public ArrayList<NoteInformation> tableReadNoteInformatıon(String tableName, String placeHolder, String placeHolder1, String value, String value1) {// table isimi istenecek ve sorgu

        // Veritabanını aç
        ArrayList<NoteInformation> list = new ArrayList<>();

        try {
            String query = String.format("SELECT * FROM %s WHERE %s=? AND %s=?", tableName, placeHolder, placeHolder1);
            Cursor cursor = database.rawQuery(query, new String[]{value, value1});
            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String productName = cursor.getString(cursor.getColumnIndex("isim"));
                    @SuppressLint("Range") String productEmail = cursor.getString(cursor.getColumnIndex("email"));
                    @SuppressLint("Range") String productQuantity = cursor.getString(cursor.getColumnIndex("yas"));
                    NoteInformation product = new NoteInformation();
                    list.add(product);
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public ArrayList<StudentInformation> tableReadStudentInformation(String tableName, String placeHolder, String placeHolder1, String value, String value1) {// table isimi istenecek ve sorgu

        // Veritabanını aç
        ArrayList<StudentInformation> list = new ArrayList<>();

        try {
            String query = String.format("SELECT * FROM %s WHERE %s=? AND %s=?", tableName, placeHolder, placeHolder1);
            Cursor cursor = database.rawQuery(query, new String[]{value, value1});
            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String productName = cursor.getString(cursor.getColumnIndex("isim"));
                    @SuppressLint("Range") String productEmail = cursor.getString(cursor.getColumnIndex("email"));
                    @SuppressLint("Range") String productQuantity = cursor.getString(cursor.getColumnIndex("yas"));
                    StudentInformation product = new StudentInformation();
                    list.add(product);
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public ArrayList<LoadPage> tableReadLoadPage(String tableName) {// table isimi istenecek ve sorgu

        // Veritabanını aç
        ArrayList<LoadPage> list = new ArrayList<>();

        try {
            String query = String.format("SELECT * FROM %s", tableName);
            Cursor cursor = database.rawQuery(query, null);
            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String studentName = cursor.getString(cursor.getColumnIndex("studentName"));
                    @SuppressLint("Range") String studentSurname = cursor.getString(cursor.getColumnIndex("studentSurname"));
                    @SuppressLint("Range") String studentNum = cursor.getString(cursor.getColumnIndex("studentNum"));
                    @SuppressLint("Range") String studentClass = cursor.getString(cursor.getColumnIndex("studentClass"));

                    LoadPage product = new LoadPage(studentName, studentSurname, studentNum, studentClass);
                    list.add(product);
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public ArrayList<AbsenceInformation> tableReadAbsenceInformation(String tableName, String placeHolder, String placeHolder1, String value, String value1) {// table isimi istenecek ve sorgu

        // Veritabanını aç
        ArrayList<AbsenceInformation> list = new ArrayList<>();

        try {
            String query = String.format("SELECT * FROM %s WHERE %s=? AND %s=?", tableName, placeHolder, placeHolder1);
            Cursor cursor = database.rawQuery(query, new String[]{value, value1});
            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String studentName = cursor.getString(cursor.getColumnIndex("studentName"));
                    @SuppressLint("Range") String studentNum = cursor.getString(cursor.getColumnIndex("studentNum"));
                    @SuppressLint("Range") String studentClass = cursor.getString(cursor.getColumnIndex("studentClass"));
                    @SuppressLint("Range") String studentDate = cursor.getString(cursor.getColumnIndex("studentDate"));
                    @SuppressLint("Range") String studentType = cursor.getString(cursor.getColumnIndex("studentType"));

                    AbsenceInformation product = new AbsenceInformation(studentName, studentNum, studentClass, studentDate, studentType);
                    list.add(product);
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public ArrayList<CourseProgram> tableReadCourseProgram(String tableName, String placeHolder, String placeHolder1, String value, String value1) {// table isimi istenecek ve sorgu

        // Veritabanını aç
        ArrayList<CourseProgram> list = new ArrayList<>();

        try {
            String query = String.format("SELECT * FROM %s WHERE %s=? AND %s=?", tableName, placeHolder, placeHolder1);
            Cursor cursor = database.rawQuery(query, new String[]{value, value1});
            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String studentName = cursor.getString(cursor.getColumnIndex("studentName"));
                    @SuppressLint("Range") String studentNum = cursor.getString(cursor.getColumnIndex("studentNum"));
                    @SuppressLint("Range") String studentClass = cursor.getString(cursor.getColumnIndex("studentClass"));
                    @SuppressLint("Range") String teacherName = cursor.getString(cursor.getColumnIndex("teacherName"));
                    @SuppressLint("Range") String lessonName = cursor.getString(cursor.getColumnIndex("lessonName"));
                    @SuppressLint("Range") String day = cursor.getString(cursor.getColumnIndex("day"));

                    CourseProgram product = new CourseProgram(studentName, studentNum, studentClass, teacherName, lessonName, day);
                    list.add(product);
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public ArrayList<YearNotes> tableReadYearNotes(String tableName, String placeHolder, String placeHolder1, String value, String value1) {// table isimi istenecek ve sorgu

        // Veritabanını aç
        ArrayList<YearNotes> list = new ArrayList<>();

        try {
            String query = String.format("SELECT * FROM %s WHERE %s=? AND %s=?", tableName, placeHolder, placeHolder1);
            Cursor cursor = database.rawQuery(query, new String[]{value, value1});
            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String productName = cursor.getString(cursor.getColumnIndex("isim"));
                    @SuppressLint("Range") String productEmail = cursor.getString(cursor.getColumnIndex("email"));
                    @SuppressLint("Range") String productQuantity = cursor.getString(cursor.getColumnIndex("yas"));


                    YearNotes product = new YearNotes();
                    list.add(product);
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public ArrayList<WrittenAverages> tableReadWrittenAverages(String tableName, String placeHolder, String placeHolder1, String value, String value1) {// table isimi istenecek ve sorgu

        // Veritabanını aç
        ArrayList<WrittenAverages> list = new ArrayList<>();

        try {
            String query = String.format("SELECT * FROM %s WHERE %s=? AND %s=?", tableName, placeHolder, placeHolder1);
            Cursor cursor = database.rawQuery(query, new String[]{value, value1});
            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String productName = cursor.getString(cursor.getColumnIndex("isim"));
                    @SuppressLint("Range") String productEmail = cursor.getString(cursor.getColumnIndex("email"));
                    @SuppressLint("Range") String productQuantity = cursor.getString(cursor.getColumnIndex("yas"));
                    WrittenAverages product = new WrittenAverages();
                    list.add(product);
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
}

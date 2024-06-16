package com.example.e_okulproje;

public class LoadPage {
    String studentName;
    String studentSurname;
    String studentNum;
    String studentClass;

    public  LoadPage(String studentName, String studentSurname, String studentNum, String studentClass)
    {
        this.studentName= studentName;
        this.studentSurname = studentSurname;
        this.studentNum = studentNum;
        this.studentClass = studentClass;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }





}

package com.example.e_okulproje;

public class Student {
    String studentName;
    String studentSurname;
    String studentNum;
    String studentTcNum;
    String studentBirthDay;
    String studentCardNum;

    public Student(String studentName, String studentSurname, String studentNum, String studentTcNum, String studentBirthDay, String studentCardNum) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentNum = studentNum;
        this.studentTcNum = studentTcNum;
        this.studentBirthDay = studentBirthDay;
        this.studentCardNum = studentCardNum;
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

    public String getStudentTcNum() {
        return studentTcNum;
    }

    public void setStudentTcNum(String studentTcNum) {
        this.studentTcNum = studentTcNum;
    }

    public String getStudentBirthDay() {
        return studentBirthDay;
    }

    public void setStudentBirthDay(String studentBirthDay) {
        this.studentBirthDay = studentBirthDay;
    }

    public String getStudentCardNum() {
        return studentCardNum;
    }

    public void setStudentCardNum(String studentCardNum) {
        this.studentCardNum = studentCardNum;
    }

}

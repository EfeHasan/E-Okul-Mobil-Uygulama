package com.example.e_okulproje;

public class AbsenceInformation {
    String date;
    String classSchool;
    String studentName;
    String type;
    String studentNum;

    public  AbsenceInformation(String studentName, String studentNum, String classSchool, String date, String type)
    {
        this.studentName = studentName;
        this.studentNum = studentNum;
        this.classSchool = classSchool;
        this.date = date;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClassSchool() {
        return classSchool;
    }

    public void setClassSchool(String classSchool) {
        this.classSchool = classSchool;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }
}

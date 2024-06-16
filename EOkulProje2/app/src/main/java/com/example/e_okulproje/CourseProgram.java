package com.example.e_okulproje;

public class CourseProgram {
    String day;
    String lessonName;
    String studentName;
    String studentNum;
    String studentClass;
    String teacherName;


    public CourseProgram(String studentName, String studentNum, String studentClass, String teacherName, String lessonName, String day){
        this.studentName = studentName;
        this.studentNum = studentNum;
        this.studentClass = studentClass;
        this.teacherName = teacherName;
        this.lessonName = lessonName;
        this.day = day;
    }



    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}

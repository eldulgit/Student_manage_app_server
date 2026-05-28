package com.student.studentserver.homework;

public class HomeworkDto {

    private int studentId;
    private String homeworkName;
    private String homeworkScore;
    private String homeworkMemo;
    private String date;

    public HomeworkDto() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName;
    }

    public String getHomeworkScore() {
        return homeworkScore;
    }

    public void setHomeworkScore(String homeworkScore) {
        this.homeworkScore = homeworkScore;
    }

    public String getHomeworkMemo() {
        return homeworkMemo;
    }

    public void setHomeworkMemo(String homeworkMemo) {
        this.homeworkMemo = homeworkMemo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

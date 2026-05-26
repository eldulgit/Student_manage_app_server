package com.student.studentserver.homework;

public class HomeworkDto {

    private int studentId;
    private String homeworkName;
    private String homeworkEvaluation;
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

    public String getHomeworkEvaluation() {
        return homeworkEvaluation;
    }

    public void setHomeworkEvaluation(String homeworkEvaluation) {
        this.homeworkEvaluation = homeworkEvaluation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

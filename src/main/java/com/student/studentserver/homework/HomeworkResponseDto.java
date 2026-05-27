package com.student.studentserver.homework;

public class HomeworkResponseDto {
    private int studentId;
    private String name;
    private String homeworkName;
    private String homeworkScore;
    private String date;

    public HomeworkResponseDto() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

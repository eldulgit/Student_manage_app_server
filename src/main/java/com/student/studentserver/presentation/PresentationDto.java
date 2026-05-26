package com.student.studentserver.presentation;

//발표
public class PresentationDto {
    private int studentId;
    private int score;

    public PresentationDto() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

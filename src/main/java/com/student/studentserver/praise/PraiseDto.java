package com.student.studentserver.praise;

public class PraiseDto {
    private int studentId;
    private int score;

    public PraiseDto() {
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

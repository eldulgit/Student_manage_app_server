package com.student.studentserver.activitycheck;

public class ActivityCheckResponseDto {
    private int studentId;
    private String name;
    private String activityName;
    private String activityScore;
    private String date;

    public ActivityCheckResponseDto() {
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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityScore() {
        return activityScore;
    }

    public void setActivityScore(String activityScore) {
        this.activityScore = activityScore;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

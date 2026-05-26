package com.student.studentserver.activitycheck;

public class ActivityCheckDto {
    private int studentId;
    private String activityName;
    private String activityEvaluation;
    private String date;

    public ActivityCheckDto() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityEvaluation() {
        return activityEvaluation;
    }

    public void setActivityEvaluation(String activityEvaluation) {
        this.activityEvaluation = activityEvaluation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

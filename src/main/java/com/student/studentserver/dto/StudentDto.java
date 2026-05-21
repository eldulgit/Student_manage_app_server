package com.student.studentserver.dto;

// Android랑 주고받을 학생 데이터 모양
public class StudentDto {
    private int id;
    private String name;
    private String gender;
    private String memo;
    private String attendanceStatus;
    private String praise;
    private int praiseScore;

    public StudentDto() {
    }

    public StudentDto(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        this.praise = praise;
    }

    public int getPraiseScore() {
        return praiseScore;
    }

    public void setPraiseScore(int praiseScore) {
        this.praiseScore = praiseScore;
    }
}

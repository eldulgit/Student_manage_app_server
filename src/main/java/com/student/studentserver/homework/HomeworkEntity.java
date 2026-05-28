package com.student.studentserver.homework;

import jakarta.persistence.*;

@Entity
@Table(name = "homeworks")
public class HomeworkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int studentId;
    private String homeworkName;
    private String homeworkScore;
    private String homeworkMemo;
    private String date;

    public HomeworkEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

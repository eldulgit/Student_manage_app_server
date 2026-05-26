package com.student.studentserver.student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// DB 대신 메모리에 학생 목록 저장
@Repository
public class StudentRepository {

    private Map<Integer, StudentDto> students = new HashMap<>();

    public StudentRepository() {
        StudentDto student1 = new StudentDto(1,"홍길동","남");
        StudentDto student2 = new StudentDto(2,"김길동","남");

        students.put(student1.getId(), student1);
        students.put(student2.getId(), student2);
    }

    public List<StudentDto> findAll(){
        return new ArrayList<>(students.values());
    }

    public StudentDto findById(int id){
        return students.get(id);
    }

    public void saveStudent(StudentDto student){
        students.put(student.getId(),student);
    }

    public void updateStudent(int id, StudentDto student){
        student.setId(id);
        students.put(id,student);
    }
    public void deleteStudent(int id){
        students.remove(id);
    }
}

package com.student.studentserver.service;

import com.student.studentserver.dto.StudentDto;
import com.student.studentserver.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// 학생 조회, 추가, 수정, 삭제 같은 기능 흐름 담당
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> findAllStudent(){
        return studentRepository.findAll();
    }

    public StudentDto findByIdStudent(int id){
        return studentRepository.findById(id);
    }

    public void saveStudent(StudentDto student){
        studentRepository.saveStudent(student);
    }

    public void updateStudent(int id, StudentDto student){
        studentRepository.updateStudent(id,student);
    }

    public void deleteStudent(int id){
        studentRepository.deleteStudent(id);
    }
}

package com.student.studentserver.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// /students 같은 주소를 담당
@RestController //json 컨트롤러
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students") //조회
    public List<StudentDto> findAllStudent() {

        return studentService.findAllStudent();
    }

    @GetMapping("/students/{id}")
    public StudentDto findByIdStudent(@PathVariable int id){
        return studentService.findByIdStudent(id);
    }

    @PostMapping("/students") //새로 생성
    public StudentDto saveStudent(@RequestBody StudentDto student){
        studentService.saveStudent(student);
        return student;
    }

    @PutMapping("/students/{id}") // 기존 데이터 수정
    public StudentDto updateStudent(@PathVariable int id, @RequestBody StudentDto student){
        studentService.updateStudent(id,student);
        return student;
    }

    @DeleteMapping("/students/{id}") //삭제
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

}
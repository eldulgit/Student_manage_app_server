package com.student.studentserver.student;

import org.springframework.stereotype.Repository;
import java.util.List;

//findAll이랑 findId에서 entity에 있는 목록을 가져와서 dto로 변환후 사용자에게 표시 나머지 메서드에서 dto로 들어온 입력을 entity로 바꿔서 db에 저장
@Repository
public class StudentRepository {

    private final StudentJpaRepository studentJpaRepository;

    public StudentRepository(StudentJpaRepository studentJpaRepository) {
        this.studentJpaRepository = studentJpaRepository;
    }

    private StudentEntity toEntity(StudentDto dto){
        StudentEntity entity = new StudentEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setGender(dto.getGender());
        entity.setMemo(dto.getMemo());
        return entity;
    } //dto -> entity

    private StudentDto toDto(StudentEntity entity) {
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setGender(entity.getGender());
        dto.setMemo(entity.getMemo());
        return dto;
    }//entity -> dto

    public List<StudentDto> findAll(){
        return studentJpaRepository.findAll() //entity에서 목록 가져옴
                .stream() //변환준비
                .map(this::toDto)//변환
                .toList();//리스트로 모음
    }

    public StudentDto findById(int id) {
        return studentJpaRepository.findById(id)//entity에서 목록 가져옴
                .map(this::toDto)//변환
                .orElse(null);//값이 없으면 null반환
    }

    public void saveStudent(StudentDto student){
        studentJpaRepository.save(toEntity(student));
    }

    public void updateStudent(int id, StudentDto student){
        student.setId(id);
        studentJpaRepository.save(toEntity(student));
    }
    public void deleteStudent(int id){
        studentJpaRepository.deleteById(id);
    }
}

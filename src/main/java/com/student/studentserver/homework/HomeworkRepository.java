package com.student.studentserver.homework;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HomeworkRepository {
    private final HomeworkJpaRepository homeworkJpaRepository;

    public HomeworkRepository(HomeworkJpaRepository homeworkJpaRepository) {
        this.homeworkJpaRepository = homeworkJpaRepository;
    }

    public HomeworkEntity toEntity(HomeworkDto dto){
        HomeworkEntity entity = new HomeworkEntity();
        entity.setStudentId(dto.getStudentId());
        entity.setHomeworkName(dto.getHomeworkName());
        entity.setHomeworkScore(dto.getHomeworkScore());
        entity.setHomeworkMemo(dto.getHomeworkMemo());
        entity.setDate(dto.getDate());
        return entity;
    }

    public HomeworkDto toDto(HomeworkEntity entity){
        HomeworkDto dto = new HomeworkDto();
        dto.setStudentId(entity.getStudentId());
        dto.setHomeworkName(entity.getHomeworkName());
        dto.setHomeworkScore(entity.getHomeworkScore());
        dto.setHomeworkMemo(entity.getHomeworkMemo());
        dto.setDate(entity.getDate());
        return dto;
    }
    public void save(HomeworkDto homeworkDto){
        HomeworkEntity existingHomework = homeworkJpaRepository
                .findByStudentIdAndDateAndHomeworkName(
                homeworkDto.getStudentId(),
                homeworkDto.getDate(),
                homeworkDto.getHomeworkName()
        ).orElse(null);
        if(existingHomework == null){
            homeworkJpaRepository.save(toEntity(homeworkDto));
        }else{
            if (homeworkDto.getHomeworkScore() != null) {
                existingHomework.setHomeworkScore(homeworkDto.getHomeworkScore());
            }
            if (homeworkDto.getHomeworkMemo() != null) {
                existingHomework.setHomeworkMemo(homeworkDto.getHomeworkMemo());
            }
            homeworkJpaRepository.save(existingHomework);
        }
    }

    public List<HomeworkDto> findAll(){
        return homeworkJpaRepository.findAll().stream().map(this::toDto).toList();
    }
}

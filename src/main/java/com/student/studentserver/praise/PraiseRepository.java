package com.student.studentserver.praise;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PraiseRepository {
    private final PraiseJpaRepository praiseJpaRepository;

    public PraiseRepository(PraiseJpaRepository praiseJpaRepository) {
        this.praiseJpaRepository = praiseJpaRepository;
    }

    public PraiseEntity toEntity(PraiseDto praiseDto){
        PraiseEntity entity = new PraiseEntity();
        entity.setStudentId(praiseDto.getStudentId());
        entity.setScore(praiseDto.getScore());
        return entity;
    }

    public PraiseDto toDto(PraiseEntity praiseEntity){
        PraiseDto dto = new PraiseDto();
        dto.setStudentId(praiseEntity.getStudentId());
        dto.setScore(praiseEntity.getScore());
        return dto;
    }

    public void save(PraiseDto praiseDto){
        int studentId = praiseDto.getStudentId();
        PraiseEntity existingPraise = praiseJpaRepository.findById(studentId).orElse(null);
        if(existingPraise == null){
            praiseJpaRepository.save(toEntity(praiseDto));
        }else{
            int newScore = existingPraise.getScore() + praiseDto.getScore();
            existingPraise.setScore(newScore);
            praiseJpaRepository.save(existingPraise);
        }
    }
    public Map<Integer, PraiseDto> findAll(){
        Map<Integer, PraiseDto> result = new HashMap<>();
        for (PraiseEntity entity : praiseJpaRepository.findAll()) {
            PraiseDto dto = toDto(entity);
            result.put(dto.getStudentId(),dto);
        }
        return result;
    }
}

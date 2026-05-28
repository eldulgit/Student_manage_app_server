package com.student.studentserver.presentation;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PresentationRepository {

    private final PresentationJpaRepository presentationJpaRepository;

    public PresentationRepository(PresentationJpaRepository presentationJpaRepository) {
        this.presentationJpaRepository = presentationJpaRepository;
    }

    public PresentationEntity toEntity(PresentationDto dto){
        PresentationEntity entity = new PresentationEntity();
        entity.setStudentId(dto.getStudentId());
        entity.setScore(dto.getScore());
        return entity;
    }

    public PresentationDto toDto(PresentationEntity entity){
        PresentationDto dto = new PresentationDto();
        dto.setStudentId(entity.getStudentId());
        dto.setScore(entity.getScore());
        return dto;
    }

    public void save(PresentationDto presentationDto) {
        int studentId = presentationDto.getStudentId();
        PresentationEntity existingPresentation = presentationJpaRepository.findById(studentId).orElse(null);
        if (existingPresentation == null) {
            presentationJpaRepository.save(toEntity(presentationDto));
        } else {
            int newScore = existingPresentation.getScore() + presentationDto.getScore();
            existingPresentation.setScore(newScore);
            presentationJpaRepository.save(existingPresentation);
        }
    }

    public Map<Integer, PresentationDto> findAll() {
        Map<Integer, PresentationDto> result = new HashMap<>();

        for (PresentationEntity entity : presentationJpaRepository.findAll()) {
            PresentationDto dto = toDto(entity);
            result.put(dto.getStudentId(),dto);
        }
        return result;
    }
}

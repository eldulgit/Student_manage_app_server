package com.student.studentserver.presentation;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PresentationRepository {
    private final Map<Integer, PresentationDto> presentationDtoMap = new HashMap<>();

    public void save(PresentationDto presentationDto) {
        int studentId = presentationDto.getStudentId();
        PresentationDto existingPresentation = presentationDtoMap.get(studentId);
        if (existingPresentation == null) {
            presentationDtoMap.put(studentId, presentationDto);
        } else {
            int newScore = presentationDto.getScore() + existingPresentation.getScore();
            existingPresentation.setScore(newScore);
        }

    }

    public Map<Integer, PresentationDto> findAll() {
        return presentationDtoMap;
    }
}

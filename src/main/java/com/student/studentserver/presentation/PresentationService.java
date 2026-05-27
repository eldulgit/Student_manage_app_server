package com.student.studentserver.presentation;

import com.student.studentserver.student.StudentDto;
import com.student.studentserver.student.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PresentationService {
    private final PresentationRepository presentationRepository;
    private final StudentRepository studentRepository;

    public PresentationService(PresentationRepository presentationRepository, StudentRepository studentRepository) {
        this.presentationRepository = presentationRepository;
        this.studentRepository = studentRepository;
    }

    public void save(PresentationDto presentationDto){
        presentationRepository.save(presentationDto);
    }

    public List<PresentationResponseDto> findAll(){
        Map<Integer, PresentationDto> presentationDtoMap = presentationRepository.findAll();
        List<PresentationResponseDto> result = new ArrayList<>();

        for (PresentationDto presentationDto : presentationDtoMap.values()) {
            PresentationResponseDto responseDto = new PresentationResponseDto();
            StudentDto studentDto = studentRepository.findById(presentationDto.getStudentId());

            responseDto.setStudentId(presentationDto.getStudentId());
            responseDto.setScore(presentationDto.getScore());

            if(studentDto != null){
                responseDto.setName(studentDto.getName());
            }else{
                responseDto.setName("알 수 없음");
            }
            result.add(responseDto);
        }
        return  result;
    }
}

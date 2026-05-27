package com.student.studentserver.praise;

import com.student.studentserver.student.StudentDto;
import com.student.studentserver.student.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PraiseService {
    private final PraiseRepository praiseRepository;
    private final StudentRepository studentRepository;

    public PraiseService(PraiseRepository praiseRepository, StudentRepository studentRepository) {
        this.praiseRepository = praiseRepository;
        this.studentRepository = studentRepository;
    }

    public void save(PraiseDto praiseDto){
        praiseRepository.save(praiseDto);
    }

    public List<PraiseResponseDto> findAll(){
        Map<Integer, PraiseDto> praiseDtoMap = praiseRepository.findAll();
        List<PraiseResponseDto> result = new ArrayList<>();

        for (PraiseDto praiseDto : praiseDtoMap.values()) {
            PraiseResponseDto responseDto = new PraiseResponseDto();
            StudentDto studentDto = studentRepository.findById(praiseDto.getStudentId());

            responseDto.setStudentId(praiseDto.getStudentId());
            responseDto.setScore(praiseDto.getScore());

            if (studentDto != null) {
                responseDto.setName(studentDto.getName());
            } else {
                responseDto.setName("알 수 없음");
            }

            result.add(responseDto);
        }
        return result;
    }
}

package com.student.studentserver.homework;

import com.student.studentserver.student.StudentDto;
import com.student.studentserver.student.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomeworkService {
    private final HomeworkRepository homeworkRepository;
    private final StudentRepository studentRepository;

    public HomeworkService(HomeworkRepository homeworkRepository, StudentRepository studentRepository) {
        this.homeworkRepository = homeworkRepository;
        this.studentRepository = studentRepository;
    }

    public void save(HomeworkDto homeworkDto){
        homeworkRepository.save(homeworkDto);
    }
    public List<HomeworkResponseDto> findAll(){
        List<HomeworkDto> homeworkDtoList = homeworkRepository.findAll();
        List<HomeworkResponseDto> result = new ArrayList<>();

        for (HomeworkDto homeworkDto : homeworkDtoList) {
            HomeworkResponseDto responseDto = new HomeworkResponseDto();
            StudentDto studentDto = studentRepository.findById(homeworkDto.getStudentId());

            responseDto.setStudentId(homeworkDto.getStudentId());
            responseDto.setHomeworkName(homeworkDto.getHomeworkName());
            responseDto.setHomeworkScore(homeworkDto.getHomeworkScore());
            responseDto.setDate(homeworkDto.getDate());

            if(studentDto != null){
                responseDto.setName(studentDto.getName());
            }else{
                responseDto.setName("알 수 없음");
            }
            result.add(responseDto);
        }
        return result;
    }

}

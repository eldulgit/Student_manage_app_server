package com.student.studentserver.activitycheck;

import com.student.studentserver.student.StudentDto;
import com.student.studentserver.student.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityCheckService {
    private final ActivityCheckRepository activityCheckRepository;
    private final StudentRepository studentRepository;

    public ActivityCheckService(ActivityCheckRepository activityCheckRepository, StudentRepository studentRepository) {
        this.activityCheckRepository = activityCheckRepository;
        this.studentRepository = studentRepository;
    }

    public void save(ActivityCheckDto activityCheckDto){
        activityCheckRepository.save(activityCheckDto);
    }

    public List<ActivityCheckResponseDto> findAll(){
        List<ActivityCheckDto> activityCheckDtoList = activityCheckRepository.findAll();
        List<ActivityCheckResponseDto> result = new ArrayList<>();

        for (ActivityCheckDto activityCheckDto : activityCheckDtoList) {
            ActivityCheckResponseDto responseDto = new ActivityCheckResponseDto();
            StudentDto studentDto = studentRepository.findById(activityCheckDto.getStudentId());

            responseDto.setStudentId(activityCheckDto.getStudentId());
            responseDto.setActivityName(activityCheckDto.getActivityName());
            responseDto.setActivityScore(activityCheckDto.getActivityScore());
            responseDto.setDate(activityCheckDto.getDate());

            if(studentDto != null){
                responseDto.setName(studentDto.getName());
            }else {
                responseDto.setName("알 수 없음");
            }
            result.add(responseDto);
        }
        return result;
    }
}

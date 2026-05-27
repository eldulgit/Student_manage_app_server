package com.student.studentserver.homework;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HomeworkRepository {
    private final List<HomeworkDto> homeworkDtoList = new ArrayList<>();

    public void save(HomeworkDto homeworkDto){
        homeworkDtoList.add(homeworkDto);
    }
    public List<HomeworkDto> findAll(){
        return homeworkDtoList;
    }
}

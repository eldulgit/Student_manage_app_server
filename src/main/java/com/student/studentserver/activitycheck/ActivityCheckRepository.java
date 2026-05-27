package com.student.studentserver.activitycheck;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActivityCheckRepository {
    private final List<ActivityCheckDto> activityCheckDtoList = new ArrayList<>();

    public void save(ActivityCheckDto activityCheckDto) {
        activityCheckDtoList.add(activityCheckDto);
    }

    public List<ActivityCheckDto> findAll(){
        return activityCheckDtoList;
    }

}

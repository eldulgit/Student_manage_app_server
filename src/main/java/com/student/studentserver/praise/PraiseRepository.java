package com.student.studentserver.praise;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PraiseRepository {

    private Map<Integer, PraiseDto> praiseMap = new HashMap<>();

    public void save(PraiseDto praiseDto){
        int studentId = praiseDto.getStudentId();
        PraiseDto existingPraise = praiseMap.get(studentId);
        if(existingPraise == null){
            praiseMap.put(studentId, praiseDto);
        }else{
            int newScore = existingPraise.getScore() + praiseDto.getScore();
            existingPraise.setScore(newScore);
        }
    }
    public Map<Integer, PraiseDto> findAll(){
        return praiseMap;
    }
}

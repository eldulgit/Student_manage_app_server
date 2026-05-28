package com.student.studentserver.activitycheck;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ActivityCheckRepository {
    private final ActivityCheckJpaRepository activityCheckJpaRepository;

    public ActivityCheckRepository(ActivityCheckJpaRepository activityCheckJpaRepository) {
        this.activityCheckJpaRepository = activityCheckJpaRepository;
    }

    public ActivityCheckEntity toEntity(ActivityCheckDto dto){
        ActivityCheckEntity entity = new ActivityCheckEntity();
        entity.setStudentId(dto.getStudentId());
        entity.setActivityName(dto.getActivityName());
        entity.setActivityScore(dto.getActivityScore());
        entity.setDate(dto.getDate());
        return entity;
    }

    public ActivityCheckDto toDto(ActivityCheckEntity entity){
        ActivityCheckDto dto = new ActivityCheckDto();
        dto.setStudentId(entity.getStudentId());
        dto.setActivityName(entity.getActivityName());
        dto.setActivityScore(entity.getActivityScore());
        dto.setDate(entity.getDate());
        return dto;
    }

    public void save(ActivityCheckDto activityCheckDto) {
        ActivityCheckEntity existingActivity = activityCheckJpaRepository
                .findByStudentIdAndDateAndActivityName(
                        activityCheckDto.getStudentId(),
                        activityCheckDto.getDate(),
                        activityCheckDto.getActivityName()
                ).orElse(null);
        if(existingActivity == null){
            activityCheckJpaRepository.save(toEntity(activityCheckDto));
        }else{
            existingActivity.setActivityScore(activityCheckDto.getActivityScore());
            activityCheckJpaRepository.save(existingActivity);
        }
    }

    public List<ActivityCheckDto> findAll(){
        return activityCheckJpaRepository.findAll().stream().map(this::toDto).toList();
    }

}

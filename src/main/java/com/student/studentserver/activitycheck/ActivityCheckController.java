package com.student.studentserver.activitycheck;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityCheckController {
    private final ActivityCheckService activityCheckService;

    public ActivityCheckController(ActivityCheckService activityCheckService) {
        this.activityCheckService = activityCheckService;
    }

    @PostMapping("/activity")
    public void save(@RequestBody ActivityCheckDto activityCheckDto) {
        activityCheckService.save(activityCheckDto);
    }

    @GetMapping("/activity")
    public List<ActivityCheckResponseDto> findAll(){
        return activityCheckService.findAll();
    }
}

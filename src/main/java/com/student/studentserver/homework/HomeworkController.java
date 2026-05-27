package com.student.studentserver.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeworkController {
    private final HomeworkService homeworkService;

    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @PostMapping("/homework")
    public void save(@RequestBody HomeworkDto homeworkDto){
        homeworkService.save(homeworkDto);
    }

    @GetMapping("/homework")
    public List<HomeworkResponseDto> findAll(){
        return homeworkService.findAll();
    }
}

package com.student.studentserver.praise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PraiseController {

    private final PraiseService praiseService;

    public PraiseController(PraiseService praiseService) {
        this.praiseService = praiseService;
    }

    @PostMapping("/praise")
    public void save(@RequestBody PraiseDto praiseDto){
        praiseService.save(praiseDto);
    }

    @GetMapping("/praise")
    public List<PraiseResponseDto> findAll(){
        return praiseService.findAll();
    }
}

package com.student.studentserver.attendance;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AttendanceController {
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/attendance")
    public List<AttendanceResponseDto> findAttendance(@RequestParam String month, @RequestParam(required = false) String status){
        return attendanceService.findByMonthAndStatus(month, status);
    }

    @GetMapping("/attendance/all")
    public Map<Integer, List<AttendanceRecordDto>> findAllAttendance(){
        return attendanceService.findAllAttendance();
    }

    @PostMapping("/attendance")
    public AttendanceResponseDto saveAttendance(@RequestBody AttendanceRecordDto attendanceRecordDto){
        return attendanceService.saveAttendance(attendanceRecordDto);
    }
}

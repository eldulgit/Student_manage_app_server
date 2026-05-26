package com.student.studentserver.attendance;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AttendanceRepository {
    private Map<Integer, List<AttendanceRecordDto>> attendanceMap = new HashMap<>();

    public void save(AttendanceRecordDto attendanceRecordDto) {
        int studentId = attendanceRecordDto.getStudentId();

        List<AttendanceRecordDto> records = attendanceMap.get(studentId);

        if (records == null) {
            records = new ArrayList<>();
            attendanceMap.put(studentId, records);
        }

        records.add(attendanceRecordDto);
    }
}

package com.student.studentserver.attendance;

import com.student.studentserver.student.StudentDto;
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

    public Map<Integer, List<AttendanceRecordDto>> findAll(){
        return attendanceMap;
    }

    public List<AttendanceRecordDto> findByMonthAndStatus(String month, String status){
        List<AttendanceRecordDto> result = new ArrayList<>();
        for (List<AttendanceRecordDto> records : attendanceMap.values()) {
            for (AttendanceRecordDto record : records) {
                boolean sameMonth = record.getDate().startsWith(month);
                boolean sameStatus = status == null || record.getAttendanceStatus().equals(status);

                if(sameMonth && sameStatus){
                    result.add(record);
                }
            }
        }return result;
    }
}

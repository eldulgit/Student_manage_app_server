package com.student.studentserver.attendance;

import com.student.studentserver.student.StudentDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AttendanceRepository {
    private final AttendanceJpaRepository attendanceJpaRepository;

    public AttendanceRepository(AttendanceJpaRepository attendanceJpaRepository) {
        this.attendanceJpaRepository = attendanceJpaRepository;
    }

    public AttendanceEntity toEntity(AttendanceRecordDto dto) {
        AttendanceEntity entity = new AttendanceEntity();
        entity.setStudentId(dto.getStudentId());
        entity.setAttendanceStatus(dto.getAttendanceStatus());
        entity.setDate(dto.getDate());
        return entity;
    }

    public AttendanceRecordDto toDto(AttendanceEntity entity) {
        AttendanceRecordDto dto = new AttendanceRecordDto();
        dto.setStudentId(entity.getStudentId());
        dto.setAttendanceStatus(entity.getAttendanceStatus());
        dto.setDate(entity.getDate());
        return dto;
    }

    public void save(AttendanceRecordDto attendanceRecordDto) {
        AttendanceEntity existingAttendance = attendanceJpaRepository.findByStudentIdAndDate(
                attendanceRecordDto.getStudentId(),
                attendanceRecordDto.getDate()
        ).orElse(null);
        if(existingAttendance == null){
            attendanceJpaRepository.save(toEntity(attendanceRecordDto));
        }else{
            existingAttendance.setAttendanceStatus(attendanceRecordDto.getAttendanceStatus());
            attendanceJpaRepository.save(existingAttendance);
        }
    }

    public Map<Integer, List<AttendanceRecordDto>> findAll() {
        Map<Integer, List<AttendanceRecordDto>> result = new HashMap<>();
        for (AttendanceEntity entity : attendanceJpaRepository.findAll()) {
            AttendanceRecordDto dto = toDto(entity);
            int studentId = dto.getStudentId();

            List<AttendanceRecordDto> records = result.get(studentId);
            if (records == null) {
                records = new ArrayList<>();
                result.put(studentId, records);
            }
            records.add(dto);
        }
        return result;
    }

    public List<AttendanceRecordDto> findByMonthAndStatus(String month, String status) {
        List<AttendanceRecordDto> result = new ArrayList<>();
        for (AttendanceEntity entity : attendanceJpaRepository.findAll()) {
            AttendanceRecordDto record = toDto(entity);
            boolean sameMonth = record.getDate().startsWith(month);
            boolean sameStatus = status == null || record.getAttendanceStatus().equals(status);

            if (sameMonth && sameStatus) {
                result.add(record);
            }

        }
        return result;
    }

    public void deleteByDate(String date) {
        attendanceJpaRepository.deleteByDate(date);
    }
}

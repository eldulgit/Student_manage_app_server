package com.student.studentserver.attendance;

import com.student.studentserver.student.StudentDto;
import com.student.studentserver.student.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;

    public AttendanceService(AttendanceRepository attendanceRepository, StudentRepository studentRepository) {
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
    }

    public AttendanceResponseDto saveAttendance(AttendanceRecordDto attendanceRecordDto){
        attendanceRepository.save(attendanceRecordDto);

        StudentDto studentDto = studentRepository.findById(attendanceRecordDto.getStudentId());

        AttendanceResponseDto responseDto = new AttendanceResponseDto();
        responseDto.setStudentId(attendanceRecordDto.getStudentId());
        responseDto.setDate(attendanceRecordDto.getDate());
        responseDto.setAttendanceStatus(attendanceRecordDto.getAttendanceStatus());

        if (studentDto != null) {
            responseDto.setName(studentDto.getName());
        } else {
            responseDto.setName("알 수 없음");
        }

        return responseDto;
    }

    public Map<Integer, List<AttendanceRecordDto>> findAllAttendance(){
        return attendanceRepository.findAll();
    }

    public List<AttendanceResponseDto> findByMonthAndStatus(String month, String status){
        /*
        1. 조건에 맞는 출석 기록들을 records에 담는다.
        2. 앱에 보낼 결과 목록 result를 새로 만든다.
        3. records를 하나씩 돌면서 record를 꺼낸다.
        4. record 값을 responseDto에 옮겨 담는다.
        5. studentId로 학생 정보를 조회해서 name을 넣는다.
        6. 완성된 responseDto를 result에 add한다.
        7. 최종 result를 반환한다.
        */
        List<AttendanceRecordDto> records = attendanceRepository.findByMonthAndStatus(month,status);
        List<AttendanceResponseDto> result = new ArrayList<>();

        for (AttendanceRecordDto record : records) {
            AttendanceResponseDto responseDto = new AttendanceResponseDto();
            responseDto.setStudentId(record.getStudentId());
            responseDto.setDate(record.getDate());
            responseDto.setAttendanceStatus(record.getAttendanceStatus());
            StudentDto studentDto = studentRepository.findById(record.getStudentId());

            if (studentDto != null) {
                responseDto.setName(studentDto.getName());
            } else {
                responseDto.setName("알 수 없음");
            }
            result.add(responseDto);
        }
        return result;
    }

    @Transactional
    public void deleteByDate(String date) {
        attendanceRepository.deleteByDate(date);
    }

}

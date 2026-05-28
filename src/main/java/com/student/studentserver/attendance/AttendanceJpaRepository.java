package com.student.studentserver.attendance;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AttendanceJpaRepository extends JpaRepository<AttendanceEntity, Long> {
    Optional<AttendanceEntity> findByStudentIdAndDate(int studentId, String date);
    void deleteByDate(String date);
}


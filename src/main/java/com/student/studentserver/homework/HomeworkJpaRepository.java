package com.student.studentserver.homework;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HomeworkJpaRepository extends JpaRepository<HomeworkEntity,Long> {
    Optional<HomeworkEntity> findByStudentIdAndDateAndHomeworkName(int studentId, String date, String homeworkName);
}

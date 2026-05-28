package com.student.studentserver.activitycheck;

import com.student.studentserver.homework.HomeworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ActivityCheckJpaRepository extends JpaRepository<ActivityCheckEntity, Long> {
    Optional<ActivityCheckEntity> findByStudentIdAndDateAndActivityName(int studentId, String date, String activityName);
}

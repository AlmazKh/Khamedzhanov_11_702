package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.models.WorkTime;

import java.util.List;

public interface WorkTimeRepository extends JpaRepository<WorkTime, Long> {
    @Query(value = "SELECT * FROM work_time wt WHERE wt.time NOT IN " +
            "(SELECT r.time FROM reception r WHERE r.doctor_id = :doctorId AND r.date = :date)", nativeQuery = true)
    List<WorkTime> findWorkTimesByDoctor_IdAndDate(
            @Param("doctorId")Long doctorId,
            @Param("date") String date
    );
}

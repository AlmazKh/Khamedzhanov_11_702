package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.models.Procedure;

import java.util.List;

public interface ProceduresRepository extends JpaRepository<Procedure, Long> {
    @Query(value = "SELECT * FROM procedure p JOIN hospital_procedure hp ON p.id = hp.procedure_id WHERE hp.hospital_id = :hospitalId", nativeQuery = true)
    List<Procedure> findProceduresByHospitalId(@Param("hospitalId") Long hospitalId);
}

package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.models.Doctor;

import java.util.List;

public interface DoctorsRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findDoctorsByHospital_IdAndProcedure_Id(Long hospitalId, Long procedureId);

    List<Doctor> findDoctorsByHospital_Id(Long hospitalId);

    @Query(value = "SELECT * FROM doctor d JOIN reception r ON d.id = r.doctor_id WHERE  user_id = ?1", nativeQuery = true)
    List<Doctor> getDoctorsByPatientId(Long patientId);

}

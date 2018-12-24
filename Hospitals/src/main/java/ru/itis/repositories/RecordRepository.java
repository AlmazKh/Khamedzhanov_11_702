package ru.itis.repositories;

import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;
import ru.itis.models.WorkTime;

import java.util.List;

public interface RecordRepository extends CrudRepository<Hospital> {
    List<Hospital> getHospitals();
    List<Doctor> getDoctors();
    List<Procedure> getProcedures();
    List<Doctor> getDoctors(Long hospitalId, Long procedureId);
    List<WorkTime> getTime(Long doctorId, String date);

    void addReception(Long doctorId, String dateTime, Long patientId);
    Hospital getHospital(Long hospitalId);


}

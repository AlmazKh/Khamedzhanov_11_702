package ru.itis.repositories;

import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;

import java.util.List;

public interface RecordRepository extends CrudRepository<Hospital> {
    List<Hospital> getHospitals();
    List<Doctor> getDoctors();
    List<Procedure> getProcedures();
    void addReception(Long doctorId, String dateTime, Long patientId);
    Hospital getHospital(Long hospitalId);


}

package ru.itis.repositories;

import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;
import ru.itis.models.Reception;

import java.util.List;

public interface ComponentsRepository extends CrudRepository<Hospital> {
    List<Doctor> getDoctors(Long hospitalId);
    List<Procedure> getProcedures(Long hospitalId);
    List<Reception> getReception(Long userId);
    List<Doctor> getDoctorsNameById(Long patientId);
    List<Hospital> getHospitalsByAddress(String address);

}

package ru.itis.services;

import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;
import ru.itis.models.Reception;

import java.util.List;

public interface ComponentsService {

    List<Doctor> getDoctors(Long hospitalId);
    List<Procedure> getProcedures(Long hospitalId);
    List<Reception> getReception(Long userId);
    List<Doctor> getDoctorsNameById(Long patientId);
    List<Hospital> getHospitalsByAddress(String address);
}

package ru.itis.services;

import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;

import java.util.List;

public interface RecordService {
    List<Hospital> getHospitals();
    List<Doctor> getDoctors();
    List<Procedure> getProcedures();
    void addReception(Long doctorId, String dateTime);

}

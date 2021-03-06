package ru.itis.services;

import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;
import ru.itis.models.WorkTime;

import java.util.List;

public interface RecordService {

    List<Hospital> getHospitals();
    List<Doctor> getDoctors();
    List<Procedure> getProcedures();
    List<Doctor> getDoctors(Long hospitalId, Long procedureId);
    List<WorkTime> getTime(Long doctorId, String date);
    void addReception(Long doctorId, String date, String time, Long patientId);
}

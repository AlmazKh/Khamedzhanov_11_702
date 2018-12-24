package ru.itis.services;

import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;
import ru.itis.models.WorkTime;
import ru.itis.repositories.RecordRepository;

import java.util.List;

public class RecordServiceImpl implements RecordService {

    RecordRepository recordRepository;

    public RecordServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public List<Hospital> getHospitals() {
        return recordRepository.getHospitals();
    }

    @Override
    public List<Doctor> getDoctors() {
        return recordRepository.getDoctors();
    }

    @Override
    public List<Procedure> getProcedures() {
        return recordRepository.getProcedures();
    }

    @Override
    public List<Doctor> getDoctors(Long hospitalId, Long procedureId) {
        return recordRepository.getDoctors(hospitalId, procedureId);
    }

    @Override
    public List<WorkTime> getTime(Long doctorId, String date) {
        return recordRepository.getTime(doctorId, date);
    }


    @Override
    public void addReception(Long doctorId, String date, String time, Long patientId) {
        recordRepository.addReception(doctorId, date, time, patientId);
    }


}

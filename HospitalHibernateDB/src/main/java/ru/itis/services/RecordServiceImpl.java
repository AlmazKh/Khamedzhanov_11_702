package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.forms.RecordForm;
import ru.itis.models.*;
import ru.itis.repositories.*;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    ReceptionRepository receptionRepository;
    @Autowired
    DoctorsRepository doctorsRepository;
    @Autowired
    ProceduresRepository proceduresRepository;
    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    WorkTimeRepository workTimeRepository;

    @Override
    public List<Hospital> getHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public List<Doctor> getDoctors() {
        return doctorsRepository.findAll();
    }

    @Override
    public List<Procedure> getProcedures() {
        return proceduresRepository.findAll();
    }

    @Override
    public List<Doctor> getDoctors(Long hospitalId, Long procedureId) {
        return doctorsRepository.findDoctorsByHospital_IdAndProcedure_Id(hospitalId, procedureId);
    }

    @Override
    public List<WorkTime> getTime(Long doctorId, String date) {
        return workTimeRepository.findWorkTimesByDoctor_IdAndDate(doctorId, date);
    }


    @Override
    public void addReception(RecordForm recordForm, Long userId) {
        Reception reception = Reception.builder()
                .doctor(Doctor.builder().id(recordForm.getDoctor_id()).build())
                .user(User.builder().id(userId).build())
                .date(recordForm.getDate())
                .time(recordForm.getTime())
                .build();

        receptionRepository.save(reception);
    }
}

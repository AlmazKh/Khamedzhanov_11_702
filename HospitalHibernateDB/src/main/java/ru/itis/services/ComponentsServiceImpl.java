package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;
import ru.itis.models.Reception;
import ru.itis.repositories.DoctorsRepository;
import ru.itis.repositories.HospitalRepository;
import ru.itis.repositories.ProceduresRepository;
import ru.itis.repositories.ReceptionRepository;

import java.util.List;

@Service
public class ComponentsServiceImpl implements ComponentsService {

    @Autowired
    ReceptionRepository receptionRepository;
    @Autowired
    DoctorsRepository doctorsRepository;
    @Autowired
    ProceduresRepository proceduresRepository;
    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public List<Doctor> getDoctors(Long hospitalId) {
        return doctorsRepository.findDoctorsByHospital_Id(hospitalId);
    }

    @Override
    public List<Procedure> getProcedures(Long hospitalId) {
        return proceduresRepository.findProceduresByHospitalId(hospitalId);
    }

    @Override
    public List<Reception> getReception(Long userId) {
        return receptionRepository.findReceptionsByUser_Id(userId);
    }

    @Override
    public List<Doctor> getDoctorsByPatientId(Long patientId) {
        return doctorsRepository.getDoctorsByPatientId(patientId);
    }

    @Override
    public List<Hospital> getHospitalsByAddress(String address) {
        return hospitalRepository.getHospitalsByAddress("%" + address + "%");
    }
}

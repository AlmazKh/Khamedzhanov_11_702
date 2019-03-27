package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;
import ru.itis.models.Reception;
import ru.itis.repositories.ComponentsRepository;

import java.util.List;

public class ComponentsServiceImpl implements ComponentsService {

    @Autowired
    ComponentsRepository componentsRepository;

    @Override
    public List<Doctor> getDoctors(Long hospitalId) {
        return componentsRepository.getDoctors(hospitalId);
    }

    @Override
    public List<Procedure> getProcedures(Long hospitalId) {
        return componentsRepository.getProcedures(hospitalId);
    }

    @Override
    public List<Reception> getReception(Long userId) {
        return componentsRepository.getReception(userId);
    }

    @Override
    public List<Doctor> getDoctorsNameById(Long patientId) {
        return componentsRepository.getDoctorsNameById(patientId);
    }

    @Override
    public List<Hospital> getHospitalsByAddress(String address) {
        return componentsRepository.getHospitalsByAddress(address);
    }
}

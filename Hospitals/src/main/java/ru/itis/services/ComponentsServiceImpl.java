package ru.itis.services;

import ru.itis.models.Doctor;
import ru.itis.models.Procedure;
import ru.itis.models.Reception;
import ru.itis.repositories.ComponentsRepository;

import java.util.List;

public class ComponentsServiceImpl implements ComponentsService {

    ComponentsRepository componentsRepository;

    public ComponentsServiceImpl(ComponentsRepository componentsRepository) {
        this.componentsRepository = componentsRepository;
    }

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
}

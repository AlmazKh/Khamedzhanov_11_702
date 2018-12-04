package ru.itis.services;

import ru.itis.models.Hospital;
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
}

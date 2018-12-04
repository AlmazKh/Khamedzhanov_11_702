package ru.itis.repositories;

import ru.itis.models.Hospital;

import java.util.List;

public interface RecordRepository extends CrudRepository<Hospital> {
    List<Hospital> getHospitals();

}

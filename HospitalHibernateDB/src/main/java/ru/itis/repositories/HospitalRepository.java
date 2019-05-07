package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.models.Hospital;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    @Query(value = "SELECT * FROM hospital WHERE hospital.address ilike ?1", nativeQuery = true)
    List<Hospital> getHospitalsByAddress(String address);
}

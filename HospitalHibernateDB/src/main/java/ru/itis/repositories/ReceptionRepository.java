package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Reception;

import java.util.List;

public interface ReceptionRepository extends JpaRepository<Reception, Long> {
    List<Reception> findReceptionsByUser_Id(Long userId);
}

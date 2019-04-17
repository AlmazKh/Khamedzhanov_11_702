package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}

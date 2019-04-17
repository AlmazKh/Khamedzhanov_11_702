package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.forms.FeedbackForm;
import ru.itis.models.Feedback;
import ru.itis.repositories.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public void addFeedback(FeedbackForm feedbackForm) {
        Feedback feedback = Feedback.builder()
                .name(feedbackForm.getName())
                .phone(feedbackForm.getPhone())
                .email(feedbackForm.getEmail())
                .text(feedbackForm.getText())
                .build();
        feedbackRepository.save(feedback);
    }
}

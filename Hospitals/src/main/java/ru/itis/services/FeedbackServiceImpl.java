package ru.itis.services;

import ru.itis.form.FeedbackForm;
import ru.itis.models.Feedback;
import ru.itis.repositories.FeedbackRepository;

public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

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

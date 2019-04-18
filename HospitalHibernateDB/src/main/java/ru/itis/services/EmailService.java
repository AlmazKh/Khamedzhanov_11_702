package ru.itis.services;

public interface EmailService {
    void sendMail(String subject, String text, String email);
}

package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class FeedbackForm {

    String name;
    String phone;
    String email;
    String text;
}

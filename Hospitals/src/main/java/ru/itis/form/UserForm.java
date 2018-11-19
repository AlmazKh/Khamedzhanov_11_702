package ru.itis.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    private String firstName;
    private String lastName;
    private String gender;
    private String phone;
    private String password;
}


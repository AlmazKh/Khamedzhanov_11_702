package ru.itis.forms;

import lombok.Data;

@Data
public class SignUpForm {

    private String firstName;
    private String lastName;
    private String gender;
    private String phone;
    private String password;
}

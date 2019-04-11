package ru.itis.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String phone; //логин
    private String hashPassword;
    private String firstName;
    private String lastName;
    private String gender;
    private Polis polis;
//    private List<Reception> receptions;
}

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
public class Doctor {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer cabinetNumber;
    private Integer rating;
    private Hospital hospital;
    private Procedure procedure;
}



package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reception {
    private Long id;
    private Polis polis;
    private Integer cabinetNumber;
    private Doctor doctor;
    private String time;
}

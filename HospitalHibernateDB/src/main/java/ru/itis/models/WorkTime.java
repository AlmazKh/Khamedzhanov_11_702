package ru.itis.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class WorkTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 10)
    String time;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    Doctor doctor;
}

package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "reception")
public class Reception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "id")
//    private Polis polis;
    @Column(length = 5)
    private Integer cabinetNumber;
//    @ManyToOne
//    @JoinColumn(name = "id")
//    private Doctor doctor;
    @Column(length = 15)
    private String date;
    @Column(length = 15)
    private String time;
}

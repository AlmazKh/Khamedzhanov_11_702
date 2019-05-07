package ru.itis.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String address;
    @Column(length = 20)
    private String phone;
    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name="hospital_procedure",
            joinColumns=@JoinColumn(name="hospital_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="procedure_id", referencedColumnName="id"))
    private List<Procedure> procedures;
}

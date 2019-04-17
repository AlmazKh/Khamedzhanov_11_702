package ru.itis.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 30)
    String name;
    @Column(length = 20)
    String phone;
    @Column(length = 30)
    String email;
    @Column(length = 1000)
    String text;
}

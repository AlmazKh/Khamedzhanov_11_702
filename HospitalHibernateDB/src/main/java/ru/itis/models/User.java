package ru.itis.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "patient")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 12)
    private String phone;
    @Column(name = "password_hash", length = 200)
    private String hashPassword;
    @Column(length = 20)
    private String firstName;
    @Column(length = 20)
    private String lastName;
    @Column(length = 5)
    private String gender;
//    @ManyToOne
//    @JoinColumn(name = "id")
//    private Polis polis;
}
package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "patient")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 40)
    private String phone;
    @Column(name = "password_hash", length = 200)
    private String hashPassword;
    @Column(length = 20)
    private String firstName;
    @Column(length = 20)
    private String lastName;
    @Column(length = 5)
    private String gender;

    @Enumerated(value = EnumType.STRING)
    private UserState state;

    private String confirmString;

    public boolean isEnabled() {
        return this.getState().equals(UserState.CONFIRMED);
    }
}
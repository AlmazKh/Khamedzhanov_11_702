package ru.itis.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class User {
    private Long id;

    private Integer phone;
    private String hashPassword;
    //общие поля
    private String firstName;
    private String lastName;
    private String gender;
    private Role role;
    //поля доктора + admin
    private Integer raiting;
    private Hospital hospital;
    private List<Procedure> procedures;
    //поля пациента
    private Polis polis;
    private List<Reception> receptions;

 

    public boolean isAdmin() {
        return role.equals(Role.ADMIN);
    }


    public class InnerAdmin {
        public List<Procedure> getProcedures() {
            return procedures;
        }
    }

    public InnerAdmin asAdmin() {
        return new InnerAdmin();
    }

}

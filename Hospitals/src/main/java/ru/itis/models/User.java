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

    private String phone;
    private String hashPassword;
    //общие поля
    private String firstName;
    private String lastName;
    private String gender;
    private Role role;
    //поля доктора + admin
    private Integer raiting;
    private Hospital hospital;
    private Procedure procedure;
    //поля пациента
    private Polis polis;
    private List<Reception> receptions;

 

    public boolean isAdmin() {
        return role.equals(Role.ADMIN);
    }

    public class InnerAdmin {
        public Procedure getProcedure() {
            return procedure;
        }
    }

    public InnerAdmin asAdmin() {
        return new InnerAdmin();
    }

}

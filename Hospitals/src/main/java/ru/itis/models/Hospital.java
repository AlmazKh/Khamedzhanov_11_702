package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {

    private Long id;
    private String address;
    private String phone;
    private List<Procedure> procedures;
    private List<User> doctors;
}

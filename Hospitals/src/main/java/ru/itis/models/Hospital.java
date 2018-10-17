package ru.itis.models;

import java.util.List;

public class Hospital {
    private Long id;
    private String address;
    private String phone;
    private List<Procedure> procedures;
    private List<User> doctors;
}

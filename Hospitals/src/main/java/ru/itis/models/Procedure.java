package ru.itis.models;

import javax.print.Doc;
import java.util.List;

public class Procedure {
    private Long id;
    private String name;
    private Integer price;
    private List<Hospital>  hospitals;
    private List<User> doctors;
}

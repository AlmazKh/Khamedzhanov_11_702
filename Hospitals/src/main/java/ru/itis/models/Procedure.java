package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.Doc;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Procedure {
    private Long id;
    private String name;
    private Integer price;
    private List<Hospital>  hospitals;
    private List<User> doctors;
}

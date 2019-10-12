package ru.itis;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerTeam {
    private Long id;
    private Player player;
    private Team team;
    private Integer startYear;
    private Integer endYear;

}

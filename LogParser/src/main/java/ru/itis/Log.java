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
public class Log {
    private Long id;
    private String ip;
    private String date;
    private String method;
    private String url;
    private String protocol;
    private Integer status;
    private Integer size;
    private String clientId;
}

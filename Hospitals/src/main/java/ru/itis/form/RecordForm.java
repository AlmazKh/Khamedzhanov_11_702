package ru.itis.form;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordForm {

    Long hospitalId;
    Long doctorId;
    Long procedureId;
    String date;
    String time ;
}

package ru.itis.forms;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RecordForm {

    Long doctor_id;
    String date;
    String time ;
}

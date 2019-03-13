package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;
import ru.itis.models.Reception;

import javax.sql.DataSource;
import java.util.List;

public class ComponentsRepositoryImpl implements ComponentsRepository {

    // класс из Spring Framework
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_DOCTORS=
            "SELECT * FROM doctor WHERE hospital_id = ?";

    //language=SQL
    private static final String SQL_SELECT_DOCTORS_BY_PATIENT_ID=
            "SELECT last_name FROM doctor d " +
                    "JOIN reception r ON d.id = r.doctor_id " +
                    "WHERE  patient_id = ?";

    //language=SQL
    private static final String SQL_SELECT_PROCEDURES=
            "SELECT * FROM procedure p JOIN hospital_proceduce hp ON p.id = hp.procedure_id WHERE hp.hospital_id = ?";

    //language=SQL
    private static final String SQL_SELECT_RECEPTIONS=
            "SELECT * FROM reception WHERE patient_id = ?";

    private RowMapper<Doctor> doctorRowMapper = (resultSet, i) -> Doctor.builder()
            .id(resultSet.getLong("id"))
            .firstName(resultSet.getString("first_name"))
            .lastName(resultSet.getString("last_name"))
            .rating(resultSet.getInt("rating"))
            .cabinetNumber((resultSet.getInt("cabinet_number")))
            .build();

    private RowMapper<Doctor> doctorNameRowMapper = (resultSet, i) -> Doctor.builder()
            .lastName(resultSet.getString("last_name"))
            .build();

    private RowMapper<Procedure> procedureRowMapper = (resultSet, i) -> Procedure.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .price(resultSet.getInt("price"))
            .build();

    private RowMapper<Reception> receptionRowMapper = (resultSet, i) -> Reception.builder()
            .id(resultSet.getLong("id"))
            .cabinetNumber(resultSet.getInt("cabinet_number"))
            .date(resultSet.getString("date"))
            .time(resultSet.getString("time"))
            .build();

    @Override
    public List<Doctor> getDoctors(Long hospitalId) {
        return jdbcTemplate.query(SQL_SELECT_DOCTORS, doctorRowMapper, hospitalId);
    }

    @Override
    public List<Procedure> getProcedures(Long hospitalId) {
        return jdbcTemplate.query(SQL_SELECT_PROCEDURES, procedureRowMapper, hospitalId);
    }

    @Override
    public List<Reception> getReception(Long userId) {
        return jdbcTemplate.query(SQL_SELECT_RECEPTIONS, receptionRowMapper, userId);
    }

    @Override
    public List<Doctor> getDoctorsNameById(Long patientId) {
        return jdbcTemplate.query(SQL_SELECT_DOCTORS_BY_PATIENT_ID, doctorNameRowMapper, patientId);
    }

    @Override
    public List<Hospital> findAll() {
        return null;
    }

    @Override
    public Hospital find(Long id) {
        return null;
    }

    @Override
    public void save(Hospital model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Hospital model) {

    }
}

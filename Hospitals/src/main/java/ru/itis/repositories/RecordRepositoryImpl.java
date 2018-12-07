package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;

import javax.sql.DataSource;
import java.util.List;

public class RecordRepositoryImpl implements RecordRepository {

    //TODO: продумать селекты выбора докоторов и больниц, через процедуры (джойны ждут)

    // класс из Spring Framework
    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_HOSPITALS=
            "SELECT * FROM hospital";

    //language=SQL
    private static final String SQL_SELECT_DOCTORS=
            "SELECT * FROM doctor";

    //language=SQL
    private static final String SQL_SELECT_CABINET_BY_DOCTOR_ID=
            "SELECT cabinet_number FROM doctor WHERE id = ?";

    //language=SQL
    private static final String SQL_SELECT_PROCEDURES=
            "SELECT * FROM procedure";

    //language=SQL
    private static final String SQL_INSERT_RECEPTION =
            "INSERT INTO reception (cabinet_number, time, doctor_id, patient_id) VALUES (?, ?, ?, ?)";

    public RecordRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Hospital> hospitalRowMapper = (resultSet, i) -> Hospital.builder()
            .id(resultSet.getLong("id"))
            .address(resultSet.getString("address"))
            .phone(resultSet.getString("phone"))
            .build();

    private RowMapper<Doctor> doctorRowMapper = (resultSet, i) -> Doctor.builder()
            .id(resultSet.getLong("id"))
            .firstName(resultSet.getString("first_name"))
            .lastName(resultSet.getString("last_name"))
            .rating(resultSet.getInt("rating"))
            .build();

    private RowMapper<Procedure> procedureRowMapper = (resultSet, i) -> Procedure.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .price(resultSet.getInt("price"))
            .build();

    private RowMapper<Integer> doctorCabinetRowMapper = (resultSet, i) -> resultSet.getInt("cabinet_number");

    @Override
    public List<Hospital> getHospitals() {
        return jdbcTemplate.query(SQL_SELECT_HOSPITALS, hospitalRowMapper);
    }

    @Override
    public List<Doctor> getDoctors() {
        return jdbcTemplate.query(SQL_SELECT_DOCTORS, doctorRowMapper);
    }

    @Override
    public List<Procedure> getProcedures() {
        return jdbcTemplate.query(SQL_SELECT_PROCEDURES, procedureRowMapper);
    }

    @Override
    public void addReception(Long doctorId, String dateTime, Long patientId) {
        Integer cabinetNumber = jdbcTemplate.query(SQL_SELECT_CABINET_BY_DOCTOR_ID, doctorCabinetRowMapper, doctorId).get(0);
        jdbcTemplate.update(SQL_INSERT_RECEPTION, cabinetNumber, dateTime, doctorId, patientId);
    }

    @Override
    public Hospital getHospital(Long hospitalId) {
        return null;
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

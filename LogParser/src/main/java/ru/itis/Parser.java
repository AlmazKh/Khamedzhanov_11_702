package ru.itis;


import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Parser {

    private JdbcTemplate jdbcTemplate;
    private Log log;

    public Parser(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MMM/yyyy:HH:mm:ss xxx", Locale.US);

    //language=SQL
    private  static final String SQL_INSERT_INFO =
            "INSERT INTO log_2(ip, date_time, method, url, protocol, status, size, client_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public void parse(){
        try {
            FileInputStream readLogs = new FileInputStream("access.log");
            Scanner scanner = new Scanner(readLogs);
            log = new Log();
//            int i = 0;
            while (scanner.hasNext()) {
                log.setIp(scanner.next());
                scanner.next();
                scanner.next();
                String dt = scanner.next() + " " + scanner.next();
                dt = dt.substring(1, dt.length()-1);
                LocalDateTime localDateTime = LocalDateTime.parse(dt, dateTimeFormatter);
                log.setDateTime(LocalDateTime.parse(dt, dateTimeFormatter));
                log.setMethod(scanner.next());
                log.setUrl(scanner.next());
                log.setProtocol(scanner.next() + " " +  scanner.next());
                log.setStatus(scanner.nextInt());
                log.setSize(scanner.nextInt());
                log.setClientId(scanner.next());
                insert(log);
            }
        } catch (Exception e) {

        }
    }

    public void insert(Log log) {
        jdbcTemplate.update(SQL_INSERT_INFO, log.getIp(), log.getDateTime(), log.getMethod(),
                log.getUrl(), log.getProtocol(), log.getStatus(), log.getSize(), log.getClientId());
    }

}

package ru.itis;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.FileInputStream;
import java.util.Scanner;

public class Parser {

    private JdbcTemplate jdbcTemplate;
    private Log log;

    //language=SQL
    private static final String SQL_INSERT_INFO =
            "INSERT INTO log(ip, date, method, url, protocol, status, size, client_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public void init(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/log");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void parse(){
        try {
            FileInputStream readLogs = new FileInputStream("access.log");
            Scanner scanner = new Scanner(readLogs);
            log = new Log();
            while (scanner.hasNext()) {
                log.setIp(scanner.next());
                scanner.next();
                scanner.next();
                log.setDate(scanner.next() + scanner.next());
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
        jdbcTemplate.update(SQL_INSERT_INFO, log.getIp(), log.getDate(), log.getMethod(),
                log.getUrl(), log.getProtocol(), log.getStatus(), log.getSize(), log.getClientId());

//        String i = log.getIp();
//        String d = log.getDate();
//        String m = log.getMethod();
//        String u = log.getUrl();
//        String p = log.getProtocol();
//        String s = log.getStatus();
//        String ss = log.getSize();
//        String c = log.getClientId();
//        int update = jdbcTemplate.update(SQL_INSERT_INFO, i, d, m, u, p, s, ss, c);


    }

}

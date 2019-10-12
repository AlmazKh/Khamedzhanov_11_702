package ru.itis;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Main {
    public static void main(String[] args) {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        try {
//            Class.forName("org.postgresql.Driver");
//            //on classpath
//        } catch(ClassNotFoundException e) {
//            // not on classpath
//        }
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/log");

        ParserTxt parser = new ParserTxt(dataSource);
        parser.parsePlayer();
        parser.parseTeam();
        parser.parsePlayerTeam();


    }

}

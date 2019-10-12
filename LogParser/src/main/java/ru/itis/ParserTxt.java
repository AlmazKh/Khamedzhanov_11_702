package ru.itis;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class ParserTxt {
    private JdbcTemplate jdbcTemplate;
    private Player player;
    private Team team;
    private PlayerTeam playerTeam;

    public ParserTxt(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //language=SQL
    private  static final String SQL_INSERT_PLAYER =
            "INSERT INTO player(id, name, city) VALUES (?, ?, ?)";

    //language=SQL
    private  static final String SQL_INSERT_TEAM =
            "INSERT INTO team(id, name, city) VALUES (?, ?, ?)";
    //language=SQL
    private  static final String SQL_INSERT_PLAYER_TEAM =
            "INSERT INTO player_team(player_id, team_id, start_year, end_year) VALUES (?, ?, ?, ?)";

    public void parsePlayer(){
        try {
            FileInputStream readPlayers = new FileInputStream("players.txt");
            Scanner scanner = new Scanner(readPlayers);
            player = new Player();
            while (scanner.hasNext()) {
                player.setId(scanner.nextLong());
                scanner.next();
                player.setName(scanner.next());
                scanner.next();
                player.setCity(scanner.next());
                insertPlayer(player);
            }
        } catch (Exception e) {

        }
    }

    public void parseTeam(){
        try {
            FileInputStream readTeams = new FileInputStream("teams.txt");
            Scanner scanner = new Scanner(readTeams);
            team = new Team();
            while (scanner.hasNext()) {
                team.setId(scanner.nextLong());
                scanner.next();
                team.setName(scanner.next());
                scanner.next();
                team.setCity(scanner.next());
                insertTeam(team);
            }
        } catch (Exception e) {

        }
    }

    public void parsePlayerTeam(){
        try {
            FileInputStream readPlayerTeams = new FileInputStream("player_team.txt");
            Scanner scanner = new Scanner(readPlayerTeams);
            playerTeam = new PlayerTeam();
            while (scanner.hasNext()) {
                playerTeam.setTeam(new Team(scanner.nextLong(), "", ""));
                scanner.next();
                playerTeam.setPlayer(new Player(scanner.nextLong(),"" ,"" ));
                scanner.next();
                playerTeam.setStartYear(scanner.nextInt());
                scanner.next();
                playerTeam.setEndYear(scanner.nextInt());
                insertPlayerTeam(playerTeam);
            }
        } catch (Exception e) {

        }
    }
    public void insertPlayer(Player player) {
        jdbcTemplate.update(SQL_INSERT_PLAYER, player.getId(), player.getName(), player.getCity());
    }

    public void insertTeam(Team team) {
        jdbcTemplate.update(SQL_INSERT_TEAM, team.getId(), team.getName(), team.getCity());
    }
    public void insertPlayerTeam(PlayerTeam playerTeam) {
        jdbcTemplate.update(SQL_INSERT_PLAYER_TEAM, playerTeam.getTeam().getId(), playerTeam.getPlayer().getId(),
                playerTeam.getStartYear(), playerTeam.getEndYear());
    }
}

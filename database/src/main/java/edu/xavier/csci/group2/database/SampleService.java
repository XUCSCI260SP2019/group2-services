package edu.xavier.csci.group2.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import edu.xavier.csci.group2.database.security.PasswordHash;

import java.util.List;

@Component
public class SampleService {
    private static final Logger log = LoggerFactory.getLogger(SampleService.class);

    JdbcTemplate jdbcTemplate;

    public SampleService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void insertSomeData() {
        Object[] params = {3, "test-event2" , 9, 10, 101};
        jdbcTemplate.update("INSERT INTO event(event_id, event_name, start_time, end_time, room_number) VALUES (?,?,?,?,?)",
                params);
    }

    public void register(int user_id, String username, String password){
        String hashedPass = PasswordHash.hashPassword(password);
        Object[] account_details = {user_id, username, hashedPass};
        User user = new User(user_id, username, hashedPass);
        jdbcTemplate.update("INSERT INTO user(user_id, user_name, password) VALUES (?,?,?)",
                account_details);
    }

    public Event[] getEvent(int timeslot) {
        Event[] ret = new Event[1];
        return (Event[]) jdbcTemplate.query(
        "SELECT * FROM event WHERE start_time NOT IN (SELECT DISTINCT start_time FROM event WHERE start_time = " + timeslot + ")",
                (rs, rowNum) -> new Event(rs.getInt("event_id"),
                        rs.getString("event_name"), rs.getInt("start_time"), rs.getInt("end_time"),
                        rs.getInt("room_number"))
        ).toArray(ret);
    }
}

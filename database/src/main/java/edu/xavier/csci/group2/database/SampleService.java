package edu.xavier.csci.group2.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SampleService {
    private static final Logger log = LoggerFactory.getLogger(SampleService.class);

    JdbcTemplate jdbcTemplate;

    public SampleService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


//    public void insertSomeData() {
//        Object[] params = {"Sample", "Service"};
//        jdbcTemplate.update("INSERT INTO customer(first_name, last_name) VALUES (?,?)",
//                params);
//    }

    public Event[] getEvent(int id) {
        Event[] ret = new Event[1];
        return (Event[]) jdbcTemplate.query(
                "SELECT event_id, event_name, start_time, end_time, room_number FROM event WHERE event_id = " + id,
                (rs, rowNum) -> new Event(rs.getInt("event_id"),
                        rs.getString("event_name"), rs.getInt("start_time"), rs.getInt("end_time"),
                        rs.getInt("room_number"))
        ).toArray(ret);
    }
}

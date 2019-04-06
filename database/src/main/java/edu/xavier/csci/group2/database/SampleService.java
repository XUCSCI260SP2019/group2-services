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


    public void insertSomeData() {
        Object[] params = {"Sample", "Service"};
        jdbcTemplate.update("INSERT INTO customer(first_name, last_name) VALUES (?,?)",
                params);
    }

    public Customer[] getCustomers() {
        Customer[] ret = new Customer[2];
        return (Customer[]) jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customer",
                (rs, rowNum) -> new Customer(rs.getLong("id"),
                        rs.getString("first_name"), rs.getString("last_name"))
        ).toArray(ret);
    }
}

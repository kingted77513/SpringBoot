package com.example.demo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleStudenRowMapper implements RowMapper<SimpleStudent> {
    @Override
    public SimpleStudent mapRow(ResultSet resultSet, int i) throws SQLException {
        SimpleStudent student = new SimpleStudent();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        return student;
    }
}

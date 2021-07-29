package com.example.demo.dao;

import com.example.demo.SimpleStudenRowMapper;
import com.example.demo.SimpleStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void insert(SimpleStudent student) {
        String sql = "INSERT INTO student(name) VALUE (:studentName)";

        Map<String, Object> map = new HashMap<>();
        map.put("studentName", student.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int id = keyHolder.getKey().intValue();

        System.out.println("run insert sql and id = " + id);
    }

    @Override
    public void insertList(List<SimpleStudent> students) {
        String sql = "INSERT INTO student(name) VALUE (:studentName)";

        Map<String, Object> map = new HashMap<>();

        MapSqlParameterSource[] mapSqlParameterSources = new MapSqlParameterSource[students.size()];

        for (int i = 0 ; i < students.size() ; i++) {
            SimpleStudent student = students.get(i);

            mapSqlParameterSources[i] = new MapSqlParameterSource();
            mapSqlParameterSources[i].addValue("studentName", student.getName());
        }

        namedParameterJdbcTemplate.batchUpdate(sql, mapSqlParameterSources);
    }

    @Override
    public void delete(Integer studentId) {
        String sql = "DELETE FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void update(SimpleStudent student) {
        String sql = "UPDATE student SET name=:studentName WHERE id=:studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", student.getId());
        map.put("studentName", student.getName());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public List<SimpleStudent> select() {
        String sql = "SELECT id, name FROM student";
        Map<String, Object> map = new HashMap<>();
        List<SimpleStudent> students = namedParameterJdbcTemplate.query(sql, map, new SimpleStudenRowMapper());
        return students;
    }

    @Override
    public SimpleStudent getById(Integer studentId) {
        String sql = "SELECT id, name FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        List<SimpleStudent> students = namedParameterJdbcTemplate.query(sql, map, new SimpleStudenRowMapper());

        Optional<List<SimpleStudent>> optionalSimpleStudents = Optional.of(students);

        return students.isEmpty() ? null : students.get(0);
    }
}

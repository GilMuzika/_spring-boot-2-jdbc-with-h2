package com.in28minutes.springboot.jdbc.h2.example.springboot2jdbcwithh2.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Student findById(long id) {
        return jdbcTemplate.queryForObject("select * from student where id=?", new BeanPropertyRowMapper<>(Student.class), id);
    }

    public List<Student> findAll() {
        return jdbcTemplate.query("SELECT * FROM student", new StudentRowMapper());
        //return jdbcTemplate.query("SELECT * FROM student", new BeanPropertyRowMapper<>(Student.class));
    }

    public void deleteById(long id) {
        jdbcTemplate.update("delete from student where id=?", id);
    }

    public int insert(Student student) {
        return jdbcTemplate.update("insert into student (id, name, passport_number) " + "values(?,  ?, ?)",
                student.getId(), student.getName(), student.getPassportNumber());
    }

    public int update(Student student) {
        return jdbcTemplate.update("update student " + " set name = ?, passport_number = ? " + " where id = ?",
                student.getName(), student.getPassportNumber(), student.getId());
    }
}

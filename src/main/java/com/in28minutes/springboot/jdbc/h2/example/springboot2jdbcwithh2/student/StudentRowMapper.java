package com.in28minutes.springboot.jdbc.h2.example.springboot2jdbcwithh2.student;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    /**
     * Implementations must implement this method to map each row of data in the
     * {@code ResultSet}. This method should not call {@code next()} on the
     * {@code ResultSet}; it is only supposed to map values of the current row.
     *
     * @param rs     the {@code ResultSet} to map (pre-initialized for the current row)
     * @param rowNum the number of the current row
     * @return the result object for the current row (may be {@code null})
     * @throws SQLException if an SQLException is encountered while getting
     *                      column values (that is, there's no need to catch SQLException)
     */
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getLong("id"));
        student.setName(rs.getString("name"));
        student.setPassportNumber(rs.getString("passport_number"));
        return student;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.models.Doctor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

/**
 *
 * @author vjratul
 */
public class DoctorDao extends Parent_Dao {

    public List<Doctor> getAll(String type) {
        String sql = "select * from doctor where specialist = :type";
        MapSqlParameterSource param = new MapSqlParameterSource("type", type);

        return template.query(sql, param, new RowMapper<Doctor>() {
            @Override
            public Doctor mapRow(ResultSet rs, int i) throws SQLException {

                Doctor doctor = new Doctor();

                doctor.setChamberAddress(rs.getString("chamberAddress"));
                doctor.setClosingDay(rs.getString("closingDay"));
                doctor.setDesignation(rs.getString("designation"));
                doctor.setEducationalBackground(rs.getString("educationalBackground"));
                doctor.setEmail(rs.getString("email"));
                doctor.setName(rs.getString("name"));
                doctor.setPatientCapacity(rs.getInt("patientCapacity"));
                doctor.setPhoneNumber(rs.getString("phoneNumber"));
                doctor.setVisitingFee(rs.getString("visitingFee"));
                doctor.setId(rs.getInt("id"));

                return doctor;
            }

        });
    }

    public void makeAppointment(int id) {

        String sql = "select occupied from doctor where id=:id";
        MapSqlParameterSource param = new MapSqlParameterSource("id", id);

        int alreadyOccupied = template.queryForObject(sql, param, Integer.class);

        sql = "update doctor set occupied=:occupied where id=:id";
        param.addValue("occupied", alreadyOccupied + 1);

        template.update(sql, param);
    }

    public int getMaxOccupied() {

        String sql = "select max(occupied) from doctor";
        MapSqlParameterSource param = new MapSqlParameterSource();

        return template.queryForObject(sql, param, Integer.class);

    }

    public String getNameFromId(int id) {

        String sql = "select name from doctor where id=:id";
        MapSqlParameterSource param = new MapSqlParameterSource("id", id);

        return template.queryForObject(sql, param, String.class);

    }

}

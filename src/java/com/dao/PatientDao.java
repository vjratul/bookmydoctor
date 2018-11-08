/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.models.Patient;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

/**
 *
 * @author vjratul
 */
public class PatientDao extends Parent_Dao {

    public void insert(Patient patient) {

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(patient);
        String sql = "insert into paitent(doctorName,patientName,phoneNumber,serialNumber) "
                + "values(:doctorName,:patientName,:phoneNumber,:serialNumber)";

        template.update(sql, param);

    }

    public List<Patient> getAll() {

        String sql = "select * from paitent";

        return template.query(sql, BeanPropertyRowMapper.newInstance(Patient.class));
    }

}

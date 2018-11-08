/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.dao.PatientDao;
import com.utils.GetBeans;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vjratul
 */
@Controller
public class Index {

    @RequestMapping(value = "findDoctor", method = RequestMethod.GET)
    public String doGET1() {
        return "find_doctor";
    }

    @RequestMapping(value = "showAllPatients", method = RequestMethod.GET)
    public String doGET2(Model model) {

        GetBeans<PatientDao> getBeansOne = new GetBeans<>();
        getBeansOne.setFileName("dbBean.xml");
        PatientDao daoTwo = getBeansOne.getBean("patientDao");

        model.addAttribute("showAllPatients", daoTwo.getAll());
        return "find_doctor";
    }

}

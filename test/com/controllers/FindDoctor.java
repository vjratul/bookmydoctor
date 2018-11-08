/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.dao.DoctorDao;
import com.utils.GetBeans;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vjratul
 */
@Controller
public class FindDoctor {

    @RequestMapping(value = "getDoctors", method = RequestMethod.GET)
    public String doGET1(@RequestParam("type") String type, Model model) {

        GetBeans<DoctorDao> getBeans = new GetBeans<>();
        getBeans.setFileName("dbBean.xml");
        DoctorDao dao = getBeans.getBean("doctorDao");

        model.addAttribute("doctorsByType", dao.getAll(type));
        return "find_doctor";

    }

    @RequestMapping(value = "doBooking", method = RequestMethod.GET)
    public String doGET2(@RequestParam("id") int id,
            Model model) {

        GetBeans<DoctorDao> getBeans = new GetBeans<>();
        getBeans.setFileName("dbBean.xml");
        DoctorDao dao = getBeans.getBean("doctorDao");

        dao.makeAppointment(id);
        model.addAttribute("bookingDone", "successful");
        model.addAttribute("showForm", "");
        model.addAttribute("id", id);

        return "find_doctor";
    }

}

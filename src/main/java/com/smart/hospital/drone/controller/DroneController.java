package com.smart.hospital.drone.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.smart.hospital.member.service.MemberService;
import com.smart.hospital.member.vo.MemberVO;
import java.util.*;

@Controller
public class DroneController {
	String stat = "0";
	
    @RequestMapping(value = "/drone", method = RequestMethod.GET)
    @ResponseBody
    public String droneStatus() {
        System.out.println("/drone get" + stat);
        
        return stat;
    }
    @RequestMapping(value = "/drone", method = RequestMethod.POST)
    @ResponseBody
    public String droneStat(HttpServletRequest httpServletRequest) {
        System.out.println("RequestMethod.POST");
        stat = httpServletRequest.getParameter("stat");
        System.out.println("stat : " + stat);
        return stat; 
    }
}

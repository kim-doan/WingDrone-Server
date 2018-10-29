package com.smart.hospital.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.hospital.member.service.MemberService;
import com.smart.hospital.member.vo.MemberVO;
import java.util.*;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 회원가입
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String signUp() {
        System.out.println("/register get");
        return "member/register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String signUp(MemberVO member) throws Exception {
        System.out.println("/register post");
        int result = memberService.insert(member);
        if(result == 1) { //성공
            return "1";
        } else {
            return "0";
        }
    }
    @RequestMapping(value = "/searchAccount", method = RequestMethod.POST)
    @ResponseBody
    public String searchAccount(@ModelAttribute MemberVO member) throws Exception {
    	MemberVO idcheck = memberService.accountProcess(member);
    	boolean result = memberService.checkAccount(member);
    	
    	System.out.println(result);
    	if(result == true) {
    		return "1";
    	} else {
    		return "0";
    	}
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@ModelAttribute MemberVO member) throws Exception {
    	MemberVO idcheck = memberService.loginProcess(member);
    	boolean result = memberService.loginCheck(member);
//    	System.out.println("== " + idcheck.getProtectorphone() + idcheck.getDevicecode() + idcheck.getAge());
    	System.out.println(result);
    	if(result == true) {
    		return "1" + "&" + idcheck.getId() + "&" + idcheck.getName() + "&" + idcheck.getPhone() + "&" + idcheck.getGrade();
    	} else {
    		return "0";
    	}
    }
    
    @RequestMapping(value = "/checkId")
    public @ResponseBody
    ResponseEntity<?> idCheck(MemberVO member, Model model) throws Exception {
        System.out.println(member.getId());

        HashMap result = new HashMap();
        result.put("1", 1);
        //return memberService.checkId(member);
        return new ResponseEntity<Map>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/memberList")
    public String memberList(Model model) throws Exception {
        List list = memberService.selectMemberList();

//        logger.info(list.toString());
        System.out.println("실행3");
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        model.addAttribute("list", list);

        return "/members/memberList";
    }
}

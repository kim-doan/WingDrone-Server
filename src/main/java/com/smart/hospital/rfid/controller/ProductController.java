package com.smart.hospital.rfid.controller;

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
import com.smart.hospital.rfid.service.ProductService;
import com.smart.hospital.rfid.vo.ProductVO;

import java.util.*;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	Stack<String> stack = new Stack<String>();
	List<String> list = new ArrayList<String>();
	String temp;
	int stat = 0;
	
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    @ResponseBody
    public String request() {
    	System.out.println("request.get");
    	if(!stack.isEmpty()) {
    		return stack.pop();
    	} else {
    		return "nil";
    	}
    }
    @RequestMapping(value = "/product"
    		, method = RequestMethod.POST)
    @ResponseBody
    public String productStat(HttpServletRequest httpServletRequest) throws Exception {
    	String str = httpServletRequest.getParameter("epc");
        System.out.println("ProductStat.POST" + str);
        String epc = str.substring(4, 14);
        System.out.println(epc);
        System.out.println(list.contains(epc));
        if(list.contains(epc) == false) { //list에서 epc값이 없다면
        	System.out.println("실행");
            list.add(epc); // list에 epc 추가
            ProductVO dbproduct = productService.productProcess(epc); // 조회
            String product = "1" + "&" + dbproduct.getId() + "&" + dbproduct.getName() + "&" + dbproduct.getAmount() + "&" + dbproduct.getInputDate() + "&" + dbproduct.getOutputDate();
            stack.push(product); // 그 네임 값을 스택에 저장
        }
        return "ok";
    }
    
    @RequestMapping(value = "/productadd", method = RequestMethod.POST)
    @ResponseBody
    public String signUp(ProductVO product) throws Exception {
        System.out.println("/productadd post");
        int result = productService.insert(product);
        if(result == 1) { //성공
            return "1";
        } else {
            return "0";
        }
    }
    
    @RequestMapping(value = "/productreload", method = RequestMethod.GET)
    @ResponseBody
    public void reload() {
    	System.out.println("reload.get"); 
    	list.clear();
    }
}

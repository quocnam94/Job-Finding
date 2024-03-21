package com.luv2code.springsecurity.demo.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.Recruitment;
import com.luv2code.springsecurity.demo.entity.Users;
import com.luv2code.springsecurity.demo.service.CompanyService;
import com.luv2code.springsecurity.demo.service.RecruitmentService;
import com.luv2code.springsecurity.demo.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private RecruitmentService recruitmentService;
	
//	show home page and featured information
	@GetMapping("/")
	public String showHome (@ModelAttribute("company") Company theCompany, 
			@ModelAttribute("recruitment") Recruitment theRecruitment, 
			@ModelAttribute("user") Users theUsers, 
			Model theModel) {
		int totalCompany = companyService.getTotalCompany();
		theModel.addAttribute("totalCompany", totalCompany);
		int totalRecruitment = recruitmentService.getTotalRecruitment();
		theModel.addAttribute("totalRecruitment", totalRecruitment);
		int totalUser = userService.getTotalUser();
		theModel.addAttribute("totalUser", totalUser);
		List<Map<String, Object>> theRecruitments = recruitmentService.topCategory();
		theModel.addAttribute("theRecruitments", theRecruitments);
		List<Map<String, Object>> theCompanies = companyService.topCompany();
		theModel.addAttribute("theCompanies", theCompanies);
		List<Recruitment> theTopRecruitments = recruitmentService.topJob();
		theModel.addAttribute("theTopRecruitments", theTopRecruitments);
		return "home";
	}
	
//	show the form to register
	@GetMapping("/register")
	public String register (Model theModel) {
		Users theUser = new Users();
		theModel.addAttribute("user", theUser);
		return "register";
	}
	
	@RequestMapping("/accessDenied")
	public String accessDenied () {
		return "access-denied";
	}
}

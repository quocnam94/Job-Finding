package com.luv2code.springsecurity.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springsecurity.demo.service.UserService;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

//	show login form
	@RequestMapping("/login")
	public String login () {
		return "login";
	}
	
//	show home page for each role
	@RequestMapping("/selectPageBasedOnRole")
    public String selectPageBasedOnRole(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().iterator().next().getAuthority();
        String userName = auth.getName();
        int userId = getUserIdByEmail(userName);
        if ("ROLE_USER".equals(role)) {
        	return "redirect:/homeUser?userId=" + userId;
        }
        else {
        	return "redirect:/homeCompany?userId=" + userId;
        }
    }
	
	private int getUserIdByEmail(String userName) {
		return userService.getUserIdByEmail(userName);
	}
}

package com.luv2code.springsecurity.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springsecurity.demo.entity.ApplyJob;
import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.Recruitment;
import com.luv2code.springsecurity.demo.entity.Users;
import com.luv2code.springsecurity.demo.service.ApplyJobService;
import com.luv2code.springsecurity.demo.service.CompanyService;
import com.luv2code.springsecurity.demo.service.RecruitmentService;
import com.luv2code.springsecurity.demo.service.UserService;

@Controller
public class CompanyController {

	@Autowired
	private UserService userService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private RecruitmentService recruitmentService;

	@Autowired
	private ApplyJobService applyJobService;

//	show home company
	@GetMapping("/homeCompany")
	public String showHomeCompany(@RequestParam("userId") int userId, Model theModel) {
		theModel.addAttribute("userId", userId);
		Company theCompany = companyService.getCompany(userId);
		theModel.addAttribute("company", theCompany);
		return "home-company";
	}

//	show the form to update the user
	@GetMapping("/updateProfileUserInCompany")
	public String updateProfileUserInCompany(@RequestParam("userId") int userId, Model theModel) {
		Users theUser = userService.getUser(userId);
		theModel.addAttribute("user", theUser);
		Company theCompany = companyService.getCompany(userId);
		theModel.addAttribute("company", theCompany);
		return "update-profile-user-in-company";
	}

//	logic to update user infor in company
	@PostMapping("/saveUserInCompany")
	public String saveUserInCompany(@Valid @ModelAttribute("user") Users theUser, BindingResult theBindingResult,
			Model theModel) {
		if (theBindingResult.hasErrors()) {
			return "update-profile-user-in-company";
		} else {
			userService.saveUser(theUser);
			theModel.addAttribute("message", "Bạn đã cập nhật thông tin thành công");
			theModel.addAttribute("user", theUser);
		}
		Company theCompany = companyService.getCompany(theUser.getId());
		theModel.addAttribute("company", theCompany);
		return "update-profile-user-in-company";
	}
	
// show the company if it exists and create a new one if it not
	@GetMapping("/showProfileCompany")
	public String showProfileCompany(@RequestParam("userId") int userId, Model theModel) {
		theModel.addAttribute("userId", userId);
		Company theCompany = companyService.getCompany(userId);
		boolean isNewCompany = (theCompany == null);
		if (isNewCompany) {
			theCompany = new Company();
		}
		theModel.addAttribute("company", theCompany);
		return "profile-company";
	}

	
	@GetMapping("/createCompany")
	public String createCompany(@RequestParam("userId") int userId, Model theModel) {
		Company theCompany = new Company();
		theModel.addAttribute("company", theCompany);
		theModel.addAttribute("userId", userId);
		return "create-company";
	}

	@GetMapping("/updateProfileCompany")
	public String updateProfileCompany(@RequestParam("userId") int userId, Model theModel) {
		Company theCompany = companyService.getCompany(userId);
		theModel.addAttribute("company", theCompany);
		Users theUser = userService.getUser(userId);
		theModel.addAttribute("user", theUser);
		return "update-profile-company";
	}

	@PostMapping("/saveCompany")
	public String saveCompany(@Valid @ModelAttribute("company") Company theCompany, BindingResult theBindingResult,
			@RequestParam("userId") int userId, Model theModel) {
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("userId", userId);
			return "create-company";
		} else {
			companyService.saveCompany(theCompany);
			theModel.addAttribute("message", "Bạn đã cập nhật thông tin thành công");
			theModel.addAttribute("userId", userId);
			return "create-company";
		}
	}

	@PostMapping("/saveCompanyUpdate")
	public String saveCompanyUpdate(@Valid @ModelAttribute("company") Company theCompany,
			BindingResult theBindingResult, @ModelAttribute("user") Users theUser, Model theModel) {
		if (theBindingResult.hasErrors()) {
			return "update-profile-company";
		} else {
			companyService.saveCompany(theCompany);
			theModel.addAttribute("message", "Bạn đã cập nhật thông tin thành công");
			return "update-profile-company";
		}
	}
	
	@GetMapping("/createJob")
	public String createJob(@RequestParam("userId") int userId, Model theModel) {
		Recruitment theRecruitment = new Recruitment();
		theModel.addAttribute("recruitment", theRecruitment);
		Users theUser = userService.getUser(userId);
		theModel.addAttribute("user", theUser);
		String nameCompany = companyService.getNameCompanyByUserId(userId);
		theModel.addAttribute("nameCompany", nameCompany);
		int idCompany = companyService.getIdCompanyByUserId(userId);
		theModel.addAttribute("idCompany", idCompany);
		return "create-job";
	}

	@PostMapping("/saveJob")
	public String saveJob(@Valid @ModelAttribute("recruitment") Recruitment theRecruitment,
			BindingResult theBindingResult, @RequestParam("userId") int userId, Model theModel) {
		if (theBindingResult.hasErrors()) {
			Users theUser = userService.getUser(userId);
			theModel.addAttribute("user", theUser);
			String nameCompany = companyService.getNameCompanyByUserId(userId);
			theModel.addAttribute("nameCompany", nameCompany);
			int idCompany = companyService.getIdCompanyByUserId(userId);
			theModel.addAttribute("idCompany", idCompany);
			return "create-job";
		} else {
			Users theUser = userService.getUser(userId);
			theModel.addAttribute("user", theUser);
			String nameCompany = companyService.getNameCompanyByUserId(userId);
			theModel.addAttribute("nameCompany", nameCompany);
			int idCompany = companyService.getIdCompanyByUserId(userId);
			theModel.addAttribute("idCompany", idCompany);
			recruitmentService.saveJob(theRecruitment);
			theModel.addAttribute("message", "Bạn đã tạo bài đăng thành công");
			return "create-job";
		}
	}

//	show the form to update the job
	@GetMapping("/updateJob")
	public String updateJob(@RequestParam("recruitmentId") int recruitmentId, @RequestParam("userId") int userId,
			Model theModel) {
		Recruitment theRecruitment = recruitmentService.getRecruitmentByRecruitmentId(recruitmentId);
		theModel.addAttribute("recruitment", theRecruitment);
		Users theUser = userService.getUser(userId);
		theModel.addAttribute("user", theUser);
		String nameCompany = companyService.getNameCompanyByUserId(userId);
		theModel.addAttribute("nameCompany", nameCompany);
		return "update-job";
	}

	@PostMapping("/saveJobUpdate")
	public String saveJobUpdate(@Valid @ModelAttribute("recruitment") Recruitment theRecruitment,
			BindingResult theBindingResult, @RequestParam("userId") int userId, Model theModel) {
		if (theBindingResult.hasErrors()) {
			Users theUser = userService.getUser(userId);
			theModel.addAttribute("user", theUser);
			String nameCompany = companyService.getNameCompanyByUserId(userId);
			theModel.addAttribute("nameCompany", nameCompany);
			return "update-job";
		} else {
			Users theUser = userService.getUser(userId);
			theModel.addAttribute("user", theUser);
			recruitmentService.saveJob(theRecruitment);
			theModel.addAttribute("message", "Bạn đã cập nhật thành công");
			return "update-job";
		}
	}

	@GetMapping("/deleteJob")
	public String deleteJob(@RequestParam("recruitmentId") int recruitmentId,
			@ModelAttribute("recruitment") Recruitment theRecruitment) {
		recruitmentService.deleteJob(recruitmentId);
		return "redirect:/listJob?userId=" + theRecruitment.getUserId();
	}
	
//	show detail job and list candidates applied in it
	@GetMapping("/detailJob")
	public String detailJob(@RequestParam("recruitmentId") int recruitmentId, @RequestParam("userId") int userId,
			Model theModel) {
		Recruitment theRecruitment = recruitmentService.getRecruitment(recruitmentId);
		theModel.addAttribute("recruitment", theRecruitment);
		Users theUser = userService.getUser(userId);
		theModel.addAttribute("user", theUser);
		List<ApplyJob> theApplyJob = applyJobService.getApplyJob(recruitmentId);
		List<Map<String, Object>> userJobInfoList = new ArrayList<>();
		for (ApplyJob applyJob : theApplyJob) {
			Map<String, Object> userJobInfo = new HashMap<>();
			userJobInfo.put("userName", applyJob.getUsers().getUserName());
			userJobInfo.put("fullName", applyJob.getUsers().getFullName());
			userJobInfo.put("phoneNumber", applyJob.getUsers().getPhoneNumber());
			userJobInfo.put("CV", applyJob.getFileName());
			userJobInfo.put("jobName", applyJob.getRecruitment().getTitle());
			userJobInfoList.add(userJobInfo);
		}
		theModel.addAttribute("userJobInfoList", userJobInfoList);
		return "detail-job";
	}

	@GetMapping("/listJob")
	public String listJob(@RequestParam("userId") int userId, @RequestParam(name = "page", defaultValue = "1") int page,
			Model theModel) {
		Users theUser = userService.getUser(userId);
		Page<Recruitment> recruitmentPage = recruitmentService.getRecruitments(userId, page, 5);
		String nameCompany = companyService.getNameCompanyByUserId(userId);
		theModel.addAttribute("nameCompany", nameCompany);
		theModel.addAttribute("user", theUser);
		theModel.addAttribute("recruitmentPage", recruitmentPage);
		return "list-job";
	}

	@GetMapping("/listCandidate")
	public String listCandidate(@RequestParam("userId") int userId, Model theModel) {
		Company theCompany = companyService.getCompany(userId);
		theModel.addAttribute("company", theCompany);
		List<Integer> theRecruitmentIds = recruitmentService.getRecruitmentIds(userId);
		List<ApplyJob> applyJobs = applyJobService.getApplyJobsByRecruitmentId(theRecruitmentIds);
		List<Map<String, Object>> userJobInfoList = new ArrayList<>();
		for (ApplyJob applyJob : applyJobs) {
			Map<String, Object> userJobInfo = new HashMap<>();
			userJobInfo.put("userName", applyJob.getUsers().getUserName());
			userJobInfo.put("fullName", applyJob.getUsers().getFullName());
			userJobInfo.put("phoneNumber", applyJob.getUsers().getPhoneNumber());
			userJobInfo.put("CV", applyJob.getFileName());
			userJobInfo.put("jobName", applyJob.getRecruitment().getTitle());
			userJobInfoList.add(userJobInfo);
		}
		theModel.addAttribute("userJobInfoList", userJobInfoList);
		return "list-candidate";
	}

}

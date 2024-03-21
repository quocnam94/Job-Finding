package com.luv2code.springsecurity.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.luv2code.springsecurity.demo.service.ApplyJobService;
import com.luv2code.springsecurity.demo.service.CompanyService;
import com.luv2code.springsecurity.demo.service.FileService;
import com.luv2code.springsecurity.demo.service.FollowCompanyService;
import com.luv2code.springsecurity.demo.service.FollowJobService;
import com.luv2code.springsecurity.demo.service.RecruitmentService;
import com.luv2code.springsecurity.demo.service.UserService;
import com.luv2code.springsecurity.demo.service.CVService;
import com.luv2code.springsecurity.demo.entity.ApplyJob;
import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.FollowCompany;
import com.luv2code.springsecurity.demo.entity.FollowJob;
import com.luv2code.springsecurity.demo.entity.Recruitment;
import com.luv2code.springsecurity.demo.entity.SignInDto;
import com.luv2code.springsecurity.demo.entity.Users;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private RecruitmentService recruitmentService;

	@Autowired
	private ApplyJobService applyJobService;

	@Autowired
	private CVService CVService;

	@Autowired
	private FollowJobService followJobService;
	
	@Autowired
	private FollowCompanyService followCompanyService;

	@Autowired
	private FileService fileService;

	@Autowired
	private PasswordEncoder passwordEncoder;

//	logic to register the new user
	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("user") SignInDto theSignInDto, BindingResult theBindingResult,
			Model theModel) {
		if (theBindingResult.hasErrors()) {
			return "register";
		} else {
			Users theUsers = new Users();
			theUsers.setUserName(theSignInDto.getUserName());
			theUsers.setFullName(theSignInDto.getFullName());
			String encodedPassword = passwordEncoder.encode(theSignInDto.getPassword());
			theUsers.setPassword(encodedPassword);
			theUsers.setMatchingPassword(theSignInDto.getMatchingPassword());
			theUsers.setEnabled(theSignInDto.isEnabled());
			theUsers.setRole(theSignInDto.getRole());
			theModel.addAttribute("message", "Bạn đã đăng ký thành công");
			userService.saveUser(theUsers);
			return "register";
		}
	}
//	show home page and featured information
	@GetMapping("/homeUser")
	public String showHomeUser(@RequestParam("userId") Integer userId, Model theModel) {
		theModel.addAttribute("userId", userId);
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
		Map<Integer, Boolean> statusMapJob = new HashMap<>();
		for (Recruitment recruitment : theTopRecruitments) {
			boolean status = followJobService.isFollowJob(recruitment.getId(), userId);
			statusMapJob.put(recruitment.getId(), status);
		}
		theModel.addAttribute("statusMapJob", statusMapJob);
		Map<Integer, Boolean> statusMapCompany = new HashMap<>();
		for (Map<String, Object> company : theCompanies) {
		    int companyId = (int) company.get("id");
		    boolean status = followCompanyService.isFollowCompany(companyId, userId);
		    statusMapCompany.put(companyId, status);
		}
		theModel.addAttribute("statusMapCompany", statusMapCompany);
		return "home-user";
	}
	
//	logic to follow and unfollow a company
	@GetMapping("/followCompany")
	private String followCompany(@RequestParam("userId") int userId, @RequestParam("companyId") int companyId,
			Model theModel) {
		String message = "";
		Users theUsers = userService.getUser(userId);
		Company theCompany = companyService.getCompanyByCompanyId(companyId);
		boolean status = followCompanyService.isFollowCompany(companyId, userId);
		FollowCompany followCompany = new FollowCompany();
		followCompany.setUsers(theUsers);
		followCompany.setCompany(theCompany);
		if (!status) {
			followCompanyService.saveFollowCompany(followCompany);
			message = "Bạn đã theo dõi công ty thành công";
		}
		theModel.addAttribute("message", message);
		return "forward:/homeUser?userId=" + userId;
	}

	@GetMapping("/unFollowCompany")
	private String unFollowCompany(@RequestParam("userId") int userId, @RequestParam("companyId") int companyId,
			Model theModel) {
		String message = "";
		Users theUsers = userService.getUser(userId);
		Company theCompany = companyService.getCompanyByCompanyId(companyId);
		boolean status = followCompanyService.isFollowCompany(companyId, userId);
		FollowCompany followCompany = new FollowCompany();
		followCompany.setUsers(theUsers);
		followCompany.setCompany(theCompany);
		if (status) {
			followCompanyService.unFollowCompany(followCompany);
			message = "Bạn đã bỏ theo dõi công ty thành công";
		}
		theModel.addAttribute("message", message);
		return "forward:/homeUser?userId=" + userId;
	}
	
//	logic to follow and unfollow a job
	@GetMapping("/followJob")
	private String followJob(@RequestParam("userId") int userId, @RequestParam("recruitmentId") int recruitmentId,
			Model theModel) {
		String message = "";
		Users theUsers = userService.getUser(userId);
		Recruitment theRecruitment = recruitmentService.getRecruitment(recruitmentId);
		boolean status = followJobService.isFollowJob(recruitmentId, userId);
		FollowJob followJob = new FollowJob();
		followJob.setUsers(theUsers);
		followJob.setRecruitment(theRecruitment);
		if (!status) {
			followJobService.saveFollowJob(followJob);
			message = "Bạn đã theo dõi công việc thành công";
		}
		theModel.addAttribute("message", message);
		return "forward:/homeUser?userId=" + userId;
	}

	@GetMapping("/unFollowJob")
	private String unFollowJob(@RequestParam("userId") int userId, @RequestParam("recruitmentId") int recruitmentId,
			Model theModel) {
		String message = "";
		Users theUsers = userService.getUser(userId);
		Recruitment theRecruitment = recruitmentService.getRecruitment(recruitmentId);
		boolean status = followJobService.isFollowJob(recruitmentId, userId);
		FollowJob followJob = new FollowJob();
		followJob.setUsers(theUsers);
		followJob.setRecruitment(theRecruitment);
		if (status) {
			followJobService.unFollowJob(followJob);
			message = "Bạn đã bỏ theo dõi công việc thành công";
		}
		theModel.addAttribute("message", message);
		return "forward:/homeUser?userId=" + userId;
	}

//	logic to search
	@GetMapping("/search")
	public String search(@RequestParam("theSearch") String theSearch, @RequestParam("userId") Integer userId,
			Model theModel) {
		List<Recruitment> theRecruitments = recruitmentService.search(theSearch);
		theModel.addAttribute("theRecruitments", theRecruitments);
		theModel.addAttribute("userId", userId);
		List<Company> theCompanies = companyService.search(theSearch);
		theModel.addAttribute("theCompanies", theCompanies);
		return "search";
	}

//	logic to show detail job and company in search result page
	@GetMapping("/detailJobInSearch")
	public String detailJobInSearch(@RequestParam("recruitmentId") int recruitmentId,
			@RequestParam("companyId") int companyId, @RequestParam("userId") Integer userId, Model theModel) {
		Recruitment theRecruitment = recruitmentService.getRecruitment(recruitmentId);
		theModel.addAttribute("recruitment", theRecruitment);
		theModel.addAttribute("userId", userId);
		List<Recruitment> theRecruitments = recruitmentService.getRecruitmentsByCompanyId(companyId);
		theModel.addAttribute("recruitments", theRecruitments);
		boolean status = followJobService.isFollowJob(theRecruitment.getId(), userId);
		theModel.addAttribute("status", status);
		boolean statusApply = applyJobService.isApplyJob(theRecruitment.getId(), userId);
		theModel.addAttribute("statusApply", statusApply);
		return "detail-job-in-search";
	}
	
	@GetMapping("/detailCompany")
	public String detailCompany(@RequestParam("userId") Integer userId,
			@RequestParam("companyId") int companyId, Model theModel) {
		theModel.addAttribute("userId", userId);
		Company theCompany = companyService.getCompanyByCompanyId(companyId);
		theModel.addAttribute("company", theCompany);
		boolean status = followCompanyService.isFollowCompany(companyId, userId);
		theModel.addAttribute("status", status);
		List<Recruitment> theRecruitments = recruitmentService.getRecruitmentsByCompanyId(companyId);
		theModel.addAttribute("recruitments", theRecruitments);
		return "detail-company-in-search";
	}

//	show the form to update the user
	@GetMapping("/updateProfileUser")
	public String updateProfileUser(@RequestParam("userId") int userId, Model theModel) {
		Users theUser = userService.getUser(userId);
		theModel.addAttribute("user", theUser);
		return "update-profile-user";
	}

	@GetMapping("/saveUpdateUser")
	public String saveUpdateUser(@Valid @ModelAttribute("user") Users theUser, BindingResult theBindingResult,
			Model theModel) {
		if (theBindingResult.hasErrors()) {
			return "update-profile-user";
		} else {
			userService.saveUser(theUser);
			theModel.addAttribute("messageUpdate", "Bạn đã cập nhật thông tin thành công");
			return "update-profile-user";
		}
	}

//	logic to save CV in profile user
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("userId") int userId,
			Model theModel) {
		String message = "";
		Users theUser = userService.getUser(userId);
		if (file.isEmpty()) {
			message = "Vui lòng chọn 1 file để upload.";
		} else if (!file.getContentType().equals(MediaType.APPLICATION_PDF_VALUE)) {
			message = "Vui lòng chỉ sử dụng file PDF.";
		} else {
			fileService.save(file, userId);
			message = "Bạn đã cập nhật thành công CV " + file.getOriginalFilename() + ".";
		}
		theModel.addAttribute("message", message);
		theModel.addAttribute("user", theUser);
		return "update-profile-user";
	}

	@GetMapping("/applyJob")
	public String applyJob(@RequestParam("recruitmentId") int recruitmentId, @RequestParam("userId") int userId,
			Model theModel) {
		ApplyJob applyJob = new ApplyJob();
		theModel.addAttribute("applyJob", applyJob);
		Users theUsers = userService.getUser(userId);
		theModel.addAttribute("user", theUsers);
		Recruitment theRecruitment = recruitmentService.getRecruitment(recruitmentId);
		theModel.addAttribute("recruitment", theRecruitment);
		return "detail-job-in-user";
	}

//	logic to apply and upload CV in a job detail
	@PostMapping("/saveApplyJob")
	public String saveApplyJob(@RequestParam("recruitmentId") int recruitmentId, @RequestParam("userId") int userId,
			@RequestParam("file") MultipartFile file, @RequestParam("submissionType") String submissionType,
			@ModelAttribute("applyJob") ApplyJob theApplyJob, Model theModel) {
		String message = "";
		Users theUsers = userService.getUser(userId);
		Recruitment theRecruitment = recruitmentService.getRecruitment(recruitmentId);
		theApplyJob.setRecruitment(theRecruitment);
		theApplyJob.setUsers(theUsers);
		if ("update".equals(submissionType) && CVService.isExistCV(userId)) {
			String nameCV = CVService.getNameCVByUserId(userId);
			message = "Bạn đã gửi thành công CV " + nameCV + ".";
			theApplyJob.setFileName(nameCV);
			applyJobService.saveApplyJob(theApplyJob);
		}
		if ("update".equals(submissionType) && !CVService.isExistCV(userId)) {
			message = "Bạn chưa có CV nào.";
		}
		if ("new".equals(submissionType)) {
			if (file.isEmpty()) {
				message = "Vui lòng chọn 1 file để upload.";
			} else if (!file.getContentType().equals(MediaType.APPLICATION_PDF_VALUE)) {
				message = "Vui lòng chỉ sử dụng file PDF.";
			} else {
				theApplyJob.setFileName(file.getOriginalFilename());
				applyJobService.saveApplyJob(theApplyJob);
				message = "Bạn đã gửi thành công CV " + file.getOriginalFilename() + ".";
			}
		}
		theModel.addAttribute("message", message);
		theModel.addAttribute("recruitment", theRecruitment);
		theModel.addAttribute("user", theUsers);
		return "detail-job-in-user";
	}
	
	@GetMapping("/listJobFollowed")
	public String listJobFollowed (@RequestParam("userId") int userId, Model theModel) {
		List<Recruitment> theRecruitments = recruitmentService.getRecruitmentsFollowed(userId);
		theModel.addAttribute("theRecruitments", theRecruitments);
		theModel.addAttribute("userId", userId);
		Map<Integer, Boolean> statusMapJob = new HashMap<>();
		for (Recruitment recruitment : theRecruitments) {
			boolean status = followJobService.isFollowJob(recruitment.getId(), userId);
			statusMapJob.put(recruitment.getId(), status);
		}
		theModel.addAttribute("statusMapJob", statusMapJob);
		return "list-job-followed";
	}
	
	@GetMapping("/listJobApplied")
	public String listJobApplied (@RequestParam("userId") int userId, Model theModel) {
		List<Recruitment> theRecruitments = recruitmentService.getRecruitmentsApplied(userId);
		theModel.addAttribute("theRecruitments", theRecruitments);
		theModel.addAttribute("userId", userId);
		return "list-job-applied";
	}
	
	@GetMapping("/listCompanyFollowed")
	public String listCompanyFollowed (@RequestParam("userId") int userId, Model theModel) {
		List<Company> theCompanies = companyService.getCompanyFollowed(userId);
		theModel.addAttribute("theCompanies", theCompanies);
		theModel.addAttribute("userId", userId);
		Map<Integer, Boolean> statusMapCompany = new HashMap<>();
		for (Company company : theCompanies) {
		    int companyId = company.getId();
		    boolean status = followCompanyService.isFollowCompany(companyId, userId);
		    statusMapCompany.put(companyId, status);
		}
		theModel.addAttribute("statusMapCompany", statusMapCompany);
		return "list-company-followed";
	}

}

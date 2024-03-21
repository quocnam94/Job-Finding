package com.luv2code.springsecurity.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springsecurity.demo.validation.PhoneNumber;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "description")
	private String description;
	
	@NotNull(message = "bắt buộc")
	@Size(min=1, message = "bắt buộc")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+\\.[A-Za-z0-9-]{2,253}$", message = "Email không hợp lệ")
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "matching_password")
	private String matchingPassword;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "image")
	private String image;
	
	@PhoneNumber
	@Pattern(regexp = "[0-9]{10}", message = "phải gồm 10 số")
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "role")
	private String role;
	
	@OneToMany(mappedBy = "users", 
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Recruitment>recruitments;
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<ApplyJob> applyJobs;	
	
	public Users() {
	}

	public Users(String address, String description, String userName, String password, String matchingPassword,
			boolean enabled, String fullName, String image,
			String phoneNumber, String role,
			List<Recruitment> recruitments) {
		super();
		this.address = address;
		this.description = description;
		this.userName = userName;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.enabled = enabled;
		this.fullName = fullName;
		this.image = image;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.recruitments = recruitments;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public List<Recruitment> getRecruitments() {
		return recruitments;
	}

	public void setRecruitments(List<Recruitment> recruitments) {
		this.recruitments = recruitments;
	}

}

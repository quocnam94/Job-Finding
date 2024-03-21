package com.luv2code.springsecurity.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springsecurity.demo.validation.PhoneNumber;

@Entity
@Table(name = "company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotNull(message = "bắt buộc")
	@Size(min=1, message = "bắt buộc")
	@Column(name = "address")
	private String address;
	
	@Column(name = "description")
	private String description;
	
	@NotNull(message = "bắt buộc")
	@Size(min=1, message = "bắt buộc")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+\\.[A-Za-z0-9-]{2,253}$", message = "Email không hợp lệ")
	@Column(name = "email")
	private String email;
	
	@Column(name = "logo")
	private String logo;
	
	@NotNull(message = "bắt buộc")
	@Size(min=1, message = "bắt buộc")
	@Column(name = "name_company")
	private String nameCompany;
	
	@PhoneNumber
	@Pattern(regexp = "[0-9]{10}", message = "phải gồm 10 số")
	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "user_id")
	public Integer userId;
	
	public Company() {
		
	}

	public Company(String address, String description,
			String email,
			String logo, String nameCompany,
			String phoneNumber, Integer userId) {
		this.address = address;
		this.description = description;
		this.email = email;
		this.logo = logo;
		this.nameCompany = nameCompany;
		this.phoneNumber = phoneNumber;
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}

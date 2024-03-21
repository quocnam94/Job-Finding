package com.luv2code.springsecurity.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "apply_job")
public class ApplyJob {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "text")
	private String text;

	@ManyToOne()
	@JoinColumn(name = "recruitment_id")
	private Recruitment recruitment;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private Users users;
	
	public ApplyJob() {

	}

public ApplyJob(String fileName, String text, Recruitment recruitment, Users users) {
		this.fileName = fileName;
		this.text = text;
		this.recruitment = recruitment;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Recruitment getRecruitment() {
		return recruitment;
	}

	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}

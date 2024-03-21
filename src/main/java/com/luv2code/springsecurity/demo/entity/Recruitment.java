package com.luv2code.springsecurity.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "recruitment")
public class Recruitment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@NotNull(message = "bắt buộc")
	@Size(min=1, message = "bắt buộc")
	@Column(name = "title")
	private String title;
	
	@NotNull(message = "bắt buộc")
	@Size(min=1, message = "bắt buộc")
	@Column(name = "description")
	private String description;
	
	@NotNull(message = "bắt buộc")
	@Size(min=1, message = "bắt buộc")
	@Column(name = "exp")
	private String exp;
	
	@NotNull(message = "bắt buộc")
    @Min(value = 1, message = "Số lượng phải lớn hơn 0")
	@Column(name = "quantity")
	private Integer quantity;
	
	@NotNull(message = "bắt buộc")
	@Size(min=1, message = "bắt buộc")
	@Column(name = "address")
	private String address;
	
	@NotNull(message = "bắt buộc")
	@Size(min=1, message = "bắt buộc")
	@Pattern(regexp = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(19|20)\\d\\d$", message = "phải theo định dạng mm/dd/yyyy")
	@Column(name = "deadline")
	private String deadline;
	
	@NotNull(message = "bắt buộc")
    @Min(value = 1, message = "Mức lương phải lớn hơn 0")
	@Column(name = "salary")
	private Double salary;
	
	@Column(name = "job_type")
	private String jobType;
	
	@Column(name = "job_category")
	private String jobCategory;
	
	@Column(name = "name_company")
	private String nameCompany;
	
	@Column(name = "id_company")
	private Integer idCompany;
	
	@Column(name = "user_id")
	private int userId;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private Users users;
	
	@OneToMany(mappedBy = "recruitment", cascade = CascadeType.ALL)
	private List<ApplyJob> applyJobs;	
	
	@OneToMany(mappedBy = "recruitment")
    private List<FollowJob> followJobs;
	
	public Recruitment() {
	}

	public Recruitment(@NotNull(message = "is required") @Size(min = 1, message = "is required") String title,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String description,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String exp,
			@NotNull(message = "is required") @Min(value = 1, message = "Số lượng phải lớn hơn hoặc bằng 1") Integer quantity,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String address,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") @Pattern(regexp = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(19|20)\\d\\d$", message = "must follow format mm/dd/yyyy") String deadline,
			@NotNull(message = "is required") @Min(value = 0, message = "Mức lương phải lớn hơn 0") Double salary,
			String jobType, String jobCategory, String nameCompany, Integer idCompany, int userId, Users users,
			List<ApplyJob> applyJobs) {
		super();
		this.title = title;
		this.description = description;
		this.exp = exp;
		this.quantity = quantity;
		this.address = address;
		this.deadline = deadline;
		this.salary = salary;
		this.jobType = jobType;
		this.jobCategory = jobCategory;
		this.nameCompany = nameCompany;
		this.idCompany = idCompany;
		this.userId = userId;
		this.users = users;
		this.applyJobs = applyJobs;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public Integer getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Integer idCompany) {
		this.idCompany = idCompany;
	}

	public List<ApplyJob> getApplyJobs() {
		return applyJobs;
	}

	public void setApplyJobs(List<ApplyJob> applyJobs) {
		this.applyJobs = applyJobs;
	}
	
}

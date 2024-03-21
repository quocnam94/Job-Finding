package com.luv2code.springsecurity.demo.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springsecurity.demo.validation.FieldMatch;

@FieldMatch.List({
	 @FieldMatch(first = "password", second = "matchingPassword", message = "Mật khẩu chưa trùng khớp")
})
public class SignInDto {
	
	@NotNull(message = "bắt buộc")
	@Size(min=1, message = "bắt buộc")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+\\.[A-Za-z0-9-]{2,253}$", message = "Email sai định dạng")
	private String userName;
	
	@NotNull(message = "bắt buộc")
	@Size(min=1, message = "bắt buộc")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W).{8,}$", message = "Mật khẩu chưa đủ mạnh")
	private String password;
	
	@NotNull(message = "bắt buộc")
	@Size(min=1, message = "bắt buộc")
	private String matchingPassword;
	
	private boolean enabled;
	
	@NotNull(message = "bắt buộc")
	@Size(min=1, message = "bắt buộc")
	private String fullName;
	
	private String role;

	public SignInDto() {
	}
	
	public SignInDto(int companyId, int usersId,
			String userName,
			String password,
			String matchingPassword,
			boolean enabled, String fullName,
			String role, Company company) {
		this.userName = userName;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.enabled = enabled;
		this.fullName = fullName;
		this.role = role;
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

	@Override
	public String toString() {
		return "UsersDto [userName=" + userName + ", password=" + password + ", matchingPassword=" + matchingPassword
				+ ", enabled=" + enabled + ", fullName=" + fullName + ", role=" + role + "]";
	}

}

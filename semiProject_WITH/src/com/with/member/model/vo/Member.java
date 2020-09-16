package com.with.member.model.vo;

import java.util.Date;

public class Member {
	private String id;
	private String password;
	private String nickname;
	private String grade;
	private String gender;
	private String birth;
	private String phone;
	private String email;
	private String address;
	private Date enrolldate;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String password, String nickname, String grade, String gender, String birth, String phone,
			String email, String address, Date enrolldate) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.grade = grade;
		this.gender = gender;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.enrolldate = enrolldate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEnrolldate() {
		return enrolldate;
	}

	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", nickname=" + nickname + ", grade=" + grade
				+ ", gender=" + gender + ", birth=" + birth + ", phone=" + phone + ", email=" + email + ", address="
				+ address + ", enrolldate=" + enrolldate + "]";
	}
	
	
}

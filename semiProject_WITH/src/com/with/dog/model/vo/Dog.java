package com.with.dog.model.vo;

public class Dog {
	
	private int dogIdx;
	private String dogOwner;
	private String dogName;
	private String dogGender;
	private String dogBreed;
	private String dogBirth;
	private String dogNeuter;
	private String dogStatus;
	private String dogProfile;
	
	public Dog() {
		// TODO Auto-generated constructor stub
	}

	public Dog(int dogIdx, String dogOwner, String dogName, String dogGender, String dogBreed, String dogBirth,
			String dogNeuter, String dogStatus, String dogProfile) {
		super();
		this.dogIdx = dogIdx;
		this.dogOwner = dogOwner;
		this.dogName = dogName;
		this.dogGender = dogGender;
		this.dogBreed = dogBreed;
		this.dogBirth = dogBirth;
		this.dogNeuter = dogNeuter;
		this.dogStatus = dogStatus;
		this.dogProfile = dogProfile;
	}

	public int getDogIdx() {
		return dogIdx;
	}

	public void setDogIdx(int dogIdx) {
		this.dogIdx = dogIdx;
	}

	public String getDogOwner() {
		return dogOwner;
	}

	public void setDogOwner(String dogOwner) {
		this.dogOwner = dogOwner;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getDogGender() {
		return dogGender;
	}

	public void setDogGender(String dogGender) {
		this.dogGender = dogGender;
	}

	public String getDogBreed() {
		return dogBreed;
	}

	public void setDogBreed(String dogBreed) {
		this.dogBreed = dogBreed;
	}

	public String getDogBirth() {
		return dogBirth;
	}

	public void setDogBirth(String dogBirth) {
		this.dogBirth = dogBirth;
	}

	public String getDogNeuter() {
		return dogNeuter;
	}

	public void setDogNeuter(String dogNeuter) {
		this.dogNeuter = dogNeuter;
	}

	public String getDogStatus() {
		return dogStatus;
	}

	public void setDogStatus(String dogStatus) {
		this.dogStatus = dogStatus;
	}

	public String getDogProfile() {
		return dogProfile;
	}

	public void setDogProfile(String dogProfile) {
		this.dogProfile = dogProfile;
	}

	@Override
	public String toString() {
		return "Dog [dogIdx=" + dogIdx + ", dogOwner=" + dogOwner + ", dogName=" + dogName + ", dogGender=" + dogGender
				+ ", dogBreed=" + dogBreed + ", dogBirth=" + dogBirth + ", dogNeuter=" + dogNeuter + ", dogStatus="
				+ dogStatus + ", dogProfile=" + dogProfile + "]";
	}
	
	
	
	

}

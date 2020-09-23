package com.with.dog.model.vo;

public class Dog {
	
	private int dogIdx;
	private String dogOwner;
	private String dogName;
	private String dogGender;
	private String dogBreed1;
	private String dogBreed2;
	private double dogWeight;
	private String dogBirth;
	private String dogNeuter;
	private String dogStatus;
	private String dogProfile;
	
	public Dog() {
		// TODO Auto-generated constructor stub
	}

	public Dog(int dogIdx, String dogOwner, String dogName, String dogGender, String dogBreed1, String dogBreed2,
			double dogWeight, String dogBirth, String dogNeuter, String dogStatus, String dogProfile) {
		super();
		this.dogIdx = dogIdx;
		this.dogOwner = dogOwner;
		this.dogName = dogName;
		this.dogGender = dogGender;
		this.dogBreed1 = dogBreed1;
		this.dogBreed2 = dogBreed2;
		this.dogWeight = dogWeight;
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

	public String getDogBreed1() {
		return dogBreed1;
	}

	public void setDogBreed1(String dogBreed1) {
		this.dogBreed1 = dogBreed1;
	}

	public String getDogBreed2() {
		return dogBreed2;
	}

	public void setDogBreed2(String dogBreed2) {
		this.dogBreed2 = dogBreed2;
	}

	public double getDogWeight() {
		return dogWeight;
	}

	public void setDogWeight(double dogWeight) {
		this.dogWeight = dogWeight;
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
				+ ", dogBreed1=" + dogBreed1 + ", dogBreed2=" + dogBreed2 + ", dogWeight=" + dogWeight + ", dogBirth="
				+ dogBirth + ", dogNeuter=" + dogNeuter + ", dogStatus=" + dogStatus + ", dogProfile=" + dogProfile
				+ "]";
	}
	
	
	
}
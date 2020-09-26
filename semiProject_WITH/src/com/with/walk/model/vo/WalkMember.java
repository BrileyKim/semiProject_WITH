package com.with.walk.model.vo;

public class WalkMember {
	private int walkMemberNo;
	private int walkNo;
	private String walkId;
	private String walkGrade;
	private String walkEnrolldate;
	
	
	public WalkMember() {
		// TODO Auto-generated constructor stub
	}


	public WalkMember(int walkMemberNo, int walkNo, String walkId, String walkGrade, String walkEnrolldate) {
		super();
		this.walkMemberNo = walkMemberNo;
		this.walkNo = walkNo;
		this.walkId = walkId;
		this.walkGrade = walkGrade;
		this.walkEnrolldate = walkEnrolldate;
	}


	public int getWalkMemberNo() {
		return walkMemberNo;
	}


	public void setWalkMemberNo(int walkMemberNo) {
		this.walkMemberNo = walkMemberNo;
	}


	public int getWalkNo() {
		return walkNo;
	}


	public void setWalkNo(int walkNo) {
		this.walkNo = walkNo;
	}


	public String getWalkId() {
		return walkId;
	}


	public void setWalkId(String walkId) {
		this.walkId = walkId;
	}


	public String getWalkGrade() {
		return walkGrade;
	}


	public void setWalkGrade(String walkGrade) {
		this.walkGrade = walkGrade;
	}


	public String getWalkEnrolldate() {
		return walkEnrolldate;
	}


	public void setWalkEnrolldate(String walkEnrolldate) {
		this.walkEnrolldate = walkEnrolldate;
	}


	@Override
	public String toString() {
		return "WalkMember [walkMemberNo=" + walkMemberNo + ", walkNo=" + walkNo + ", walkId=" + walkId + ", walkGrade="
				+ walkGrade + ", walkEnrolldate=" + walkEnrolldate + "]";
	}
	
	
	
}

package com.with.meet.model.vo;

import java.sql.Date;

public class MeetMember {

	private int meetMemberIdx;
	private String meetMembertitle;
	private int meetIdx;
	private String meetMemberId;
	private String meetMemberGrade;
	private Date meetenrolldate;
	
	public MeetMember() {
		// TODO Auto-generated constructor stub
	}

	public MeetMember(int meetMemberIdx, String meetMembertitle, int meetIdx, String meetMemberId,
			String meetMemberGrade, Date meetenrolldate) {
		super();
		this.meetMemberIdx = meetMemberIdx;
		this.meetMembertitle = meetMembertitle;
		this.meetIdx = meetIdx;
		this.meetMemberId = meetMemberId;
		this.meetMemberGrade = meetMemberGrade;
		this.meetenrolldate = meetenrolldate;
	}

	public int getMeetMemberIdx() {
		return meetMemberIdx;
	}

	public void setMeetMemberIdx(int meetMemberIdx) {
		this.meetMemberIdx = meetMemberIdx;
	}

	public String getMeetMembertitle() {
		return meetMembertitle;
	}

	public void setMeetMembertitle(String meetMembertitle) {
		this.meetMembertitle = meetMembertitle;
	}

	public int getMeetIdx() {
		return meetIdx;
	}

	public void setMeetIdx(int meetIdx) {
		this.meetIdx = meetIdx;
	}

	public String getMeetMemberId() {
		return meetMemberId;
	}

	public void setMeetMemberId(String meetMemberId) {
		this.meetMemberId = meetMemberId;
	}

	public String getMeetMemberGrade() {
		return meetMemberGrade;
	}

	public void setMeetMemberGrade(String meetMemberGrade) {
		this.meetMemberGrade = meetMemberGrade;
	}

	public Date getMeetenrolldate() {
		return meetenrolldate;
	}

	public void setMeetenrolldate(Date meetenrolldate) {
		this.meetenrolldate = meetenrolldate;
	}

	@Override
	public String toString() {
		return "MeetMember [meetMemberIdx=" + meetMemberIdx + ", meetMembertitle=" + meetMembertitle + ", meetIdx="
				+ meetIdx + ", meetMemberId=" + meetMemberId + ", meetMemberGrade=" + meetMemberGrade
				+ ", meetenrolldate=" + meetenrolldate + "]";
	}
	
	
	
	
	
	

	
	
	
	
	
	
}

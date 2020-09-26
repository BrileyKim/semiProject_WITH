package com.with.walk.model.vo;

import java.sql.Date;

public class Walk {
	
	private int walkNo;
	private int walkMeetIdx;
	private String walkWriter;
	private String walkTitle;
	private int walkHeadCount;
	private String walkDate;
	private int walkHour;
	private int walkMinute;
	private String walkContent;
	private int walkReadcount;
	private Date walkEnrolldate;
	
	public Walk() {
		// TODO Auto-generated constructor stub
	}

	public Walk(int walkNo, int walkMeetIdx, String walkWriter, String walkTitle, int walkHeadCount, String walkDate,
			int walkHour, int walkMinute, String walkContent, int walkReadcount, Date walkEnrolldate) {
		super();
		this.walkNo = walkNo;
		this.walkMeetIdx = walkMeetIdx;
		this.walkWriter = walkWriter;
		this.walkTitle = walkTitle;
		this.walkHeadCount = walkHeadCount;
		this.walkDate = walkDate;
		this.walkHour = walkHour;
		this.walkMinute = walkMinute;
		this.walkContent = walkContent;
		this.walkReadcount = walkReadcount;
		this.walkEnrolldate = walkEnrolldate;
	}

	public int getWalkNo() {
		return walkNo;
	}

	public void setWalkNo(int walkNo) {
		this.walkNo = walkNo;
	}

	public int getWalkMeetIdx() {
		return walkMeetIdx;
	}

	public void setWalkMeetIdx(int walkMeetIdx) {
		this.walkMeetIdx = walkMeetIdx;
	}

	public String getWalkWriter() {
		return walkWriter;
	}

	public void setWalkWriter(String walkWriter) {
		this.walkWriter = walkWriter;
	}

	public String getWalkTitle() {
		return walkTitle;
	}

	public void setWalkTitle(String walkTitle) {
		this.walkTitle = walkTitle;
	}

	public int getWalkHeadCount() {
		return walkHeadCount;
	}

	public void setWalkHeadCount(int walkHeadCount) {
		this.walkHeadCount = walkHeadCount;
	}

	public String getWalkDate() {
		return walkDate;
	}

	public void setWalkDate(String walkDate) {
		this.walkDate = walkDate;
	}

	public int getWalkHour() {
		return walkHour;
	}

	public void setWalkHour(int walkHour) {
		this.walkHour = walkHour;
	}

	public int getWalkMinute() {
		return walkMinute;
	}

	public void setWalkMinute(int walkMinute) {
		this.walkMinute = walkMinute;
	}

	public String getWalkContent() {
		return walkContent;
	}

	public void setWalkContent(String walkContent) {
		this.walkContent = walkContent;
	}

	public int getWalkReadcount() {
		return walkReadcount;
	}

	public void setWalkReadcount(int walkReadcount) {
		this.walkReadcount = walkReadcount;
	}

	public Date getWalkEnrolldate() {
		return walkEnrolldate;
	}

	public void setWalkEnrolldate(Date walkEnrolldate) {
		this.walkEnrolldate = walkEnrolldate;
	}

	@Override
	public String toString() {
		return "Walk [walkNo=" + walkNo + ", walkMeetIdx=" + walkMeetIdx + ", walkWriter=" + walkWriter + ", walkTitle="
				+ walkTitle + ", walkHeadCount=" + walkHeadCount + ", walkDate=" + walkDate + ", walkHour=" + walkHour
				+ ", walkMinute=" + walkMinute + ", walkContent=" + walkContent + ", walkReadcount=" + walkReadcount
				+ ", walkEnrolldate=" + walkEnrolldate + "]";
	}
	
	

}

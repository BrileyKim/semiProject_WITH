package com.with.meet.model.vo;

import java.sql.Date;

public class Meet {
	
	private int idx;
	private String title;
	private String leader;
	private int headCount;
	private String content;
	private String frontOrigin;
	private String frontRename;
	private String backOrigin;
	private String backRename;
	private Date createDate;
	
	public Meet() {
		// TODO Auto-generated constructor stub
	}

	public Meet(int idx, String title, String leader, int headCount, String content, String frontOrigin,
			String frontRename, String backOrigin, String backRename, Date createDate) {
		super();
		this.idx = idx;
		this.title = title;
		this.leader = leader;
		this.headCount = headCount;
		this.content = content;
		this.frontOrigin = frontOrigin;
		this.frontRename = frontRename;
		this.backOrigin = backOrigin;
		this.backRename = backRename;
		this.createDate = createDate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public int getHeadCount() {
		return headCount;
	}

	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFrontOrigin() {
		return frontOrigin;
	}

	public void setFrontOrigin(String frontOrigin) {
		this.frontOrigin = frontOrigin;
	}

	public String getFrontRename() {
		return frontRename;
	}

	public void setFrontRename(String frontRename) {
		this.frontRename = frontRename;
	}

	public String getBackOrigin() {
		return backOrigin;
	}

	public void setBackOrigin(String backOrigin) {
		this.backOrigin = backOrigin;
	}

	public String getBackRename() {
		return backRename;
	}

	public void setBackRename(String backRename) {
		this.backRename = backRename;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Meet [idx=" + idx + ", title=" + title + ", leader=" + leader + ", headCount=" + headCount
				+ ", content=" + content + ", frontOrigin=" + frontOrigin + ", frontRename=" + frontRename
				+ ", backOrigin=" + backOrigin + ", backRename=" + backRename + ", createDate=" + createDate + "]";
	}
	
	

}

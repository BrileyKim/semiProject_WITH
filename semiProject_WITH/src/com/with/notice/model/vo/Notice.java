package com.with.notice.model.vo;

import java.sql.Date;

public class Notice {
	
	private int noticeIdx;
	private String noticeTitle;
	private String noticeWriter;
	private String noticeContent;
	private String noticeOriginalFileName;
	private String noticeRenamedFileName;
	private Date noticeEnrollDate;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int noticeIdx, String noticeTitle, String noticeWriter, String noticeContent,
			String noticeOriginalFileName, String noticeRenamedFileName, Date noticeEnrollDate) {
		super();
		this.noticeIdx = noticeIdx;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeContent = noticeContent;
		this.noticeOriginalFileName = noticeOriginalFileName;
		this.noticeRenamedFileName = noticeRenamedFileName;
		this.noticeEnrollDate = noticeEnrollDate;
	}

	public int getNoticeIdx() {
		return noticeIdx;
	}

	public void setNoticeIdx(int noticeIdx) {
		this.noticeIdx = noticeIdx;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeOriginalFileName() {
		return noticeOriginalFileName;
	}

	public void setNoticeOriginalFileName(String noticeOriginalFileName) {
		this.noticeOriginalFileName = noticeOriginalFileName;
	}

	public String getNoticeRenamedFileName() {
		return noticeRenamedFileName;
	}

	public void setNoticeRenamedFileName(String noticeRenamedFileName) {
		this.noticeRenamedFileName = noticeRenamedFileName;
	}

	public Date getNoticeEnrollDate() {
		return noticeEnrollDate;
	}

	public void setNoticeEnrollDate(Date noticeEnrollDate) {
		this.noticeEnrollDate = noticeEnrollDate;
	}

	@Override
	public String toString() {
		return "Notice [noticeIdx=" + noticeIdx + ", noticeTitle=" + noticeTitle + ", noticeWriter=" + noticeWriter
				+ ", noticeContent=" + noticeContent + ", noticeOriginalFileName=" + noticeOriginalFileName
				+ ", noticeRenamedFileName=" + noticeRenamedFileName + ", noticeEnrollDate=" + noticeEnrollDate + "]";
	}
	
	
	

}

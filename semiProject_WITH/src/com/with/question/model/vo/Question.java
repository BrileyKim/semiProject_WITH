package com.with.question.model.vo;

import java.sql.Date;

public class Question {
	
	private int questionIdx;
	private String questionWriter;
	private String questionTitle;
	private String questionContent;
	private String questionOriginalFilename;
	private String questionRenamedFilename;
	private Date questionEnrollDate;
	private int questionReadCount;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}

	public Question(int questionIdx, String questionWriter, String questionTitle, String questionContent,
			String questionOriginalFilename, String questionRenamedFilename, Date questionEnrollDate,
			int questionReadCount) {
		super();
		this.questionIdx = questionIdx;
		this.questionWriter = questionWriter;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.questionOriginalFilename = questionOriginalFilename;
		this.questionRenamedFilename = questionRenamedFilename;
		this.questionEnrollDate = questionEnrollDate;
		this.questionReadCount = questionReadCount;
	}

	public int getQuestionIdx() {
		return questionIdx;
	}

	public void setQuestionIdx(int questionIdx) {
		this.questionIdx = questionIdx;
	}

	public String getQuestionWriter() {
		return questionWriter;
	}

	public void setQuestionWriter(String questionWriter) {
		this.questionWriter = questionWriter;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getQuestionOriginalFilename() {
		return questionOriginalFilename;
	}

	public void setQuestionOriginalFilename(String questionOriginalFilename) {
		this.questionOriginalFilename = questionOriginalFilename;
	}

	public String getQuestionRenamedFilename() {
		return questionRenamedFilename;
	}

	public void setQuestionRenamedFilename(String questionRenamedFilename) {
		this.questionRenamedFilename = questionRenamedFilename;
	}

	public Date getQuestionEnrollDate() {
		return questionEnrollDate;
	}

	public void setQuestionEnrollDate(Date questionEnrollDate) {
		this.questionEnrollDate = questionEnrollDate;
	}

	public int getQuestionReadCount() {
		return questionReadCount;
	}

	public void setQuestionReadCount(int questionReadCount) {
		this.questionReadCount = questionReadCount;
	}

	@Override
	public String toString() {
		return "Question [questionIdx=" + questionIdx + ", questionWriter=" + questionWriter + ", questionTitle="
				+ questionTitle + ", questionContent=" + questionContent + ", questionOriginalFilename="
				+ questionOriginalFilename + ", questionRenamedFilename=" + questionRenamedFilename
				+ ", questionEnrollDate=" + questionEnrollDate + ", questionReadCount=" + questionReadCount + "]";
	}
	
	
}

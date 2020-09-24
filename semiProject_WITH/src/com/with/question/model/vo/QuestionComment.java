package com.with.question.model.vo;

import java.sql.Date;

public class QuestionComment {
	private int qaCommentNo;
	private int qaCommentLevel;
	private String qaCommentWriter;
	private String qaCommentContent;
	private int qaRef;
	private int commentRef;
	private Date qaCommentDate;
	
	public QuestionComment() {
		// TODO Auto-generated constructor stub
	}

	public QuestionComment(int qaCommentNo, int qaCommentLevel, String qaCommentWriter, String qaCommentContent,
			int qaRef, int commentRef, Date qaCommentDate) {
		super();
		this.qaCommentNo = qaCommentNo;
		this.qaCommentLevel = qaCommentLevel;
		this.qaCommentWriter = qaCommentWriter;
		this.qaCommentContent = qaCommentContent;
		this.qaRef = qaRef;
		this.commentRef = commentRef;
		this.qaCommentDate = qaCommentDate;
	}

	public int getQaCommentNo() {
		return qaCommentNo;
	}

	public void setQaCommentNo(int qaCommentNo) {
		this.qaCommentNo = qaCommentNo;
	}

	public int getQaCommentLevel() {
		return qaCommentLevel;
	}

	public void setQaCommentLevel(int qaCommentLevel) {
		this.qaCommentLevel = qaCommentLevel;
	}

	public String getQaCommentWriter() {
		return qaCommentWriter;
	}

	public void setQaCommentWriter(String qaCommentWriter) {
		this.qaCommentWriter = qaCommentWriter;
	}

	public String getQaCommentContent() {
		return qaCommentContent;
	}

	public void setQaCommentContent(String qaCommentContent) {
		this.qaCommentContent = qaCommentContent;
	}

	public int getQaRef() {
		return qaRef;
	}

	public void setQaRef(int qaRef) {
		this.qaRef = qaRef;
	}

	public int getCommentRef() {
		return commentRef;
	}

	public void setCommentRef(int commentRef) {
		this.commentRef = commentRef;
	}

	public Date getQaCommentDate() {
		return qaCommentDate;
	}

	public void setQaCommentDate(Date qaCommentDate) {
		this.qaCommentDate = qaCommentDate;
	}

	@Override
	public String toString() {
		return "QuestionComment [qaCommentNo=" + qaCommentNo + ", qaCommentLevel=" + qaCommentLevel
				+ ", qaCommentWriter=" + qaCommentWriter + ", qaCommentContent=" + qaCommentContent + ", qaRef=" + qaRef
				+ ", commentRef=" + commentRef + ", qaCommentDate=" + qaCommentDate + "]";
	}
	
	
}

package com.with.walk.model.vo;

public class WalkAccept {
	private int acceptWalkNo;
	private int acceptWalkIdx;
	private String acceptMemberId;
	private String acceptCheck;
	private String acceptYn;
	
	public WalkAccept() {
		// TODO Auto-generated constructor stub
	}

	public WalkAccept(int acceptWalkNo, int acceptWalkIdx, String acceptMemberId, String acceptCheck, String acceptYn) {
		super();
		this.acceptWalkNo = acceptWalkNo;
		this.acceptWalkIdx = acceptWalkIdx;
		this.acceptMemberId = acceptMemberId;
		this.acceptCheck = acceptCheck;
		this.acceptYn = acceptYn;
	}

	public int getAcceptWalkNo() {
		return acceptWalkNo;
	}

	public void setAcceptWalkNo(int acceptWalkNo) {
		this.acceptWalkNo = acceptWalkNo;
	}

	public int getAcceptWalkIdx() {
		return acceptWalkIdx;
	}

	public void setAcceptWalkIdx(int acceptWalkIdx) {
		this.acceptWalkIdx = acceptWalkIdx;
	}

	public String getAcceptMemberId() {
		return acceptMemberId;
	}

	public void setAcceptMemberId(String acceptMemberId) {
		this.acceptMemberId = acceptMemberId;
	}

	public String getAcceptCheck() {
		return acceptCheck;
	}

	public void setAcceptCheck(String acceptCheck) {
		this.acceptCheck = acceptCheck;
	}

	public String getAcceptYn() {
		return acceptYn;
	}

	public void setAcceptYn(String acceptYn) {
		this.acceptYn = acceptYn;
	}

	@Override
	public String toString() {
		return "WalkAccept [acceptWalkNo=" + acceptWalkNo + ", acceptWalkIdx=" + acceptWalkIdx + ", acceptMemberId="
				+ acceptMemberId + ", acceptCheck=" + acceptCheck + ", acceptYn=" + acceptYn + "]";
	}
	
	
}

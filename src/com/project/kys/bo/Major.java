package com.project.kys.bo;

import java.io.Serializable;

public class Major implements Serializable {
	private Integer mMajorId=0;
	private String mMajorName;
	private String mMajorInitials;
    private String mMajorSummary;
	private Department mDepartment;
	
	
	public Integer getmMajorId() {
		return mMajorId;
	}
	public void setmMajorId(Integer mMajorId) {
		this.mMajorId = mMajorId;
	}
	public String getmMajorName() {
		return mMajorName;
	}
	public void setmMajorName(String mMajorName) {
		this.mMajorName = mMajorName;
	}
	
	public String getmMajorInitials() {
		return mMajorInitials;
	}
	public void setmMajorInitials(String mMajorInitials) {
		this.mMajorInitials = mMajorInitials;
	}
	public String getmMajorSummary() {
		return mMajorSummary;
	}
	public void setmMajorSummary(String mMajorSummary) {
		this.mMajorSummary = mMajorSummary;
	}
	public Department getmDepartment() {
		return mDepartment;
	}
	public void setmDepartment(Department mDepartment) {
		this.mDepartment = mDepartment;
	}
	
}

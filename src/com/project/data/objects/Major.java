package com.project.data.objects;

public class Major {
	
	private Integer mMajorId=0;
    private String mMajorName;
    private String mMajorInitials;
    private String mMajorSummary;
    private Integer mDepartmentId=0;
    
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
	public Integer getmDepartmentId() {
		return mDepartmentId;
	}
	public void setmDepartmentId(Integer mDepartmentId) {
		this.mDepartmentId = mDepartmentId;
	}
	public String getmMajorName() {
		return mMajorName;
	}
	public void setmMajorName(String mMajorName) {
		this.mMajorName = mMajorName;
	}
	public Integer getmMajorId() {
		return mMajorId;
	}
	public void setmMajorId(Integer mMajorId) {
		this.mMajorId = mMajorId;
	}

}

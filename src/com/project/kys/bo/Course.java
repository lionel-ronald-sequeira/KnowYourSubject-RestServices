package com.project.kys.bo;
import java.io.Serializable;
import java.util.List;

public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer mCourseId=0;
	private String mCourseName;
	private String mCourseCode;
	private String mCourseInitials;
	private String mCourseSummary;
	private Integer mFeedbackCount=0;
    private Double mRating=0.0;
	private Major mMajor;
	private List<Professor> mProfessorList;

	public Integer getmCourseId() {
		return mCourseId;
	}
	public String getmCourseName() {
		return mCourseName;
	}
	public String getmCourseInitials() {
		return mCourseInitials;
	}
	public String getmCourseSummary() {
		return mCourseSummary;
	}
	public Integer getmFeedbackCount() {
		return mFeedbackCount;
	}
	public void setmFeedbackCount(Integer mFeedbackCount) {
		this.mFeedbackCount = mFeedbackCount;
	}
	public Major getmMajor() {
		return mMajor;
	}
	public List<Professor> getmProfessorList() {
		return mProfessorList;
	}
	public void setmCourseId(Integer mCourseId) {
		this.mCourseId = mCourseId;
	}
	public void setmCourseName(String mCourseName) {
		this.mCourseName = mCourseName;
	}
	public void setmCourseInitials(String mCourseInitials) {
		this.mCourseInitials = mCourseInitials;
	}
	public void setmCourseSummary(String mCourseSummary) {
		this.mCourseSummary = mCourseSummary;
	}
	public void setmMajor(Major mMajor) {
		this.mMajor = mMajor;
	}
	public void setmProfessorList(List<Professor> mProfessorList) {
		this.mProfessorList = mProfessorList;
	}
	public Double getmRating() {
		return mRating;
	}
	public void setmRating(Double mRating) {
		this.mRating = mRating;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getmCourseCode() {
		return mCourseCode;
	}
	public void setmCourseCode(String mCourseCode) {
		this.mCourseCode = mCourseCode;
	}
}

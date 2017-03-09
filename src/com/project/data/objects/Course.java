package com.project.data.objects;
import java.util.List;

public class Course {
	private Integer mCourseId=0;
    private String mCourseCode;
    private String mCourseName;
    private String mCourseInitials;
    public Integer getmFeedbackCount() {
		return mFeedbackCount;
	}
	public void setmFeedbackCount(Integer mFeedbackCount) {
		this.mFeedbackCount = mFeedbackCount;
	}
	private String mCourseSummary;
    private Integer mFeedbackCount=0;
    private Double mCourseRating=0.0;
    private Integer mMajorId;
    private List<Integer> mProfessorIds;
    
	public String getmCourseCode() {
		return mCourseCode;
	}
	public void setmCourseCode(String mCourseCode) {
		this.mCourseCode = mCourseCode;
	}
	public String getmCourseName() {
		return mCourseName;
	}
	public void setmCourseName(String mCourseName) {
		this.mCourseName = mCourseName;
	}
	public String getmCourseInitials() {
		return mCourseInitials;
	}
	public void setmCourseInitials(String mCourseInitials) {
		this.mCourseInitials = mCourseInitials;
	}
	public String getmCourseSummary() {
		return mCourseSummary;
	}
	public void setmCourseSummary(String mCourseSummary) {
		this.mCourseSummary = mCourseSummary;
	}
	public Integer getmMajorId() {
		return mMajorId;
	}
	public void setmMajorId(Integer mMajorId) {
		this.mMajorId = mMajorId;
	}
	public Integer getmCourseId() {
		return mCourseId;
	}
	public void setmCourseId(Integer mCourseId) {
		this.mCourseId = mCourseId;
	}
	public List<Integer> getmProfessorIds() {
		return mProfessorIds;
	}
	
	public void setmProfessorIds(List<Integer> mProfessorIds) {
		this.mProfessorIds = mProfessorIds;
	}
	public Double getmCourseRating() {
		return mCourseRating;
	}
	public void setmCourseRating(Double mCourseRating) {
		this.mCourseRating = mCourseRating;
	}
}

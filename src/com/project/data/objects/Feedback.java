package com.project.data.objects;

import java.util.Date;

public class Feedback {
	private Integer mFeedbackId=0;
	private Integer mUserId=0;
	private String mUserName;
	private Integer mCourseId=0;
	private String mCourseName;
	private Integer mProfessorId=0;
	private String mProfessorName;
	private String mTitle;
	private String mComment;
	private Float mRating;
	private Date mDate;
	private Integer mHelpfulnessCount=0;
	private Integer mUnhelpfulnessCount=0;
	private Boolean mIsSpam=false;
	private Boolean mIsAnonymous=false;
	
	public Integer getmFeedbackId() {
		return mFeedbackId;
	}
	public Integer getmUserId() {
		return mUserId;
	}
	public String getmUserName() {
		return mUserName;
	}
	public Integer getmCourseId() {
		return mCourseId;
	}
	public String getmCourseName() {
		return mCourseName;
	}
	public Integer getmProfessorId() {
		return mProfessorId;
	}
	public String getmProfessorName() {
		return mProfessorName;
	}
	public String getmTitle() {
		return mTitle;
	}
	public String getmComment() {
		return mComment;
	}
	public Date getmDate() {
		return mDate;
	}
	public Integer getmHelpfulnessCount() {
		return mHelpfulnessCount;
	}
	public Integer getmUnhelpfulnessCount() {
		return mUnhelpfulnessCount;
	}
	public Boolean getmIsSpam() {
		return mIsSpam;
	}
	public Boolean getmIsAnonymous() {
		return mIsAnonymous;
	}
	public void setmFeedbackId(Integer mFeedbackId) {
		this.mFeedbackId = mFeedbackId;
	}
	public void setmUserId(Integer mUserId) {
		this.mUserId = mUserId;
	}
	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}
	public void setmCourseId(Integer mCourseId) {
		this.mCourseId = mCourseId;
	}
	public void setmCourseName(String mCourseName) {
		this.mCourseName = mCourseName;
	}
	public void setmProfessorId(Integer mProfessorId) {
		this.mProfessorId = mProfessorId;
	}
	public void setmProfessorName(String mProfessorName) {
		this.mProfessorName = mProfessorName;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public void setmComment(String mComment) {
		this.mComment = mComment;
	}
	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}
	public void setmHelpfulnessCount(Integer mHelpfulnessCount) {
		this.mHelpfulnessCount = mHelpfulnessCount;
	}
	public void setmUnhelpfulnessCount(Integer mUnhelpfulnessCount) {
		this.mUnhelpfulnessCount = mUnhelpfulnessCount;
	}
	public void setmIsSpam(Boolean mIsSpam) {
		this.mIsSpam = mIsSpam;
	}
	public void setmIsAnonymous(Boolean mIsAnonymous) {
		this.mIsAnonymous = mIsAnonymous;
	}
	public Float getmRating() {
		return mRating;
	}
	public void setmRating(Float mRating) {
		this.mRating = mRating;
	}
}

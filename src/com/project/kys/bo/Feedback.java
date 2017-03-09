package com.project.kys.bo;

import java.io.Serializable;
import java.util.Date;



public class Feedback implements Serializable {
	
	private Integer mFeedbackId=0;
	private User mUser;
	private Course mCourse;
	private Professor mProfessor;
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
	public String getmTitle() {
		return mTitle;
	}
	public String getmComment() {
		return mComment;
	}
	public Float getmRating() {
		return mRating;
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
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public void setmComment(String mComment) {
		this.mComment = mComment;
	}
	public void setmRating(Float mRating) {
		this.mRating = mRating;
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
	public User getmUser() {
		return mUser;
	}
	public Course getmCourse() {
		return mCourse;
	}
	public Professor getmProfessor() {
		return mProfessor;
	}
	public void setmUser(User mUser) {
		this.mUser = mUser;
	}
	public void setmCourse(Course mCourse) {
		this.mCourse = mCourse;
	}
	public void setmProfessor(Professor mProfessor) {
		this.mProfessor = mProfessor;
	}
}

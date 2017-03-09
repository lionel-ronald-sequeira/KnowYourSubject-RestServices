package com.project.kys.bo;

import java.io.Serializable;
import java.util.List;



public class Professor implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer mProfessorId=0;
	private String mName;
	private String mEmail;
	private String mContact;
	private String mUrl;
	private List<Course>mCourseList;
	
	public Integer getmProfessorId() {
		return mProfessorId;
	}
	public String getmName() {
		return mName;
	}
	public String getmEmail() {
		return mEmail;
	}
	public String getmContact() {
		return mContact;
	}
	public String getmUrl() {
		return mUrl;
	}
	public List<Course> getmCourseList() {
		return mCourseList;
	}
	public void setmProfessorId(Integer mProfessorId) {
		this.mProfessorId = mProfessorId;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public void setmContact(String mContact) {
		this.mContact = mContact;
	}
	public void setmUrl(String mUrl) {
		this.mUrl = mUrl;
	}
	public void setmCourseList(List<Course> mCourseList) {
		this.mCourseList = mCourseList;
	}
	
	
	

}

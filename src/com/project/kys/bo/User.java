package com.project.kys.bo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private Integer mUserId=0;
	private String mPassword;
	private String mEmailId;
	private String mFirstName;
	private String mLastName;
	private Department mDepartment;
	private String mSecurityQuestion;
	private String mSecurityAnswer;
	private Boolean mIsAdmin=false;
	private String mDob;
	private String mContact;
	private String mZipCode;
	private Date mCreationDate;
	
	public Integer getmUserId() {
		return mUserId;
	}
	public void setmUserId(Integer mUserId) {
		this.mUserId = mUserId;
	}
	public String getmPassword() {
		return mPassword;
	}
	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}
	public String getmEmailId() {
		return mEmailId;
	}
	public void setmEmailId(String mEmailId) {
		this.mEmailId = mEmailId;
	}
	public String getmFirstName() {
		return mFirstName;
	}
	public void setmFirstName(String mFirstName) {
		this.mFirstName = mFirstName;
	}
	public String getmLastName() {
		return mLastName;
	}
	public void setmLastName(String mLastName) {
		this.mLastName = mLastName;
	}
	public Department getmDepartment() {
		return mDepartment;
	}
	public void setmDepartment(Department mDepartment) {
		this.mDepartment = mDepartment;
	}
	public String getmSecurityQuestion() {
		return mSecurityQuestion;
	}
	public void setmSecurityQuestion(String mSecurityQuestion) {
		this.mSecurityQuestion = mSecurityQuestion;
	}
	public String getmSecurityAnswer() {
		return mSecurityAnswer;
	}
	public void setmSecurityAnswer(String mSecurityAnswer) {
		this.mSecurityAnswer = mSecurityAnswer;
	}
	public Boolean getmIsAdmin() {
		return mIsAdmin;
	}
	public void setmIsAdmin(Boolean mIsAdmin) {
		this.mIsAdmin = mIsAdmin;
	}
	public String getmDob() {
		return mDob;
	}
	public void setmDob(String mDob) {
		this.mDob = mDob;
	}
	
	public String getmZipCode() {
		return mZipCode;
	}
	
	public void setmZipCode(String mZipCode) {
		this.mZipCode = mZipCode;
	}
	public String getmContact() {
		return mContact;
	}
	public void setmContact(String mContact) {
		this.mContact = mContact;
	}
	public Date getmCreationDate() {
		return mCreationDate;
	}
	public void setmCreationDate(Date mCreationDate) {
		this.mCreationDate = mCreationDate;
	}

}

package com.project.data.objects;

public class Professor {
	
	private Integer mProfessorId=0;
    private String mProfessorName;
    private String mContact;
    private String mEmail;
    private String mUrl;
    
    public String getmProfessorName() {
		return mProfessorName;
	}
	public void setmProfessorName(String mProfessorName) {
		this.mProfessorName = mProfessorName;
	}
	public String getmContact() {
		return mContact;
	}
	public void setmContact(String mContact) {
		this.mContact = mContact;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmUrl() {
		return mUrl;
	}
	public void setmUrl(String mUrl) {
		this.mUrl = mUrl;
	}
	public Integer getmProfessorId() {
		return mProfessorId;
	}
	public void setmProfessorId(Integer mProfessorId) {
		this.mProfessorId = mProfessorId;
	}
}

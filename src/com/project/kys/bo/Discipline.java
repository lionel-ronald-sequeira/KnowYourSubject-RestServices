package com.project.kys.bo;

import java.io.Serializable;

public class Discipline implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer mDisciplineId=0;
	private String mDisciplineName;
	private String mDisciplineInitials;
	private String mDisciplineSummary;
	private University mUniversity;
	 
	public String getmDisciplineName() {
		return mDisciplineName;
	}
	public void setmDisciplineName(String mDisciplineName) {
		this.mDisciplineName = mDisciplineName;
	}
	public String getmDisciplineInitials() {
		return mDisciplineInitials;
	}
	public void setmDisciplineInitials(String mDisciplineInitials) {
		this.mDisciplineInitials = mDisciplineInitials;
	}
	public String getmDisciplineSummary() {
		return mDisciplineSummary;
	}
	public void setmDisciplineSummary(String mDisciplineSummary) {
		this.mDisciplineSummary = mDisciplineSummary;
	}
	
	public Integer getmDisciplineId() {
		return mDisciplineId;
	}
	public void setmDisciplineId(Integer mDisciplineId) {
		this.mDisciplineId = mDisciplineId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public University getmUniversity() {
		return mUniversity;
	}
	public void setmUniversity(University mUniversity) {
		this.mUniversity = mUniversity;
	}

}

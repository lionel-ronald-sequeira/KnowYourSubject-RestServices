package com.project.kys.bo;

import java.io.Serializable;

public class Department implements Serializable{
	
		private Integer mDepartmentId=0;
		private String mDepartmentName;
		private String mDepartmentInitials;
		private String mDepartmentSummary;
		private Discipline mDiscipline;
	
		public Integer getmDepartmentId() {
			return mDepartmentId;
		}
		public void setmDepartmentId(Integer mDepartmentId) {
			this.mDepartmentId = mDepartmentId;
		}
		public String getmDepartmentName() {
			return mDepartmentName;
		}
		public void setmDepartmentName(String mDepartmentName) {
			this.mDepartmentName = mDepartmentName;
		}
		public String getmDepartmentInitials() {
			return mDepartmentInitials;
		}
		public void setmDepartmentInitials(String mDepartmentInitials) {
			this.mDepartmentInitials = mDepartmentInitials;
		}
		public String getmDepartmentSummary() {
			return mDepartmentSummary;
		}
		public void setmDepartmentSummary(String mDepartmentSummary) {
			this.mDepartmentSummary = mDepartmentSummary;
		}
		public Discipline getmDiscipline() {
			return mDiscipline;
		}
		public void setmDiscipline(Discipline mDiscipline) {
			this.mDiscipline = mDiscipline;
		}
}

package com.project.data.objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Discipline {
	
	private Integer mDisciplineId=0;
    private String mDisciplineName;
    private String mDisciplineInitials;
    private String mDisciplineSummary;
    private Integer mUniversityId=0;
   
    public Integer getmUniversityId() {
		return mUniversityId;
	}
	public void setmUniversityId(Integer mUniversityId) {
		this.mUniversityId = mUniversityId;
	}
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
	
	public static void main(String args[]){
		Discipline discipline=new Discipline();
		//discipline.setmDisciplineId("1");
		discipline.setmDisciplineInitials("DISP1");
		ObjectMapper objectMapper=new ObjectMapper();
		String result=null;
		try {
			result = objectMapper.writeValueAsString(discipline);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
	}

}

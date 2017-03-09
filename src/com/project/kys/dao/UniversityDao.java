package com.project.kys.dao;

import java.util.List;

import com.project.kys.bo.University;
import com.project.kys.exception.DBException;

public interface UniversityDao {
void addUniversity(University university)throws DBException;
	
	void updateUniversity(University university)throws DBException;
	
	void deleteUniversity(Integer universityId)throws DBException;
	
	List<University>getUniversityList()throws DBException;
	
	boolean checkUniversityNameExists(String universityName)throws DBException;
	
	University getUniversity(String universityName)throws DBException ;
	
}

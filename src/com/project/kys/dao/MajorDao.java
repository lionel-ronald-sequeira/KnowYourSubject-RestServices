package com.project.kys.dao;


import java.util.List;
import com.project.kys.bo.Major;
import com.project.kys.exception.DBException;

public interface MajorDao {
	void addMajor(Major major)throws DBException;
	
	void updateMajor(Major major)throws DBException;
	
	void deleteMajor(Integer majorId)throws DBException;
	
	boolean checkMajorNameExists(String majorName)throws DBException;
	
	List<Major> getMajorListForDepartment(Integer departmentId)throws DBException;
	
	Major getMajor(Integer majorId)throws DBException;
}

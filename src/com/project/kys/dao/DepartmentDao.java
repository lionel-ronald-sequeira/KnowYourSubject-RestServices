package com.project.kys.dao;



import java.util.List;

import com.project.kys.bo.Department;
import com.project.kys.bo.Discipline;
import com.project.kys.exception.DBException;

public interface DepartmentDao {
	
	void addDepartment(Department department)throws DBException;
	
	void updateDepartment(Department department)throws DBException;
	
	void deleteDepartment(Integer departmentId)throws DBException;
	
	List<Department> getDepartmentListForDiscipline(Integer disciplineId)throws DBException;
	
	boolean checkDepartmentNameExists(String departmentName)throws DBException;
	
	Department getDepartment(Integer departmentId)throws DBException;
	
	List<Department>getAllDepartments()throws DBException;
}

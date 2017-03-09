package com.project.kys.service;

import java.util.List;





import com.project.data.objects.Department;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;

public interface DepartmentService {
	public void addDepartment(Department department)throws BusinessException,DBException;
	
	public void updateDepartment(Department department)throws BusinessException,DBException;
	
	public void deleteDepartment(Integer departmentId)throws BusinessException,DBException;

	public List<Department> getDepartmentListForDiscipline(Integer disciplineId)throws BusinessException,DBException;
	
	public Department getDepartment(Integer departmentId)throws BusinessException,DBException;

	public List<Department> getAllDepartments()throws BusinessException,DBException;
}

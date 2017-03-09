package com.project.kys.rest.service;

import javax.ws.rs.core.Response;

import com.project.data.objects.Department;
import com.project.data.objects.Discipline;

public interface DepartmentRestService {
	
	public Response addDepartment(Department department);
	
	public Response updateDepartment(Department department);
	
	public Response deleteDepartment(Department department);
	
	public Response getDepartment(Department department);
	
	public Response getDepartmentListForDiscipline(Discipline discipline);
	
	public Response getAllDepartments();
	

}

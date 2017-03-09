package com.project.kys.rest.service;

import javax.ws.rs.core.Response;

import com.project.data.objects.Department;
import com.project.data.objects.Major;

public interface MajorRestService {

	 Response addMajor(Major major);
	 
	 Response updateMajor(Major major);
	 
	 Response deleteMajor(Major major);
	 
	 Response getMajorListForDepartment(Department department);
	 
	 Response getMajor(Major major);
	
}

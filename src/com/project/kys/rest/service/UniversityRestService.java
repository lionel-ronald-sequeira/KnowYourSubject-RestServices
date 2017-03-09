package com.project.kys.rest.service;

import javax.ws.rs.core.Response;

import com.project.data.objects.University;

public interface UniversityRestService {
Response addUniversity(University university);
	
	Response getUniversity(University university);
	
	Response updateUniversity(University university);
	
	Response deleteUniversity(University university);
	
	Response getUniversityList();
	
}

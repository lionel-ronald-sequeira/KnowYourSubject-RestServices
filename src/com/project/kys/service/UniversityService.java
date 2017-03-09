package com.project.kys.service;

import java.util.List;
import com.project.data.objects.University;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;

public interface UniversityService {
void addUniversity(University university)throws BusinessException,DBException;
	
	void updateUniversity(University university)throws BusinessException,DBException;
	
	void deleteUniversity(Integer universityId)throws BusinessException,DBException;
	
	List<University> getUniversityList()throws BusinessException,DBException;
	
	University getUniversity(String universityName)throws BusinessException,DBException;
}

package com.project.kys.service;

import java.util.List;

import com.project.data.objects.Major;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;

public interface MajorService {

	public void addMajor(Major major)throws BusinessException,DBException;
	
	public void updateMajor(Major major)throws BusinessException,DBException;
	
	public void deleteMajor(Integer majorId)throws BusinessException,DBException;

	public List<Major> getMajorListForDepartment(Integer departmentId)throws BusinessException,DBException;

	public Major getMajor(Integer majorId)throws BusinessException,DBException;
}

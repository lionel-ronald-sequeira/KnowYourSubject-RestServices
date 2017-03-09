package com.project.kys.service;

import java.util.List;

import com.project.data.objects.Department;
import com.project.data.objects.User;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;

public interface UserService {

	User registerUser(User user)throws BusinessException,DBException;
	
	User checkUserExists(String userName,String password)throws BusinessException,DBException;
	
	void deleteUser(User user)throws BusinessException,DBException;
	
	User updateUser(User user)throws BusinessException,DBException;
	
	User getUser(User  user)throws BusinessException,DBException;
	
	List<User> getUserListForDepartment(Department department)throws BusinessException,DBException;
	
	User changePassword(User user)throws BusinessException,DBException;
	
	User retrievePassword(User user)throws BusinessException,DBException;
	
}

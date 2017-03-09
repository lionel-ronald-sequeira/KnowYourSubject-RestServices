package com.project.kys.dao;

import java.util.List;

import com.project.kys.bo.User;
import com.project.kys.exception.DBException;

public interface UserDao{
	void registerUser(User user) throws DBException;
	
	boolean checkEmailIdExists(String emailId)throws DBException;
	
	boolean checkUserExists(String userName,String password)throws DBException;
	
	User getUser(Integer userId)throws DBException;
	
	List<User> getUserListForDepartment(Integer departmentId)throws DBException;
	
	void deleteUser(Integer userId)throws DBException;
	
	void updateUser(User user)throws DBException;
	
	void changePassword(Integer userId,String changePassword)throws DBException;
	
	Integer getUserId(String emailId);
	
	User getUser(String emailId);
}

package com.project.kys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.project.kys.bo.Department;
import com.project.kys.bo.User;
import com.project.kys.constants.StringConstants;
import com.project.kys.dao.UserDao;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.service.UserService;
import com.project.kys.utility.WebAppContext;


public class UserServiceImpl implements UserService{

private UserDao userDao;
	
	@Transactional
	@Override
	public com.project.data.objects.User registerUser(com.project.data.objects.User user) throws BusinessException, DBException {
		boolean result=false;
		User userBo=null;
		List<User>userObjList=new ArrayList<User>();
		List<com.project.data.objects.User>userDataObjList=null;
		Integer userId=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		userDao=(UserDao)ctx.getBean("userDao");
		result=userDao.checkEmailIdExists(user.getmEmailId());
		if(result){
			throw new BusinessException(StringConstants.EMAIL_ID_EXISTS_MSG);
		}
		userBo=createUserObject(user);
		userDao.registerUser(userBo);
		userBo=userDao.getUser(userBo.getmEmailId());
		userObjList.add(userBo);
		userDataObjList=mapUserBoObjectToUserDtoObject(userObjList);
		return userDataObjList.get(0);
	}

	@Transactional
	@Override
	public com.project.data.objects.User checkUserExists(String emailId, String password)
			throws BusinessException, DBException {
		boolean result=false;
		List<com.project.data.objects.User>userDataObjList=null;
		User user=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		userDao=(UserDao)ctx.getBean("userDao");
		result=userDao.checkUserExists(emailId, password);
		if(result){
			List<User>userList=new ArrayList<User>();
			user=userDao.getUser(emailId);
			userList.add(user);
			userDataObjList=mapUserBoObjectToUserDtoObject(userList);
			return userDataObjList.get(0); 
		}else{
			throw new BusinessException(StringConstants.USER_NOT_EXISTS);
		}
	}

	@Transactional
	@Override
	public void deleteUser(com.project.data.objects.User user)throws BusinessException, DBException {
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		userDao=(UserDao)ctx.getBean("userDao");
		userDao.deleteUser(user.getmUserId());
	}

	@Transactional
	@Override
	public com.project.data.objects.User updateUser(com.project.data.objects.User user)throws BusinessException, DBException {
		User userBo=null;
		com.project.data.objects.User userDataObj=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		userDao=(UserDao)ctx.getBean("userDao");
		userBo=createUserObject(user);
		userDao.updateUser(userBo);
		userBo=userDao.getUser(userBo.getmUserId());
		userDataObj=mapUserBoObjectToUserDtoObject(userBo);
		return userDataObj;
	}
	
	public static User createUserObject(com.project.data.objects.User user){
		User userBo=new User();
		userBo.setmUserId(user.getmUserId());
		userBo.setmPassword(user.getmPassword());
		userBo.setmFirstName(user.getmFirstName());
		userBo.setmLastName(user.getmLastName());
		userBo.setmEmailId(user.getmEmailId());
		userBo.setmIsAdmin(user.getmIsAdmin());
		userBo.setmSecurityAnswer(user.getmSecurityAnswer());
		userBo.setmSecurityQuestion(user.getmSecurityQuestion());
		userBo.setmDob(user.getmDob());
		userBo.setmZipCode(user.getmZipCode());
		userBo.setmContact(user.getmContact());
		userBo.setmCreationDate(new Date());
		if(user.getmDepartmentId()!=0){
			Department departmentBo=new Department();
			departmentBo.setmDepartmentId(user.getmDepartmentId());
			userBo.setmDepartment(departmentBo);
		}
		return userBo;
	}

	@Transactional
	@Override
	public com.project.data.objects.User getUser(
			com.project.data.objects.User user) throws BusinessException,
			DBException {
		List<com.project.data.objects.User>userDataObjList=null;
		List<User>userBoList=new ArrayList<User>();
		User userBo=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		userDao=(UserDao)ctx.getBean("userDao");
		userBo=userDao.getUser(user.getmUserId());
		userBoList.add(userBo);
		userDataObjList=mapUserBoObjectToUserDtoObject(userBoList);
		return userDataObjList.get(0);
	}

	@Transactional
	@Override
	public  List<com.project.data.objects.User>getUserListForDepartment(com.project.data.objects.Department department)throws BusinessException,DBException{
		List<com.project.data.objects.User>userDataObjList=null;
		List<User>userBoList=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		userDao=(UserDao)ctx.getBean("userDao");
		userBoList=userDao.getUserListForDepartment(department.getmDepartmentId());
		userDataObjList=mapUserBoObjectToUserDtoObject(userBoList);
		return userDataObjList;
	}

	@Transactional
	@Override
	public com.project.data.objects.User changePassword(com.project.data.objects.User user)throws BusinessException,DBException {
		User userBoObj=null;
		com.project.data.objects.User userDataObj=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		userDao=(UserDao)ctx.getBean("userDao");
		userDao.changePassword(user.getmUserId(),user.getmPassword());
		userBoObj=userDao.getUser(user.getmUserId());
		userDataObj=mapUserBoObjectToUserDtoObject(userBoObj);
		return userDataObj;
		
	}
	
	private List<com.project.data.objects.User>mapUserBoObjectToUserDtoObject(List<User> userList)
			throws BusinessException,DBException{
		List<com.project.data.objects.User>userDataObjList=new ArrayList<com.project.data.objects.User>();
		for(User user:userList){
			com.project.data.objects.User userDataObj=new com.project.data.objects.User();
			userDataObj.setmUserId(user.getmUserId());
			userDataObj.setmContact(user.getmContact());
			userDataObj.setmPassword(user.getmPassword());
			userDataObj.setmFirstName(user.getmFirstName());
			userDataObj.setmLastName(user.getmLastName());
			userDataObj.setmEmailId(user.getmEmailId());
			userDataObj.setmZipCode(user.getmZipCode());
			userDataObj.setmIsAdmin(user.getmIsAdmin());
			userDataObj.setmSecurityQuestion(user.getmSecurityQuestion());
			userDataObj.setmSecurityAnswer(user.getmSecurityAnswer());
			if(!user.getmIsAdmin()){
				userDataObj.setmDepartmentId(user.getmDepartment().getmDepartmentId());
			}
			userDataObj.setmDob(user.getmDob());
			userDataObjList.add(userDataObj);
		}
		return userDataObjList;
	}

	@Transactional
	@Override
	public com.project.data.objects.User retrievePassword(com.project.data.objects.User user)
			throws BusinessException, DBException {
		User userBo=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		userDao=(UserDao)ctx.getBean("userDao");
		userBo=userDao.getUser(user.getmUserId());
		user.setmPassword(userBo.getmPassword());
		return user;
	}
	
	private com.project.data.objects.User mapUserBoObjectToUserDtoObject(User user) throws BusinessException,DBException{
		com.project.data.objects.User userDataObj=new com.project.data.objects.User();
		userDataObj.setmUserId(user.getmUserId());
		userDataObj.setmContact(user.getmContact());
		userDataObj.setmPassword(user.getmPassword());
		userDataObj.setmFirstName(user.getmFirstName());
		userDataObj.setmLastName(user.getmLastName());
		userDataObj.setmEmailId(user.getmEmailId());
		userDataObj.setmZipCode(user.getmZipCode());
		userDataObj.setmSecurityQuestion(user.getmSecurityQuestion());
		userDataObj.setmSecurityAnswer(user.getmSecurityAnswer());
		userDataObj.setmDob(user.getmDob());
		userDataObj.setmIsAdmin(user.getmIsAdmin());
		if(user.getmDepartment()!=null){
			userDataObj.setmDepartmentId(user.getmDepartment().getmDepartmentId());
		}
		return userDataObj;
	}
}

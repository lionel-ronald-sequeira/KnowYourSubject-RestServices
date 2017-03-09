package com.project.kys.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.project.kys.bo.User;
import com.project.kys.dao.UserDao;
import com.project.kys.exception.DBException;

public class UserDaoImpl implements UserDao {
private SessionFactory sessionFactory;
	
	public 	UserDaoImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void registerUser(User user)throws DBException{
		try{
			Session session=sessionFactory.getCurrentSession();
			session.save(user);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public boolean checkEmailIdExists(String emailId)throws DBException{
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(User.class);
			criteria.add(Restrictions.eq("mEmailId", emailId));
			criteria.setProjection(Projections.rowCount());
			Long count=(Long)criteria.uniqueResult();
			if (count==0)
			return false;
			else
			return true;
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public boolean checkUserExists(String userName, String password)
			throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(User.class);
			criteria.add(Restrictions.eq("mEmailId", userName));
			criteria.add(Restrictions.eq("mPassword", password));
			criteria.setProjection(Projections.rowCount());
			Long count=(Long)criteria.uniqueResult();
			if (count==0)
			return false;
			else
			return true;
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public User getUser(Integer userId)throws DBException{
		User userBo=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(User.class);
			criteria.add(Restrictions.eq("mUserId",userId));
			userBo=(User)criteria.uniqueResult();
		}catch(Exception e){
			throw new DBException();
		}
		return userBo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserListForDepartment(Integer departmentId)throws DBException {
		List<User>userList=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(User.class);
			criteria.add(Restrictions.eq("mDepartment.mDepartmentId", departmentId));
			userList=criteria.list();
		}catch(Exception e){
			throw new DBException();
		}
		return userList;
	}

	@Override
	public void deleteUser(Integer userId)throws DBException{
		try{
			Session session=sessionFactory.getCurrentSession();
			session.delete(userId);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public void updateUser(User user)throws DBException {
		User userBo=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			userBo=(User)session.get(User.class, user.getmUserId());
			userBo.setmContact(user.getmContact());
			userBo.setmPassword(user.getmPassword());
			userBo.setmFirstName(user.getmFirstName());
			userBo.setmLastName(user.getmLastName());
			userBo.setmEmailId(user.getmEmailId());
			userBo.setmZipCode(user.getmZipCode());
			userBo.setmSecurityQuestion(user.getmSecurityQuestion());
			userBo.setmSecurityAnswer(user.getmSecurityAnswer());
			userBo.setmDepartment(user.getmDepartment());
			userBo.setmDob(user.getmDob());
			session.saveOrUpdate(userBo);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public void changePassword(Integer userId,String changePassword)throws DBException{
		User userBo=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			userBo=(User)session.get(User.class, userId);
			userBo.setmPassword(changePassword);
			session.save(userBo);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public Integer getUserId(String emailId) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("mEmailId",emailId));
		User user=(User)criteria.uniqueResult();
		return user.getmUserId();
	}

	@Override
	public User getUser(String emailId) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("mEmailId",emailId));
		User user=(User)criteria.uniqueResult();
		return user;
	}

}

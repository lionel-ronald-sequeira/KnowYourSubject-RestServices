package com.project.kys.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.project.kys.bo.University;
import com.project.kys.dao.UniversityDao;
import com.project.kys.exception.DBException;

public class UniversityDaoImpl implements UniversityDao {
	private SessionFactory sessionFactory;
	
	public 	UniversityDaoImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addUniversity(University university) throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.save(university);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public void updateUniversity(University university) throws DBException {
		
	}

	@Override
	public void deleteUniversity(Integer universityId) throws DBException {
		
	}

	@Override
	public List<University> getUniversityList() throws DBException {
		List<University>universityList=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(University.class);
			universityList=criteria.list();
		}catch(Exception e){
			throw new DBException();
		}
		return universityList;
	}

	@Override
	public boolean checkUniversityNameExists(String universityName)throws DBException{
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(University.class);
			criteria.add(Restrictions.eq("universityName", universityName).ignoreCase());
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
	public University getUniversity(String universityName)throws DBException {
		try{
			University university=null;
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(University.class);
			criteria.add(Restrictions.eq("universityName", universityName));
			university=(University)criteria.uniqueResult();
			return university;
		}catch(Exception e){
			throw new DBException();
		}
	}

}

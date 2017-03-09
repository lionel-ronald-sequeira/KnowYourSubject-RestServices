package com.project.kys.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.project.kys.bo.Course;
import com.project.kys.bo.Major;
import com.project.kys.bo.Professor;
import com.project.kys.constants.Constants.ClassAttributes;
import com.project.kys.dao.ProfessorDao;
import com.project.kys.exception.DBException;

public class ProfessorDaoImpl implements ProfessorDao {
	private SessionFactory sessionFactory;
	
	public 	ProfessorDaoImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addProfessor(Professor professor) throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.save(professor);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public void updateProfessor(Professor professor) throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			Professor tmpProfessor=(Professor)session.get(Professor.class,professor.getmProfessorId());
			tmpProfessor.setmContact(professor.getmContact());
			tmpProfessor.setmEmail(professor.getmEmail());
			tmpProfessor.setmUrl(professor.getmUrl());
			tmpProfessor.setmName(professor.getmName());
			session.saveOrUpdate(tmpProfessor);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public void deleteProfessor(Integer professorId) throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			Professor tmpProfessor=(Professor)session.get(Professor.class, professorId);
			session.delete(tmpProfessor);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> getProfessorListForCourse(Integer courseId)
			throws DBException {
		List<Professor>professorList=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Course.class);
			criteria.add(Restrictions.eq("mCourseId", courseId));
			Course course=(Course)criteria.uniqueResult();
			professorList=course.getmProfessorList();
			return professorList;
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public boolean checkEmailExists(String emailId)throws DBException{
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Professor.class);
			criteria.add(Restrictions.eq("mEmail", emailId));
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
	public Professor getProfessor(Integer professorId)throws DBException {
		Professor professor=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Professor.class);
			criteria.add(Restrictions.eq("mProfessorId", professorId));
			professor=(Professor)criteria.uniqueResult();
		}catch(Exception e){
			throw new DBException();
		}
		return professor;
	}

	@Override
	public List<Professor> getAllProfessor()throws DBException{
		List<Professor>professorList=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Professor.class);
			professorList=criteria.list();
		}catch(Exception e){
			throw new DBException();
		}
		return professorList;
	}

}

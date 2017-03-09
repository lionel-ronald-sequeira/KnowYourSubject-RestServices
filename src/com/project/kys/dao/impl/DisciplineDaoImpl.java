package com.project.kys.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.project.kys.bo.Discipline;
import com.project.kys.constants.Constants.ClassAttributes;
import com.project.kys.dao.DisciplineDao;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;

public class DisciplineDaoImpl implements DisciplineDao{
	
	private SessionFactory sessionFactory;
	
	public DisciplineDaoImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addDiscipline(Discipline discipline)throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.save(discipline);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public void updateDiscipline(Discipline discipline)throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			Discipline tmpDiscipline=(Discipline)session.get(Discipline.class, discipline.getmDisciplineId());
			tmpDiscipline.setmDisciplineName(discipline.getmDisciplineName());
			tmpDiscipline.setmDisciplineInitials(discipline.getmDisciplineInitials());
			tmpDiscipline.setmDisciplineSummary(discipline.getmDisciplineSummary());
			session.saveOrUpdate(tmpDiscipline);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public void deleteDiscipline(Integer disciplineId)throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			Discipline tmpDiscipline=(Discipline)session.get(Discipline.class, disciplineId);
			session.delete(tmpDiscipline);
		}catch(Exception e){
			throw new DBException();
		}
		
	}
	
	public boolean checkDisciplineIdExists(Integer disciplineId)throws DBException{
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Discipline.class);
			criteria.add(Restrictions.eq(ClassAttributes.DisciplineAttributes.MDISCIPLINEID, disciplineId));
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
	public Discipline getDiscipline(Integer disciplineId) throws DBException {
		Discipline discipline=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Discipline.class);
			criteria.add(Restrictions.eq(ClassAttributes.DisciplineAttributes.MDISCIPLINEID, disciplineId));
			 discipline=(Discipline)criteria.uniqueResult();
		}catch(Exception e){
			throw new DBException();
		}
		return discipline;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Discipline> getDisciplineListForUniversity(Integer universityId)throws DBException {
		List<Discipline>disciplineList=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Discipline.class);
			criteria.add(Restrictions.eq("mUniversity.universityId", universityId));
			disciplineList=(List<Discipline>)criteria.list();
		}catch(Exception e){
			throw new DBException();
		}
		return disciplineList;
	}

}

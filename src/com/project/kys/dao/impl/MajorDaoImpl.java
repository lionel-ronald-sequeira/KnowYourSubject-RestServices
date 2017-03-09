package com.project.kys.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.project.kys.bo.Department;
import com.project.kys.bo.Major;
import com.project.kys.constants.Constants.ClassAttributes;
import com.project.kys.dao.MajorDao;
import com.project.kys.exception.DBException;

public class MajorDaoImpl implements MajorDao {
	
	private SessionFactory sessionFactory;
	
	public 	MajorDaoImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	}

	@Override
	public void addMajor(Major major) throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.save(major);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public void updateMajor(Major major) throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			Major tmpMajor=(Major)session.get(Major.class, major.getmMajorId());
			tmpMajor.setmMajorName(major.getmMajorName());
			tmpMajor.setmMajorInitials(major.getmMajorInitials());
			tmpMajor.setmMajorSummary(major.getmMajorSummary());
			tmpMajor.setmDepartment(major.getmDepartment());
			session.saveOrUpdate(tmpMajor);
		}catch(Exception e){
			throw new DBException();
		}
		
	}

	@Override
	public void deleteMajor(Integer majorId) throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			Major tmpMajor=(Major)session.get(Major.class, majorId);
			session.delete(tmpMajor);
		}catch(Exception e){
			throw new DBException();
		}
		
	}

	@Override
	public boolean checkMajorNameExists(String majorName) throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Major.class);
			criteria.add(Restrictions.eq(ClassAttributes.MajorAttributes.MMAJORNAME, majorName));
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
	public List<Major> getMajorListForDepartment(Integer departmentId)
			throws DBException {
		List<Major>majorListBo=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Major.class);
			criteria.add(Restrictions.eq(ClassAttributes.MajorAttributes.MMAJORDEPARTMENTID, departmentId));
			majorListBo=criteria.list();
		}catch(Exception e){
			throw new DBException();
		}
		return majorListBo;
	}

	@Override
	public Major getMajor(Integer majorId)throws DBException {
		Major major=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Major.class);
			criteria.add(Restrictions.eq(ClassAttributes.MajorAttributes.MMAJORID, majorId));
			major=(Major)criteria.uniqueResult();
		}catch(Exception e){
			throw new DBException();
		}
		return major;
	}

}

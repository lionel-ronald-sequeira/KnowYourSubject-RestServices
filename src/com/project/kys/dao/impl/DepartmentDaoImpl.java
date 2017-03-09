package com.project.kys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.project.kys.bo.Department;
import com.project.kys.bo.Discipline;
import com.project.kys.constants.Constants.ClassAttributes;
import com.project.kys.dao.DepartmentDao;
import com.project.kys.exception.DBException;

public class DepartmentDaoImpl implements DepartmentDao {

	private SessionFactory sessionFactory;
	
	public DepartmentDaoImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addDepartment(Department department) throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.save(department);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public void updateDepartment(Department department) throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			Department tmpDepartment=(Department)session.get(Department.class, department.getmDepartmentId());
			tmpDepartment.setmDepartmentName(department.getmDepartmentName());
			tmpDepartment.setmDepartmentInitials(department.getmDepartmentInitials());
			tmpDepartment.setmDepartmentSummary(department.getmDepartmentSummary());
			tmpDepartment.setmDiscipline(department.getmDiscipline());
			session.saveOrUpdate(tmpDepartment);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public void deleteDepartment(Integer departmentId) throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			Department tmpDepartment=(Department)session.get(Department.class, departmentId);
			session.delete(tmpDepartment);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public boolean checkDepartmentNameExists(String  departmentName)
			throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Department.class);
			criteria.add(Restrictions.eq(ClassAttributes.DepartmentAttributes.MDEPARTMENTNAME, departmentName).ignoreCase());
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartmentListForDiscipline(Integer disciplineId)
			throws DBException {
		List<Department>departmentListBo=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Department.class);
			criteria.add(Restrictions.eq(ClassAttributes.DepartmentAttributes.MDEPARTMENTDISCIPLINEID, disciplineId));
			departmentListBo=criteria.list();
		}catch(Exception e){
			throw new DBException();
		}
		return departmentListBo;
	}

	@Override
	public Department getDepartment(Integer departmentId) throws DBException {
		Department department=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Department.class);
			criteria.add(Restrictions.eq("mDepartmentId", departmentId));
			department=(Department)criteria.uniqueResult();
		}catch(Exception e){
			throw new DBException();
		}
		return department;
	}

	@Override
	public List<Department> getAllDepartments()throws DBException{
		List<Department>departmentList=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Department.class);
			departmentList=criteria.list();
		}catch(Exception e){
			throw new DBException();
		}
		return departmentList;
	}
}

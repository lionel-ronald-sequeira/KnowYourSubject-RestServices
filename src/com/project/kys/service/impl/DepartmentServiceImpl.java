package com.project.kys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.project.data.objects.Department;
import com.project.kys.bo.Discipline;
import com.project.kys.constants.StringConstants;
import com.project.kys.dao.DepartmentDao;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.service.DepartmentService;
import com.project.kys.utility.WebAppContext;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;
	
	@Transactional
	@Override
	public void addDepartment(Department department) throws BusinessException,
			DBException {
		com.project.kys.bo.Department departmentbo=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
			boolean result=false;
			departmentDao=(DepartmentDao)ctx.getBean("departmentDao");
			 result=departmentDao.checkDepartmentNameExists(department.getmDepartmentName());
			if(result){
				throw new BusinessException(StringConstants.DEPARTMENT_NAME_EXISTS_MSG);
			}
			departmentbo=createDepartmentObject(department);
			departmentDao.addDepartment(departmentbo);
	}

	@Transactional
	@Override
	public void updateDepartment(Department department)
			throws BusinessException, DBException {
		com.project.kys.bo.Department departmentbo=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		departmentDao=(DepartmentDao)ctx.getBean("departmentDao");
		departmentbo=createDepartmentObject(department);
		departmentDao.updateDepartment(departmentbo);
		
	}

	@Transactional
	@Override
	public void deleteDepartment(Integer departmentId) throws BusinessException,
			DBException {
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		departmentDao=(DepartmentDao)ctx.getBean("departmentDao");
		departmentDao.deleteDepartment(departmentId);
	}
	
	@Transactional
	@Override
	public List<Department> getDepartmentListForDiscipline(Integer disciplineId)
			throws BusinessException,DBException {
		List<com.project.kys.bo.Department>departmentBoList=null;
		List<Department>departmentDataObjectList=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		departmentDao=(DepartmentDao)ctx.getBean("departmentDao");
		departmentBoList=departmentDao.getDepartmentListForDiscipline(disciplineId);
		departmentDataObjectList=mapDepartmentBoToDepartmentDataObjects(departmentBoList);
		return departmentDataObjectList;
	}
	
	private com.project.kys.bo.Department createDepartmentObject(Department departmentDataObj){
		com.project.kys.bo.Department department=new com.project.kys.bo.Department();
		Discipline discipline=new Discipline();
		discipline.setmDisciplineId(departmentDataObj.getmDisciplineId());
		department.setmDepartmentId(departmentDataObj.getmDepartmentId());
		department.setmDepartmentName(departmentDataObj.getmDepartmentName());
		department.setmDepartmentInitials(departmentDataObj.getmDepartmentInitials());
		department.setmDepartmentSummary(departmentDataObj.getmDepartmentSummary());
		department.setmDiscipline(discipline);
		return department;
	}
	
	private List<Department> mapDepartmentBoToDepartmentDataObjects(List<com.project.kys.bo.Department>departmentBoList){
		List<Department> departmentDataObjList=new ArrayList<Department>();
		for(com.project.kys.bo.Department departmentbo:departmentBoList){
			Department departmentdataObj=new Department();
			departmentdataObj.setmDepartmentId(departmentbo.getmDepartmentId());
			departmentdataObj.setmDepartmentName(departmentbo.getmDepartmentName());
			departmentdataObj.setmDepartmentInitials(departmentbo.getmDepartmentInitials());
			departmentdataObj.setmDepartmentSummary(departmentbo.getmDepartmentSummary());
			departmentdataObj.setmDisciplineId(departmentbo.getmDiscipline().getmDisciplineId());
			departmentDataObjList.add(departmentdataObj);
		}
		return departmentDataObjList;
	}

	@Transactional
	@Override
	public Department getDepartment(Integer departmentId)
			throws BusinessException, DBException {
		com.project.kys.bo.Department department=null;
		List<Department>departmentDataObjectList=null;
		List<com.project.kys.bo.Department>departmentBoList=new ArrayList<com.project.kys.bo.Department>();
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		departmentDao=(DepartmentDao)ctx.getBean("departmentDao");
		department=departmentDao.getDepartment(departmentId);
		departmentBoList.add(department);
		departmentDataObjectList=mapDepartmentBoToDepartmentDataObjects(departmentBoList);
		return departmentDataObjectList.get(0);
	}

	@Transactional
	@Override
	public List<Department> getAllDepartments()
			throws BusinessException, DBException {
		List<Department>departmentDataObjectList=null;
		List<com.project.kys.bo.Department>departmentBoList=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		departmentDao=(DepartmentDao)ctx.getBean("departmentDao");
		departmentBoList=departmentDao.getAllDepartments();
		departmentDataObjectList=mapDepartmentBoToDepartmentDataObjects(departmentBoList);
		return departmentDataObjectList;
	}

}

package com.project.kys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.project.data.objects.Major;
import com.project.kys.bo.Department;
import com.project.kys.constants.StringConstants;
import com.project.kys.dao.DepartmentDao;
import com.project.kys.dao.MajorDao;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.service.MajorService;
import com.project.kys.utility.WebAppContext;

public class MajorServiceImpl implements MajorService {

	private MajorDao majorDao;
	
	@Transactional
	@Override
	public void addMajor(Major major) throws BusinessException, DBException {
		com.project.kys.bo.Major majorbo=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
			boolean result=false;
			majorDao=(MajorDao)ctx.getBean("majorDao");
			 result=majorDao.checkMajorNameExists(major.getmMajorName());
			if(result){
				throw new BusinessException(StringConstants.MAJOR_NAME_EXISTS_MSG);
			}
			majorbo=createMajorObject(major);
			majorDao.addMajor(majorbo);
	}

	@Transactional
	@Override
	public void updateMajor(Major major) throws BusinessException, DBException {
		com.project.kys.bo.Major majorbo=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		majorDao=(MajorDao)ctx.getBean("majorDao");
		majorbo=createMajorObject(major);
		majorDao.updateMajor(majorbo);
		
	}

	@Transactional
	@Override
	public void deleteMajor(Integer majorId) throws BusinessException,
			DBException {
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		majorDao=(MajorDao)ctx.getBean("majorDao");
		majorDao.deleteMajor(majorId);
		
	}

	@Transactional
	@Override
	public List<Major> getMajorListForDepartment(Integer departmentId)
			throws BusinessException, DBException {
		List<com.project.kys.bo.Major>majorBoList=null;
		List<Major>majorDataObjectList=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		majorDao=(MajorDao)ctx.getBean("majorDao");
		majorBoList=majorDao.getMajorListForDepartment(departmentId);
		majorDataObjectList=mapMajorBoToMajorDataObjects(majorBoList);
		return majorDataObjectList;
	}
	
	private com.project.kys.bo.Major createMajorObject(Major majorDataObj){
		com.project.kys.bo.Major major=new com.project.kys.bo.Major();
		Department department=new Department();
		department.setmDepartmentId(majorDataObj.getmDepartmentId());
		major.setmMajorId(majorDataObj.getmMajorId());
		major.setmMajorName(majorDataObj.getmMajorName());
		major.setmMajorInitials(majorDataObj.getmMajorInitials());
		major.setmMajorSummary(majorDataObj.getmMajorSummary());
		major.setmDepartment(department);
		return major;
	}
	
	private List<Major> mapMajorBoToMajorDataObjects(List<com.project.kys.bo.Major>majorBoList){
		List<Major> majorDataObjList=new ArrayList<Major>();
		for(com.project.kys.bo.Major majorbo:majorBoList){
			Major majordataObj=new Major();
			majordataObj.setmMajorId(majorbo.getmMajorId());
			majordataObj.setmMajorName(majorbo.getmMajorName());
			majordataObj.setmMajorInitials(majorbo.getmMajorInitials());
			majordataObj.setmMajorSummary(majorbo.getmMajorSummary());
			majordataObj.setmDepartmentId(majorbo.getmDepartment().getmDepartmentId());
			majorDataObjList.add(majordataObj);
		}
		return majorDataObjList;
	}

	@Transactional
	@Override
	public Major getMajor(Integer majorId) throws BusinessException,
			DBException {
		com.project.kys.bo.Major major=null;
		List<Major>majorDataObjectList=null;
		List<com.project.kys.bo.Major>majorBoList=new ArrayList<com.project.kys.bo.Major>();
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		majorDao=(MajorDao)ctx.getBean("majorDao");
		major=majorDao.getMajor(majorId);
		majorBoList.add(major);
		majorDataObjectList=mapMajorBoToMajorDataObjects(majorBoList);
		return majorDataObjectList.get(0);
	}

}

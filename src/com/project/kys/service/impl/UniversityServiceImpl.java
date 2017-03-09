package com.project.kys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.project.data.objects.University;
import com.project.kys.constants.StringConstants;
import com.project.kys.dao.UniversityDao;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.service.UniversityService;
import com.project.kys.utility.WebAppContext;

public class UniversityServiceImpl implements UniversityService {

	private UniversityDao universityDao;
	
	@Transactional
	@Override
	public void addUniversity(University university) throws BusinessException,
			DBException {
		com.project.kys.bo.University univ=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
			boolean result=false;
			universityDao=(UniversityDao)ctx.getBean("universityDao");
			 result=universityDao.checkUniversityNameExists(university.getmUniversityName());
			if(result){
				throw new BusinessException(StringConstants.UNIVERSITY_NAME_EXISTS_MSG);
			}
			univ=createUniversityObject(university);
			universityDao.addUniversity(univ);
		
	}

	@Transactional
	@Override
	public void updateUniversity(University university)
			throws BusinessException, DBException {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void deleteUniversity(Integer universityId)
			throws BusinessException, DBException {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public List<University> getUniversityList() throws BusinessException,
			DBException {
		List<com.project.kys.bo.University>universityBoList=null;
		List<University>universityDataObjectList=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		universityDao=(UniversityDao)ctx.getBean("universityDao");
		universityBoList=universityDao.getUniversityList();
		universityDataObjectList=mapUniversityBoToUniversityDataObjects(universityBoList);
		return universityDataObjectList;
	}
	
	private com.project.kys.bo.University createUniversityObject(University universityDataObj)throws BusinessException{
		com.project.kys.bo.University univ=new com.project.kys.bo.University();
		univ.setUniversityInitials(universityDataObj.getmUniversityInitials());
		univ.setUniversitySummary(universityDataObj.getmUniversitySummary());
		univ.setUniversityName(universityDataObj.getmUniversityName());
		univ.setUniversityCity(universityDataObj.getmUniversityCity());
		univ.setUniversityState(universityDataObj.getmUniversityState());
		univ.setUniversityCountry(universityDataObj.getmUniversityCountry());
		return univ;
	}
	
	private List<University> mapUniversityBoToUniversityDataObjects(List<com.project.kys.bo.University>universityBoList){
		List<University> universityDataObjList=new ArrayList<University>();
		for(com.project.kys.bo.University universitybo:universityBoList){
			University universitydataObj=new University();
			universitydataObj.setmUniversityId(universitybo.getUniversityId());
			universitydataObj.setmUniversityName(universitybo.getUniversityName());
			universitydataObj.setmUniversityInitials(universitybo.getUniversityInitials());
			universitydataObj.setmUniversitySummary(universitybo.getUniversitySummary());
			universitydataObj.setmUniversityCity(universitybo.getUniversityCity());
			universitydataObj.setmUniversityState(universitybo.getUniversityState());
			universitydataObj.setmUniversityCountry(universitybo.getUniversityCountry());
			universityDataObjList.add(universitydataObj);
		}
		return universityDataObjList;
	}

	@Transactional
	@Override
	public University getUniversity(String universityName)throws BusinessException,DBException{
		com.project.kys.bo.University  universityBo=null;
		List<com.project.kys.bo.University>universityBoList=new ArrayList<com.project.kys.bo.University>();
		List<University>universityDataObjectList=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		universityDao=(UniversityDao)ctx.getBean("universityDao");
		universityBo=universityDao.getUniversity(universityName);
		universityBoList.add(universityBo);
		universityDataObjectList=mapUniversityBoToUniversityDataObjects(universityBoList);
		return universityDataObjectList.get(0);
	}

}

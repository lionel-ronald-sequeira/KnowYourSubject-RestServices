package com.project.kys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.project.data.objects.Major;
import com.project.data.objects.Professor;
import com.project.kys.constants.StringConstants;
import com.project.kys.dao.MajorDao;
import com.project.kys.dao.ProfessorDao;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.service.ProfessorService;
import com.project.kys.utility.WebAppContext;

public class ProfessorServiceImpl implements ProfessorService {
	private ProfessorDao professorDao;
	
	@Transactional
	@Override
	public void addProfessor(Professor professor) throws BusinessException,
			DBException {
		boolean result=false;
		com.project.kys.bo.Professor profBo=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		professorDao=(ProfessorDao)ctx.getBean("professorDao");
		result=professorDao.checkEmailExists(professor.getmEmail());
		if(result){
			throw new BusinessException(StringConstants.PROFESSOR_EMAIL_EXISTS_MSG);
		}
		profBo=createProfessorObject(professor);
		professorDao.addProfessor(profBo);
	}

	@Transactional
	@Override
	public void updateProfessor(Professor professor) throws BusinessException,
			DBException {
		com.project.kys.bo.Professor profBo=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		professorDao=(ProfessorDao)ctx.getBean("professorDao");
		profBo=createProfessorObject(professor);
		professorDao.updateProfessor(profBo);
	}

	@Transactional
	@Override
	public void deleteProfessor(Integer professorId) throws BusinessException,
			DBException {
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		professorDao=(ProfessorDao)ctx.getBean("professorDao");
		professorDao.deleteProfessor(professorId);
	}

	@Transactional
	@Override
	public List<Professor> getProfessorListForCourse(Integer courseId)
			throws BusinessException, DBException {
		List<com.project.kys.bo.Professor>profBoList=null;
		List<Professor>profDataBoList=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		professorDao=(ProfessorDao)ctx.getBean("professorDao");
		profBoList=professorDao.getProfessorListForCourse(courseId);
		profDataBoList=mapProfessorBoToProfessorDataObjects(profBoList);
		return profDataBoList;
	}

	private com.project.kys.bo.Professor createProfessorObject(Professor profDataObj){
		com.project.kys.bo.Professor profBo=new com.project.kys.bo.Professor();
		profBo.setmProfessorId(profDataObj.getmProfessorId());
		profBo.setmName(profDataObj.getmProfessorName());
		profBo.setmEmail(profDataObj.getmEmail());
		profBo.setmContact(profDataObj.getmContact());
		profBo.setmUrl(profDataObj.getmUrl());
		return profBo;
	}
	
	private List<Professor> mapProfessorBoToProfessorDataObjects(List<com.project.kys.bo.Professor>profBoList){
		List<Professor>professorDataObjList=new ArrayList<Professor>();
		for(com.project.kys.bo.Professor profBo:profBoList){
			Professor profDataObj=new Professor();
			profDataObj.setmProfessorId(profBo.getmProfessorId());
			profDataObj.setmProfessorName(profBo.getmName());
			profDataObj.setmEmail(profBo.getmEmail());
			profDataObj.setmUrl(profBo.getmUrl());
			profDataObj.setmContact(profBo.getmContact());
				professorDataObjList.add(profDataObj);
			}
		
		return professorDataObjList;
	}

	@Override
	public Professor getProfessor(Integer professorId)throws BusinessException,DBException{
		List<Professor>profDataBoList=null;
		com.project.kys.bo.Professor profBo=null;
		List<com.project.kys.bo.Professor>profBoList=new ArrayList<com.project.kys.bo.Professor>();
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		professorDao=(ProfessorDao)ctx.getBean("professorDao");
		profBo=professorDao.getProfessor(professorId);
		profBoList.add(profBo);
		profDataBoList=mapProfessorBoToProfessorDataObjects(profBoList);
		return profDataBoList.get(0);
	}

	@Override
	@Transactional
	public List<Professor> getAllProfessor() throws BusinessException,
			DBException {
		List<com.project.kys.bo.Professor>profBoList=null;
		List<Professor>profDataBoList=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		professorDao=(ProfessorDao)ctx.getBean("professorDao");
		profBoList=professorDao.getAllProfessor();
		profDataBoList=mapProfessorBoToProfessorDataObjects(profBoList);
		return profDataBoList;
	}
}

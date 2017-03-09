package com.project.kys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.project.data.objects.Discipline;
import com.project.data.objects.University;
import com.project.kys.constants.StringConstants;
import com.project.kys.dao.DisciplineDao;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.service.DisciplineService;
import com.project.kys.utility.WebAppContext;

public class DisciplineServiceImpl implements DisciplineService {

	private DisciplineDao disciplineDao;
	
	@Transactional
	@Override
	public void addDiscipline(Discipline discipline) throws BusinessException, DBException {
		com.project.kys.bo.Discipline discip=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
			boolean result=false;
			disciplineDao=(DisciplineDao)ctx.getBean("disciplineDao");
			 result=disciplineDao.checkDisciplineIdExists(discipline.getmDisciplineId());
			if(result){
				throw new BusinessException(StringConstants.DISCIPLINE_ID_EXISTS_MSG);
			}
			discip=createDisciplineObject(discipline);
			disciplineDao.addDiscipline(discip);
	}

	@Transactional
	@Override
	public void updateDiscipline(Discipline discipline)throws BusinessException, DBException {
		com.project.kys.bo.Discipline discip=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		disciplineDao=(DisciplineDao)ctx.getBean("disciplineDao");
		discip=createDisciplineObject(discipline);
		disciplineDao.updateDiscipline(discip);
	}

	@Transactional
	@Override
	public void deleteDiscipline(Integer dispID)throws BusinessException, DBException{
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		disciplineDao=(DisciplineDao)ctx.getBean("disciplineDao");
		disciplineDao.deleteDiscipline(dispID);
	}

	@Transactional
	@Override
	public List<Discipline> getDisciplineListForUniversity(Integer universityId)throws BusinessException,DBException{
		List<com.project.kys.bo.Discipline>disciplineBoList=null;
		List<Discipline>disciplineDataObjList=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		disciplineDao=(DisciplineDao)ctx.getBean("disciplineDao");
		disciplineBoList=disciplineDao.getDisciplineListForUniversity(universityId);
		disciplineDataObjList=mapDisciplineBotoDisciplineDataObject(disciplineBoList);
		return disciplineDataObjList;
	}
	
	private com.project.kys.bo.Discipline createDisciplineObject(Discipline disciplineDataObj)throws BusinessException{
		com.project.kys.bo.Discipline disp=new com.project.kys.bo.Discipline();
		disp.setmDisciplineId(disciplineDataObj.getmDisciplineId());
		disp.setmDisciplineInitials(disciplineDataObj.getmDisciplineInitials());
		disp.setmDisciplineSummary(disciplineDataObj.getmDisciplineSummary());
		disp.setmDisciplineName(disciplineDataObj.getmDisciplineName());
		com.project.kys.bo.University university=new com.project.kys.bo.University();
		university.setUniversityId(disciplineDataObj.getmUniversityId());
		disp.setmUniversity(university);
		return disp;
	}

	@Transactional
	@Override
	public Discipline getDiscipline(Integer dispID) throws BusinessException,
			DBException {
		com.project.kys.bo.Discipline disciplinebo=null;
		List<com.project.kys.bo.Discipline>disciplineList=new ArrayList<com.project.kys.bo.Discipline>();
		Discipline disciplineDataObj=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		disciplineDao=(DisciplineDao)ctx.getBean("disciplineDao");
		disciplinebo=disciplineDao.getDiscipline(dispID);
		disciplineList.add(disciplinebo);
		disciplineDataObj=mapDisciplineBotoDisciplineDataObject(disciplineList).get(0);
		return disciplineDataObj;
	}
	
	private List<Discipline> mapDisciplineBotoDisciplineDataObject(List<com.project.kys.bo.Discipline> disciplineBoList){
		List<Discipline>disciplineDataObjList=new ArrayList<Discipline>();
		for(com.project.kys.bo.Discipline disciplineBo:disciplineBoList){
			Discipline disciplineDataObj=new Discipline();
			disciplineDataObj.setmDisciplineId(disciplineBo.getmDisciplineId());
			disciplineDataObj.setmDisciplineInitials(disciplineBo.getmDisciplineInitials());
			disciplineDataObj.setmDisciplineName(disciplineBo.getmDisciplineName());
			disciplineDataObj.setmDisciplineSummary(disciplineBo.getmDisciplineSummary());
			disciplineDataObj.setmDisciplineId(disciplineBo.getmDisciplineId());
			disciplineDataObj.setmUniversityId(disciplineBo.getmUniversity().getUniversityId());
			disciplineDataObjList.add(disciplineDataObj);
		}
		return disciplineDataObjList;
	}

}

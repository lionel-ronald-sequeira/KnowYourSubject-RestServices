package com.project.kys.service;

import java.util.List;

import com.project.data.objects.Discipline;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;

public interface DisciplineService {
	
	public void addDiscipline(Discipline discipline)throws BusinessException,DBException;
	
	public void updateDiscipline(Discipline discipline)throws BusinessException,DBException;
	
	public void deleteDiscipline(Integer dispID)throws BusinessException,DBException;

	public List<Discipline> getDisciplineListForUniversity(Integer universityId)throws BusinessException,DBException;
	
	public Discipline getDiscipline(Integer dispID)throws BusinessException,DBException;

}

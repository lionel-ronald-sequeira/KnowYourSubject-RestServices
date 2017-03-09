package com.project.kys.service;

import java.util.List;

import com.project.data.objects.Professor;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;

public interface ProfessorService {
	void addProfessor(Professor professor)throws BusinessException,DBException;
	
	void updateProfessor(Professor professor)throws BusinessException,DBException;
	
	void deleteProfessor(Integer professorId)throws BusinessException,DBException;
	
	List<Professor> getProfessorListForCourse(Integer courseId)throws BusinessException,DBException;
	
	Professor getProfessor(Integer professorId)throws BusinessException,DBException;
	
	List<Professor>getAllProfessor()throws BusinessException,DBException;
}

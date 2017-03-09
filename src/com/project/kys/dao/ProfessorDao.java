package com.project.kys.dao;

import java.util.List;

import com.project.kys.bo.Professor;
import com.project.kys.exception.DBException;

public interface ProfessorDao {
	void addProfessor(Professor professor)throws DBException;
	
	void updateProfessor(Professor professor)throws DBException;
	
	void deleteProfessor(Integer professorId)throws DBException;
	
	List<Professor> getProfessorListForCourse(Integer courseId)throws DBException;
	
	boolean checkEmailExists(String emailId)throws DBException;
	
	public Professor getProfessor(Integer professorId)throws DBException;
	
	public List<Professor>getAllProfessor()throws DBException;
	
}

package com.project.kys.dao;

import java.util.List;

import com.project.kys.bo.Discipline;
import com.project.kys.exception.DBException;

public interface DisciplineDao {
	
	void addDiscipline(Discipline discipline)throws DBException;
	
	void updateDiscipline(Discipline discipline)throws DBException;
	
	void deleteDiscipline(Integer disciplineId)throws DBException;
	
	boolean checkDisciplineIdExists(Integer disciplineId)throws DBException;
	
	Discipline getDiscipline(Integer disciplineId)throws DBException;
	
	List<Discipline>getDisciplineListForUniversity(Integer universityId)throws DBException;
}


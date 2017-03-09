package com.project.kys.rest.service;

import javax.ws.rs.core.Response;

import com.project.data.objects.Discipline;
import com.project.data.objects.University;

public interface DisciplineRestService {
	Response addDiscipline(Discipline discipline);
	
	Response getDiscipline(Discipline discp);
	
	Response updateDiscipline(Discipline discipline);
	
	Response deleteDiscipline(Discipline discipline);
	
	Response getDisciplineListForUniversity(University university);

}

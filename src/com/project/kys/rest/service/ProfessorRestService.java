package com.project.kys.rest.service;

import javax.ws.rs.core.Response;

import com.project.data.objects.Course;
import com.project.data.objects.Professor;

public interface ProfessorRestService {
	public Response addProfessor(Professor professor);
	
	public Response updateProfessor(Professor professor);
	
	public Response deleteProfessor(Professor professor);
	
	public Response getProfessorListForCourse(Course course);
	
	public Response getProfessor(Professor professor);
	
	public Response getAllProfessor();
	
}

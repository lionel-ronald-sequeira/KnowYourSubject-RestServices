package com.project.kys.rest.service;

import javax.ws.rs.core.Response;

import com.project.data.objects.Course;
import com.project.data.objects.Major;
import com.project.data.objects.Professor;

public interface CourseRestService {
	public Response addCourse(Course course);
	
	public Response updateCourse(Course course);
	
	public Response deleteCourse(Course course);
	
	public Response getCourseListForMajor(Major major);
	
	public Response getCourseListForProfessor(Professor professor);
	
	public Response getCourse(Course course);
}

package com.project.kys.dao;

import java.util.List;

import com.project.kys.bo.Course;
import com.project.kys.bo.Professor;
import com.project.kys.exception.DBException;

public interface CourseDao {
	void addCourse(Course course)throws DBException;
	
	void updateCourse(Course course)throws DBException;
	
	void deleteCourse(Integer courseId)throws DBException;
	
	List<Course>getCourseListForMajor(Integer majorId)throws DBException;
	
	public List<Course> getCourseListForProfessor(Integer professorId)
			throws DBException;
	
	boolean checkCourseNameExists(String courseName)throws DBException;
	
	public Course getCourse(Integer courseId)throws DBException;
	
}

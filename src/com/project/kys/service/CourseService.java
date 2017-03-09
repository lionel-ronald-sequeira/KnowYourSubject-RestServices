package com.project.kys.service;

import java.util.List;




import com.project.data.objects.Course;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;

public interface CourseService {
	void addCourse(Course course)throws BusinessException,DBException;
	
	void updateCourse(Course course)throws BusinessException,DBException;
	
	void deleteCourse(Integer courseId)throws BusinessException,DBException;

	List<Course> getCourseListForMajor(Integer majorId)throws BusinessException,DBException;
	
	List<Course> getCourseListForProfessor(Integer professorId)
			throws BusinessException,DBException;
	
	Course getCourse(Integer courseId)throws BusinessException,DBException;

}

package com.project.kys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.project.data.objects.Course;
import com.project.kys.bo.Professor;
import com.project.kys.constants.StringConstants;
import com.project.kys.dao.CourseDao;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.service.CourseService;
import com.project.kys.utility.WebAppContext;

public class CourseServiceImpl implements CourseService{
	
	private CourseDao courseDao;
	
	@Override
	@Transactional
	public void addCourse(Course course) throws BusinessException, DBException {
		boolean result=false;
		com.project.kys.bo.Course courseBo=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		courseDao=(CourseDao)ctx.getBean("courseDao");
		result=courseDao.checkCourseNameExists(course.getmCourseCode());
		if(result){
			throw new BusinessException(StringConstants.COURSE_CODE_EXISTS_MSG);
		}
		courseBo=createCourseObject(course);
		courseDao.addCourse(courseBo);
	}

	@Override
	@Transactional
	public void updateCourse(Course course) throws BusinessException,
			DBException {
		com.project.kys.bo.Course courseBo=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		courseDao=(CourseDao)ctx.getBean("courseDao");
		courseBo=createCourseObject(course);
		courseDao.updateCourse(courseBo);
		
	}

	@Override
	@Transactional
	public void deleteCourse(Integer courseId) throws BusinessException,
			DBException {
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		courseDao=(CourseDao)ctx.getBean("courseDao");
		courseDao.deleteCourse(courseId);
		
	}
	
	@Override
	@Transactional
	public List<Course> getCourseListForMajor(Integer majorId)
			throws BusinessException, DBException {
		List<com.project.kys.bo.Course>courseBoList=null;
		List<Course>courseDataBoList=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		courseDao=(CourseDao)ctx.getBean("courseDao");
		courseBoList=courseDao.getCourseListForMajor(majorId);
		courseDataBoList= mapCourseBoToCourseDataObjects(courseBoList);
		return courseDataBoList;
	}
	
	private com.project.kys.bo.Course createCourseObject(Course courseDataObj){
		com.project.kys.bo.Course course=new com.project.kys.bo.Course();
		com.project.kys.bo.Major major=new com.project.kys.bo.Major();
		List<Professor>profList=null;
		major.setmMajorId(courseDataObj.getmMajorId());
		course.setmCourseId(courseDataObj.getmCourseId());
		course.setmCourseName(courseDataObj.getmCourseName());
		course.setmCourseCode(courseDataObj.getmCourseCode());
		course.setmCourseInitials(courseDataObj.getmCourseInitials());
		course.setmCourseSummary(courseDataObj.getmCourseSummary());
		course.setmMajor(major);
		if(courseDataObj.getmProfessorIds()!=null){
			for(Integer profId:courseDataObj.getmProfessorIds()){
				Professor prof=new Professor();
				prof.setmProfessorId(profId);
				if(profList==null){
					profList=new ArrayList<Professor>();
				}
				profList.add(prof);
			}
		}
		course.setmProfessorList(profList);
		return course;
	}
	
	private List<Course> mapCourseBoToCourseDataObjects(List<com.project.kys.bo.Course>courseBoList){
		List<Course> courseDataObjList=new ArrayList<Course>();
		for(com.project.kys.bo.Course courseBo:courseBoList){
			Course courseDataObj=new Course();
			courseDataObj.setmCourseId(courseBo.getmCourseId());
			courseDataObj.setmCourseInitials(courseBo.getmCourseInitials());
			courseDataObj.setmCourseSummary(courseBo.getmCourseSummary());
			courseDataObj.setmCourseName(courseBo.getmCourseName());
			courseDataObj.setmMajorId(courseBo.getmMajor().getmMajorId());
			courseDataObj.setmCourseRating(courseBo.getmRating());
			courseDataObj.setmFeedbackCount(courseBo.getmFeedbackCount());
			courseDataObj.setmCourseCode(courseBo.getmCourseCode());
			courseDataObj.setmCourseCode(courseBo.getmCourseCode());
			List<Integer>profIds=new ArrayList<Integer>();
			for(Professor prof:courseBo.getmProfessorList()){
				profIds.add(prof.getmProfessorId());
			}
			courseDataObjList.add(courseDataObj);
		}
		return courseDataObjList;
	}

	@Override
	@Transactional
	public List<Course> getCourseListForProfessor(Integer professorId)
			throws BusinessException, DBException {
		List<com.project.kys.bo.Course>courseBoList=null;
		List<Course>courseDataObjList=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		courseDao=(CourseDao)ctx.getBean("courseDao");
		courseBoList=courseDao.getCourseListForProfessor(professorId);
		courseDataObjList= mapCourseBoToCourseDataObjects(courseBoList);
		return courseDataObjList;	
	}

	@Transactional
	@Override
	public Course getCourse(Integer courseId)throws BusinessException,DBException{
		com.project.kys.bo.Course courseBo=null;
		List<Course>courseDataObjList=null;
		List<com.project.kys.bo.Course>courseBoList=new ArrayList<com.project.kys.bo.Course>();
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		courseDao=(CourseDao)ctx.getBean("courseDao");
		courseBo=courseDao.getCourse(courseId);
		courseBoList.add(courseBo);
		courseDataObjList=mapCourseBoToCourseDataObjects(courseBoList);
		return courseDataObjList.get(0);
	}

}

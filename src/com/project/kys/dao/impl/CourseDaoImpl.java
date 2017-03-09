package com.project.kys.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.project.kys.bo.Course;
import com.project.kys.bo.Major;
import com.project.kys.bo.Professor;
import com.project.kys.constants.Constants.ClassAttributes;
import com.project.kys.dao.CourseDao;
import com.project.kys.exception.DBException;

public class CourseDaoImpl implements CourseDao{

	private SessionFactory sessionFactory;
	
	public 	CourseDaoImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addCourse(Course course) throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.save(course);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public void updateCourse(Course course)throws DBException {
		try{
			List<Professor>professorList=null;
			Session session=sessionFactory.getCurrentSession();
			Course tmpCourse=(Course)session.get(Course.class, course.getmCourseId());
			//tmpCourse.setmCourseName(course.getmCourseName());
			//tmpCourse.setmCourseSummary(course.getmCourseSummary());
			//tmpCourse.setmCourseInitials(course.getmCourseInitials());
			//tmpCourse.setmMajor(course.getmMajor());
			//tmpCourse.setmFeedbackCount(course.getmFeedbackCount());
			if(course.getmProfessorList() !=null || course.getmProfessorList().size()>0){
				professorList=tmpCourse.getmProfessorList();
				for(Professor professor:course.getmProfessorList()){
					professorList.add(professor);
				}
				tmpCourse.setmProfessorList(professorList);
			}
			
			//tmpCourse.setmRating(course.getmRating());
			session.saveOrUpdate(tmpCourse);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public void deleteCourse(Integer courseId)throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			Course course=(Course)session.get(Course.class, courseId);
			session.delete(course);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getCourseListForMajor(Integer majorId)throws DBException {
		List<Course>courseList=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Course.class);
			criteria.add(Restrictions.eq("mMajor.mMajorId", majorId));
			courseList=criteria.list();
			return courseList;
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public List<Course> getCourseListForProfessor(Integer professorId)
			throws DBException {
		List<Course>courseList=null;
		Professor professor=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Professor.class);
			criteria.add(Restrictions.eq("mProfessorId", professorId));
			professor=(Professor)criteria.uniqueResult();
			courseList=professor.getmCourseList();
		}catch(Exception e){
			throw new DBException();
		}
		return courseList;
	}

	@Override
	public boolean checkCourseNameExists(String courseName) throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Course.class);
			criteria.add(Restrictions.eq("mCourseCode", courseName));
			criteria.setProjection(Projections.rowCount());
			Long count=(Long)criteria.uniqueResult();
			if (count==0)
			return false;
			else
			return true;
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public Course getCourse(Integer courseId)throws DBException{
		Course course=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Course.class);
			criteria.add(Restrictions.eq("mCourseId", courseId));
			course=(Course)criteria.uniqueResult();
		}catch(Exception e){
			throw new DBException();
		}
		return course;
	}
	
}

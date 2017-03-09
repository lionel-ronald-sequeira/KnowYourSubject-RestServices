package com.project.kys.dao;

import java.util.List;

import com.project.kys.bo.Feedback;
import com.project.kys.exception.DBException;

public interface FeedbackDao {

	void addFeedback(Feedback feedback)throws DBException;
	
	void updateFeedback(Feedback feedback)throws DBException;
	
	void deleteFeedback(Integer feedbackId)throws DBException;
	
	List<Feedback>getFeedbackListForUser(Integer userId,Integer courseId)throws DBException;
	
	List<Feedback>getFeedbackListForCourse(Integer courseId)throws DBException;
	
	List<Feedback>getFeedbackListForProfessor(Integer professorId,Integer courseId)throws DBException;
	
	List<Feedback>getFeedbackListForComment(String comment)throws DBException;
	
	boolean checkFeedbackExistsForUserForParticularCourseProfessor(Integer userId,Integer courseId,Integer professorId)throws DBException;
	
	Feedback getFeedbackForUserForCourse(Integer userId,Integer courseId)throws DBException;
	
	boolean checkFeedbackForUserForCourseExists(Integer userId,Integer courseId)throws DBException;

}

package com.project.kys.service;

import java.util.List;
import com.project.data.objects.Feedback;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;

public interface FeedbackService {

	void addFeedback(Feedback feedback)throws BusinessException, DBException;
	
	void updateFeedback(Feedback feedback)throws BusinessException,DBException;
	
	void deleteFeedback(Integer feedbackId)throws BusinessException,DBException;
	
	List<Feedback>getFeedbackListForUser(Integer userId,Integer courseId)throws BusinessException,DBException;
	
	List<Feedback>getFeedbackListForCourse(Integer courseId)throws BusinessException,DBException;
	
	List<Feedback>getFeedbackListForProfessor(Integer professorId,Integer courseId)throws BusinessException,DBException;
	
	List<Feedback>getFeedbackListForComment(String comment)throws BusinessException,DBException;
	
	Feedback getFeedbackForUserForCourse(Integer userId,Integer courseId)throws BusinessException,DBException;
	
}

package com.project.kys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.project.data.objects.Feedback;
import com.project.kys.bo.Course;
import com.project.kys.bo.Professor;
import com.project.kys.bo.User;
import com.project.kys.constants.StringConstants;
import com.project.kys.dao.FeedbackDao;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.service.FeedbackService;
import com.project.kys.utility.WebAppContext;

public class FeedbackServiceImpl implements FeedbackService{

	private FeedbackDao feedbackDao;
	
	@Transactional
	@Override
	public void addFeedback(Feedback feedback) throws BusinessException,
			DBException {
		boolean result=false;
		com.project.kys.bo.Feedback feedbackBo=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		feedbackDao=(FeedbackDao)ctx.getBean("feedbackDao");
		result=feedbackDao.checkFeedbackExistsForUserForParticularCourseProfessor(feedback.getmUserId(), feedback.getmCourseId(), 
				feedback.getmProfessorId());
		if(result){
			throw new BusinessException(StringConstants.FEEDBACK_EXISTS);
		}
		feedbackBo=createFeedbackObject(feedback);
		feedbackDao.addFeedback(feedbackBo);
	}

	@Transactional
	@Override
	public void updateFeedback(Feedback feedback) throws BusinessException,
			DBException {
		com.project.kys.bo.Feedback feedbackBo=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		feedbackDao=(FeedbackDao)ctx.getBean("feedbackDao");
		feedbackBo=createFeedbackObject(feedback);
		feedbackDao.updateFeedback(feedbackBo);
	}

	@Transactional
	@Override
	public void deleteFeedback(Integer feedbackId) throws BusinessException,
			DBException {
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		feedbackDao=(FeedbackDao)ctx.getBean("feedbackDao");
		feedbackDao.deleteFeedback(feedbackId);
	}

	@Transactional
	@Override
	public List<Feedback> getFeedbackListForUser(Integer userId,Integer courseId)
			throws BusinessException, DBException {
		List<com.project.kys.bo.Feedback>feedBackBoList=null;
		List<Feedback>feedBackDataObjList=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		feedbackDao=(FeedbackDao)ctx.getBean("feedbackDao");
		feedBackBoList=feedbackDao.getFeedbackListForUser(userId,courseId);
		feedBackDataObjList=mapFeedbackBotoFeedbackDataObject(feedBackBoList);
		return feedBackDataObjList;
	}

	@Transactional
	@Override
	public List<Feedback> getFeedbackListForCourse(Integer courseId)
			throws BusinessException, DBException {
		List<com.project.kys.bo.Feedback>feedBackBoList=null;
		List<Feedback>feedBackDataObjList=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		feedbackDao=(FeedbackDao)ctx.getBean("feedbackDao");
		feedBackBoList=feedbackDao.getFeedbackListForCourse(courseId);
		feedBackDataObjList=mapFeedbackBotoFeedbackDataObject(feedBackBoList);
		return feedBackDataObjList;
	}

	@Transactional
	@Override
	public List<Feedback> getFeedbackListForProfessor(Integer professorId,Integer courseId)
			throws BusinessException, DBException {
		List<com.project.kys.bo.Feedback>feedBackBoList=null;
		List<Feedback>feedBackDataObjList=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		feedbackDao=(FeedbackDao)ctx.getBean("feedbackDao");
		feedBackBoList=feedbackDao.getFeedbackListForProfessor(professorId,courseId);
		feedBackDataObjList=mapFeedbackBotoFeedbackDataObject(feedBackBoList);
		return feedBackDataObjList;
	}

	@Transactional
	@Override
	public List<Feedback> getFeedbackListForComment(String comment)
			throws BusinessException, DBException {
		List<com.project.kys.bo.Feedback>feedBackBoList=null;
		List<Feedback>feedBackDataObjList=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		feedbackDao=(FeedbackDao)ctx.getBean("feedbackDao");
		feedBackBoList=feedbackDao.getFeedbackListForComment(comment);
		feedBackDataObjList=mapFeedbackBotoFeedbackDataObject(feedBackBoList);
		return feedBackDataObjList;
	}
	
	private com.project.kys.bo.Feedback createFeedbackObject(Feedback feedback)throws BusinessException{
		com.project.kys.bo.Feedback feedbackBo=new com.project.kys.bo.Feedback();
		feedbackBo.setmTitle(feedback.getmTitle());
		feedbackBo.setmComment(feedback.getmComment());
		feedbackBo.setmIsSpam(feedback.getmIsSpam());
		feedbackBo.setmIsAnonymous(feedback.getmIsAnonymous());
		feedbackBo.setmHelpfulnessCount(feedback.getmHelpfulnessCount());
		feedbackBo.setmUnhelpfulnessCount(feedback.getmUnhelpfulnessCount());
		feedbackBo.setmRating(feedback.getmRating());
		feedbackBo.setmDate(new Date());
		feedbackBo.setmFeedbackId(feedback.getmFeedbackId());
		User user=new User();
		user.setmUserId(feedback.getmUserId());
		feedbackBo.setmUser(user);
		Professor professor=new Professor();
		professor.setmProfessorId(feedback.getmProfessorId());
		feedbackBo.setmProfessor(professor);
		Course course=new Course();
		course.setmCourseId(feedback.getmCourseId());
		feedbackBo.setmCourse(course);
		return feedbackBo;
	}
	
	private List<Feedback>mapFeedbackBotoFeedbackDataObject(List<com.project.kys.bo.Feedback>feedBackBoList){
		List<Feedback>feedBackDataObjectsList=new ArrayList<Feedback>();
		for(com.project.kys.bo.Feedback feedbackBo:feedBackBoList){
			Feedback feedbackDataObj=new Feedback();
			feedbackDataObj.setmFeedbackId(feedbackBo.getmFeedbackId());
			feedbackDataObj.setmTitle(feedbackBo.getmTitle());
			feedbackDataObj.setmComment(feedbackBo.getmComment());
			feedbackDataObj.setmCourseName(feedbackBo.getmCourse().getmCourseName());
			feedbackDataObj.setmCourseId(feedbackBo.getmCourse().getmCourseId());
			feedbackDataObj.setmProfessorId(feedbackBo.getmProfessor().getmProfessorId());
			feedbackDataObj.setmProfessorName(feedbackBo.getmProfessor().getmName());
			feedbackDataObj.setmUserId(feedbackBo.getmUser().getmUserId());
			feedbackDataObj.setmUserName(feedbackBo.getmUser().getmFirstName()+" "+feedbackBo.getmUser().getmLastName());
			feedbackDataObj.setmIsAnonymous(feedbackBo.getmIsAnonymous());
			feedbackDataObj.setmIsSpam(feedbackBo.getmIsSpam());
			feedbackDataObj.setmHelpfulnessCount(feedbackBo.getmHelpfulnessCount());
			feedbackDataObj.setmUnhelpfulnessCount(feedbackBo.getmUnhelpfulnessCount());
			feedbackDataObj.setmRating(feedbackBo.getmRating());
			feedbackDataObj.setmDate(feedbackBo.getmDate());
			feedBackDataObjectsList.add(feedbackDataObj);
		}
		return feedBackDataObjectsList;
	}

	@Transactional
	@Override
	public Feedback getFeedbackForUserForCourse(Integer userId,
			Integer courseId) throws BusinessException, DBException {
		boolean result=false;
		List<com.project.kys.bo.Feedback>feedBackBoList=new ArrayList<com.project.kys.bo.Feedback>();
		List<Feedback>feedBackDataObjList=null;
		com.project.kys.bo.Feedback feedbackBo=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		feedbackDao=(FeedbackDao)ctx.getBean("feedbackDao");
		result=feedbackDao.checkFeedbackForUserForCourseExists(userId, courseId);
		if(result){
			feedbackBo=feedbackDao.getFeedbackForUserForCourse(userId, courseId);
			feedBackBoList.add(feedbackBo);
			feedBackDataObjList=mapFeedbackBotoFeedbackDataObject(feedBackBoList);
			return feedBackDataObjList.get(0) ;
		}else{
			throw new BusinessException(StringConstants.ERROR_NO_DATA);
		}
		
	}

}

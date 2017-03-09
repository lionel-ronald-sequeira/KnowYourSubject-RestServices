package com.project.kys.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.project.kys.bo.Feedback;
import com.project.kys.bo.Major;
import com.project.kys.dao.FeedbackDao;
import com.project.kys.exception.DBException;

public class FeedbackDaoImpl implements FeedbackDao{

	private SessionFactory sessionFactory;
	
	public 	FeedbackDaoImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addFeedback(Feedback feedback) throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.save(feedback);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@Override
	public void updateFeedback(Feedback feedback) throws DBException {
		Feedback tmpFeedback=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			tmpFeedback=(Feedback)session.get(Feedback.class, feedback.getmFeedbackId());
			tmpFeedback.setmTitle(feedback.getmTitle());
			tmpFeedback.setmComment(feedback.getmComment());
			tmpFeedback.setmRating(feedback.getmRating());
			tmpFeedback.setmUnhelpfulnessCount(feedback.getmUnhelpfulnessCount());
			tmpFeedback.setmHelpfulnessCount(feedback.getmHelpfulnessCount());
			tmpFeedback.setmIsAnonymous(feedback.getmIsAnonymous());
			tmpFeedback.setmIsSpam(feedback.getmIsAnonymous());
			tmpFeedback.setmProfessor(feedback.getmProfessor());
			tmpFeedback.setmCourse(feedback.getmCourse());
			session.update(tmpFeedback);
		}catch(Exception e){
			throw new DBException();
		}

	}

	@Override
	public void deleteFeedback(Integer feedbackId) throws DBException {
		Feedback feedback=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			feedback=(Feedback)session.get(Feedback.class, feedbackId);
			session.delete(feedback);
		}catch(Exception e){
			throw new DBException();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> getFeedbackListForUser(Integer userId,Integer courseId)
			throws DBException {
		List<Feedback>feedBackList=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Feedback.class);
			if(userId!=0){
				criteria.add(Restrictions.eq("mUser.mUserId", userId));
			}
			if(courseId!=0){
				criteria.add(Restrictions.eq("mCourse.mCourseId", courseId));
			}
			feedBackList=criteria.list();
		}catch(Exception e){
			throw new DBException();
		}
		return feedBackList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> getFeedbackListForCourse(Integer courseId)
			throws DBException {
		List<Feedback>feedBackList=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Feedback.class);
			criteria.add(Restrictions.eq("mCourse.mCourseId", courseId));
			feedBackList=criteria.list();
		}catch(Exception e){
			throw new DBException();
		}
		return feedBackList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> getFeedbackListForProfessor(Integer professorId,Integer courseId)
			throws DBException {
		List<Feedback>feedBackList=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Feedback.class);
			criteria.add(Restrictions.eq("mProfessor.mProfessorId", professorId));
			criteria.add(Restrictions.eq("mCourse.mCourseId", courseId));
			feedBackList=criteria.list();
		}catch(Exception e){
			throw new DBException();
		}
		return feedBackList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> getFeedbackListForComment(String comment)
			throws DBException {
		List<Feedback>feedBackList=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Feedback.class);
			criteria.add(Restrictions.ilike("mComment", comment));
			feedBackList=criteria.list();
		}catch(Exception e){
			throw new DBException();
		}
		return feedBackList;

	}

	@Override
	public boolean checkFeedbackExistsForUserForParticularCourseProfessor(
			Integer userId, Integer courseId, Integer professorId)throws DBException{
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Feedback.class);
			criteria.add(Restrictions.eq("mUser.mUserId",userId));
			criteria.add(Restrictions.eq("mCourse.mCourseId",courseId));
			//criteria.add(Restrictions.eq("mProfessor.mProfessorId",professorId));
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

	@SuppressWarnings("unchecked")
	@Override
	public Feedback getFeedbackForUserForCourse(Integer userId,
			Integer courseId)throws DBException{
		Feedback feedback=null;
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Feedback.class);
			criteria.add(Restrictions.eq("mUser.mUserId",userId));
			criteria.add(Restrictions.eq("mCourse.mCourseId",courseId));
			feedback=(Feedback)criteria.uniqueResult();
		}catch(Exception e){
			throw new DBException();
		}
		return feedback;
	}

	@Override
	public boolean checkFeedbackForUserForCourseExists(Integer userId,
			Integer courseId) throws DBException {
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Feedback.class);
			criteria.add(Restrictions.eq("mUser.mUserId",userId));
			criteria.add(Restrictions.eq("mCourse.mCourseId",courseId));
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
}

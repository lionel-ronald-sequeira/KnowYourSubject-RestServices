package com.project.kys.rest.service;
import javax.ws.rs.core.Response;

import com.project.data.objects.Course;
import com.project.data.objects.Feedback;
import com.project.data.objects.Professor;
import com.project.data.objects.User;

public interface FeedbackRestService {
	
	public Response addFeedback(Feedback feedback);
	
	public Response updateFeedback(Feedback feedback);
	
	public Response deleteFeedback(Feedback feedback);
	
	public Response getFeedbackListForUser(Feedback feedback);
	
	public Response getFeedbackListForCourse(Course course);
	
	public Response getFeedbackListForProfessor(Feedback feedback);
	
	public Response getFeedbackListForComment(Feedback feedback);
	
	public Response getFeedbackForUserForCourse(Feedback feedback);

}

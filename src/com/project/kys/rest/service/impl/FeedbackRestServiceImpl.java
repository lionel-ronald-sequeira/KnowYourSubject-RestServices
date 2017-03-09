package com.project.kys.rest.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.data.objects.Course;
import com.project.data.objects.Discipline;
import com.project.data.objects.Feedback;
import com.project.data.objects.Professor;
import com.project.data.objects.User;
import com.project.kys.constants.StringConstants;
import com.project.kys.constants.Constants.RestResourcePaths.FeedbackPath;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.rest.service.FeedbackRestService;
import com.project.kys.service.DisciplineService;
import com.project.kys.service.FeedbackService;
import com.project.kys.utility.ErrorMessage;
import com.project.kys.utility.WebAppContext;

@Path(FeedbackPath.CLASS)
public class FeedbackRestServiceImpl implements FeedbackRestService {
	
	private FeedbackService feedbackService=null;
	
	@POST
	@Path(FeedbackPath.ADD_FEEDBACK)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response addFeedback(Feedback feedback){
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			feedbackService=(FeedbackService)ctx.getBean("feedbackService");
			feedbackService.addFeedback(feedback);
			errorMessage=ErrorMessage.getErrorMessage("200","SUCCESS");
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601",be.getMessage());
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
	}

	@POST
	@Path(FeedbackPath.UPDATE_FEEDBACK)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response updateFeedback(Feedback feedback) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			feedbackService=(FeedbackService)ctx.getBean("feedbackService");
			feedbackService.updateFeedback(feedback);
			errorMessage=ErrorMessage.getErrorMessage("200","SUCCESS");
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601","Business Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();	}

	@POST
	@Path(FeedbackPath.DELETE_FEEDBACK)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response deleteFeedback(Feedback feedback) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			feedbackService=(FeedbackService)ctx.getBean("feedbackService");
			feedbackService.deleteFeedback(feedback.getmFeedbackId());
			errorMessage=ErrorMessage.getErrorMessage("200","SUCCESS");
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601","Business Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
	}

	@POST
	@Path(FeedbackPath.GET_FEEDBACK_LIST_4_USER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getFeedbackListForUser(Feedback feedback) {
		String errorMessage=null;
		List<Feedback>feedBackDataObjList=null;
		Map<String,List<Feedback>>feedbackDataMap=new HashMap<String, List<Feedback>>();
		String result=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			feedbackService=(FeedbackService)ctx.getBean("feedbackService");
			feedBackDataObjList=feedbackService.getFeedbackListForUser(feedback.getmUserId(),feedback.getmCourseId());			
			feedbackDataMap.put("feedbackMap", feedBackDataObjList);
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(feedbackDataMap);
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601","Business Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(result).build();
	}

	@POST
	@Path(FeedbackPath.GET_FEEDBACK_LIST_4_COURSE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getFeedbackListForCourse(Course course) {
		String errorMessage=null;
		List<Feedback>feedBackDataObjList=null;
		Map<String,List<Feedback>>feedbackDataMap=new HashMap<String, List<Feedback>>();
		String result=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			feedbackService=(FeedbackService)ctx.getBean("feedbackService");
			feedBackDataObjList=feedbackService.getFeedbackListForCourse(course.getmCourseId());			
			feedbackDataMap.put("feedbackMap", feedBackDataObjList);
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(feedbackDataMap);
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601","Business Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(result).build();
	}

	@POST
	@Path(FeedbackPath.GET_FEEDBACK_LIST_4_PROFESSOR)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getFeedbackListForProfessor(Feedback feedback) {
		String errorMessage=null;
		List<Feedback>feedBackDataObjList=null;
		Map<String,List<Feedback>>feedbackDataMap=new HashMap<String, List<Feedback>>();
		String result=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			feedbackService=(FeedbackService)ctx.getBean("feedbackService");
			feedBackDataObjList=feedbackService.getFeedbackListForProfessor(feedback.getmProfessorId(),feedback.getmCourseId());			
			feedbackDataMap.put("feedbackMap", feedBackDataObjList);
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(feedbackDataMap);
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601","Business Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(result).build();
	}

	@POST
	@Path(FeedbackPath.GET_FEEDBACK_LIST_4_COMMENT)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getFeedbackListForComment(Feedback feedback) {
		String errorMessage=null;
		List<Feedback>feedBackDataObjList=null;
		Map<String,List<Feedback>>feedbackDataMap=new HashMap<String, List<Feedback>>();
		String result=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			feedbackService=(FeedbackService)ctx.getBean("feedbackService");
			feedBackDataObjList=feedbackService.getFeedbackListForComment(feedback.getmComment());			
			feedbackDataMap.put("feedbackMap", feedBackDataObjList);
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(feedbackDataMap);
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601","Business Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(result).build();
	}

	@POST
	@Path(FeedbackPath.GET_FEEDBACK_FOR_USER_FOR_COURSE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getFeedbackForUserForCourse(Feedback feedback) {
		String errorMessage=null;
		Feedback feedBackDataObj=null;
		String result=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			feedbackService=(FeedbackService)ctx.getBean("feedbackService");
			feedBackDataObj=feedbackService.getFeedbackForUserForCourse(feedback.getmUserId(), feedback.getmCourseId());	
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(feedBackDataObj);
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601",be.getMessage());
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(result).build();
	}

	
}

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
import com.project.data.objects.Major;
import com.project.data.objects.Professor;
import com.project.kys.constants.StringConstants;
import com.project.kys.constants.Constants.RestResourcePaths.CoursePath;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.rest.service.CourseRestService;
import com.project.kys.service.CourseService;
import com.project.kys.utility.ErrorMessage;
import com.project.kys.utility.WebAppContext;

@Path(CoursePath.CLASS)
public class CourseRestServiceImpl implements CourseRestService {
	
	private CourseService courseService=null;
		
	@POST
	@Path(CoursePath.ADD_COURSE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response addCourse(Course course) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			courseService=(CourseService)ctx.getBean("courseService");
			courseService.addCourse(course);
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
	@Path(CoursePath.UPDATE_COURSE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response updateCourse(Course course) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			courseService=(CourseService)ctx.getBean("courseService");
			courseService.updateCourse(course);
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
	@Path(CoursePath.DELETE_COURSE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response deleteCourse(Course course) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			courseService=(CourseService)ctx.getBean("courseService");
			courseService.deleteCourse(course.getmCourseId());
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
	@Path(CoursePath.GET_COURSE_LIST_4_MAJOR)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getCourseListForMajor(Major major) {
		List<Course>profDataObjectList=null;
		String result=null;
		String errorMessage=null;
		Map<String,List<Course>>courseMap=new HashMap<String,List<Course>>();
		try{
			ObjectMapper objectMapper=new ObjectMapper();
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			courseService=(CourseService)ctx.getBean("courseService");
			profDataObjectList=courseService.getCourseListForMajor(major.getmMajorId());
			courseMap.put("courseMap", profDataObjectList);
			result=objectMapper.writeValueAsString(courseMap);
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601",be.getMessage());
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (JsonProcessingException e) {
			errorMessage=ErrorMessage.getErrorMessage("603","Json Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(result).build();
	}

	@POST
	@Path(CoursePath.GET_COURSE_LIST_4_PROFESSOR)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getCourseListForProfessor(Professor professor) {
		List<Course>courseDataObjectList=null;
		String result=null;
		String errorMessage=null;
		Map<String,List<Course>>courseMap=new HashMap<String,List<Course>>();
		try{
			ObjectMapper objectMapper=new ObjectMapper();
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			courseService=(CourseService)ctx.getBean("courseService");
			courseDataObjectList=courseService.getCourseListForProfessor(professor.getmProfessorId());
			courseMap.put("courseMap", courseDataObjectList);
			result=objectMapper.writeValueAsString(courseMap);
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601",be.getMessage());
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (JsonProcessingException e) {
			errorMessage=ErrorMessage.getErrorMessage("603","Json Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(result).build();
	}

	@Override
	@POST
	@Path(CoursePath.GET_COURSE)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCourse(Course course) {
		String errorMessage=null;
		String result=null;
		Course courseDataObj=null;
		try{
			ObjectMapper objectMapper=new ObjectMapper();
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			courseService=(CourseService)ctx.getBean("courseService");
			courseDataObj=courseService.getCourse(course.getmCourseId());
			result=objectMapper.writeValueAsString(courseDataObj);
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601",be.getMessage());
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (JsonProcessingException e) {
			errorMessage=ErrorMessage.getErrorMessage("603","Json Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(result).build();
	}

}

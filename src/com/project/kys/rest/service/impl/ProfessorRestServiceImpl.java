package com.project.kys.rest.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.data.objects.Course;
import com.project.data.objects.Professor;
import com.project.kys.constants.Constants.Keys;
import com.project.kys.constants.Constants.RestResourcePaths.ProfessorPath;
import com.project.kys.constants.StringConstants;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.rest.service.ProfessorRestService;
import com.project.kys.service.ProfessorService;
import com.project.kys.utility.ErrorMessage;
import com.project.kys.utility.WebAppContext;

@Path(ProfessorPath.CLASS)
public class ProfessorRestServiceImpl implements ProfessorRestService{

	private ProfessorService profService=null;

	 @POST
	 @Path(ProfessorPath.ADD_PROFESSOR)
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Override
	public Response addProfessor(Professor professor) {
		 String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			profService=(ProfessorService)ctx.getBean("professorService");
			profService.addProfessor(professor);
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
	@Path(ProfessorPath.UPDATE_PROFESSOR)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response updateProfessor(Professor professor) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			profService=(ProfessorService)ctx.getBean("professorService");
			profService.updateProfessor(professor);
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
	@Path(ProfessorPath.DELETE_PROFESSOR)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response deleteProfessor(Professor professor) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			profService=(ProfessorService)ctx.getBean("professorService");
			profService.deleteProfessor(professor.getmProfessorId());
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
   @Path(ProfessorPath.GET_PROFESSOR_LIST_4_COURSE)
   @Consumes(MediaType.APPLICATION_JSON)
   @Override
   public Response getProfessorListForCourse(Course course) {
		List<Professor>profDataObjectList=null;
		String result=null;
		String errorMessage=null;
		Map<String,List<Professor>>professorDataObjMap=new HashMap<String,List<Professor>>();
		try{
			ObjectMapper objectMapper=new ObjectMapper();
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			profService=(ProfessorService)ctx.getBean("professorService");
			profDataObjectList=profService.getProfessorListForCourse(course.getmCourseId());
			professorDataObjMap.put("professorMap",profDataObjectList);
			result=objectMapper.writeValueAsString(professorDataObjMap);
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
@Path(ProfessorPath.GET_PROFESSOR)
@Consumes(MediaType.APPLICATION_JSON)
@Override
public Response getProfessor(Professor professor) {
	String errorMessage=null;
	String result=null;
	Professor profDataObj=null;
	try{
		ObjectMapper objectMapper=new ObjectMapper();
		
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		profService=(ProfessorService)ctx.getBean("professorService");
		profDataObj=profService.getProfessor(professor.getmProfessorId());
		result=objectMapper.writeValueAsString(profDataObj);
	}catch(BusinessException be ){
		errorMessage=ErrorMessage.getErrorMessage("601",be.getMessage());
		return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
	} catch (DBException db) {
		errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
		return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
	}catch (JsonProcessingException e) {
		errorMessage=ErrorMessage.getErrorMessage("603","Json Exception");
		return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
	}
	return Response.status(StringConstants.ERROR_CODE).entity(result).build();
}
	@POST
	@Path(ProfessorPath.GET_ALL_PROFESSOR)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getAllProfessor() {
		List<Professor>profDataObjectList=null;
		String result=null;
		String errorMessage=null;
		Map<String,List<Professor>>professorDataObjMap=new HashMap<String,List<Professor>>();
		try{
			ObjectMapper objectMapper=new ObjectMapper();
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			profService=(ProfessorService)ctx.getBean("professorService");
			profDataObjectList=profService.getAllProfessor();
			professorDataObjMap.put("professorMap",profDataObjectList);
			result=objectMapper.writeValueAsString(professorDataObjMap);
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

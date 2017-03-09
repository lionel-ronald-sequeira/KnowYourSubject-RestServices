package com.project.kys.rest.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.data.objects.Discipline;
import com.project.data.objects.University;
import com.project.kys.constants.Constants.Keys;
import com.project.kys.constants.Constants.RestResourcePaths;
import com.project.kys.constants.StringConstants;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.rest.service.DisciplineRestService;
import com.project.kys.service.DisciplineService;
import com.project.kys.utility.ErrorMessage;
import com.project.kys.utility.WebAppContext;

@Path(RestResourcePaths.DisciplinePath.CLASS)
public class DisciplineRestServiceImpl implements DisciplineRestService {

	private DisciplineService disciplineService=null;
	
	@POST
	@Path(RestResourcePaths.DisciplinePath.ADD_DISCIPLINE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response addDiscipline(Discipline discipline) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			disciplineService=(DisciplineService)ctx.getBean("disciplineService");
			disciplineService.addDiscipline(discipline);
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
	@Path(RestResourcePaths.DisciplinePath.UPDATE_DISCIPLINE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response updateDiscipline(Discipline discipline) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			disciplineService=(DisciplineService)ctx.getBean("disciplineService");
			disciplineService.updateDiscipline(discipline);
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
	@Path(RestResourcePaths.DisciplinePath.DELETE_DISCIPLINE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response deleteDiscipline(Discipline discipline) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			disciplineService=(DisciplineService)ctx.getBean("disciplineService");
			disciplineService.deleteDiscipline(discipline.getmDisciplineId());
			errorMessage=ErrorMessage.getErrorMessage("200","SUCCESS");
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601","Business Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(be.getMessage()).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(db.getMessage()).build();
		} 
		return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
	}

	@POST
	@Path(RestResourcePaths.DisciplinePath.GET_DISCIPLINE_LIST_4_UNIVERSITY)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getDisciplineListForUniversity(University university) {
		String errorMessage=null;
		List<Discipline>disciplineDataObjList=null;
		Map<String,List<Discipline>>disciplineDataMap=new HashMap<String, List<Discipline>>();
		String result=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			disciplineService=(DisciplineService)ctx.getBean("disciplineService");
			disciplineDataObjList=disciplineService.getDisciplineListForUniversity(university.getmUniversityId());
			disciplineDataMap.put("disciplineMap", disciplineDataObjList);
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(disciplineDataMap);
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
	@Path(RestResourcePaths.DisciplinePath.GET_DISCIPLINE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getDiscipline(Discipline discp) {
		Discipline discipline=null;
		String result=null;
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			disciplineService=(DisciplineService)ctx.getBean("disciplineService");
			discipline=disciplineService.getDiscipline(discp.getmDisciplineId());
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(discipline);
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

}

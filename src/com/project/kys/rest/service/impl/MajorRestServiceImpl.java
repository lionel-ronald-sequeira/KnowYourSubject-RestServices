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
import com.project.data.objects.Department;
import com.project.data.objects.Major;
import com.project.kys.constants.StringConstants;
import com.project.kys.constants.Constants.Keys;
import com.project.kys.constants.Constants.RestResourcePaths;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.rest.service.MajorRestService;
import com.project.kys.service.MajorService;
import com.project.kys.utility.ErrorMessage;
import com.project.kys.utility.WebAppContext;

@Path(RestResourcePaths.MajorPath.CLASS)
public class MajorRestServiceImpl implements MajorRestService{

	private MajorService majorService=null;
	
	@POST
	@Path(RestResourcePaths.MajorPath.ADD_MAJOR)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response addMajor(Major major) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			majorService=(MajorService)ctx.getBean("majorService");
			majorService.addMajor(major);
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
	@Path(RestResourcePaths.MajorPath.UPDATE_MAJOR)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response updateMajor(Major major) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			majorService=(MajorService)ctx.getBean("majorService");
			majorService.updateMajor(major);
			errorMessage=ErrorMessage.getErrorMessage("200","SUCCESS");
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601",be.getMessage());
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(StringConstants.SUCCESS_MSG).build();
	}

	@POST
	@Path(RestResourcePaths.MajorPath.DELETE_MAJOR)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response deleteMajor(Major major) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			majorService=(MajorService)ctx.getBean("majorService");
			majorService.deleteMajor(major.getmMajorId());
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
	@Path(RestResourcePaths.MajorPath.GET_MAJOR_LIST_4_DEPARTMENT)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getMajorListForDepartment(Department department) {
		String errorMessage=null;
		List<Major>majorDataObjectList=null;
		Map<String,List<Major>>majorMap=new HashMap<String,List<Major>>();
		String result=null;
		try{
			ObjectMapper objectMapper=new ObjectMapper();
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			majorService=(MajorService)ctx.getBean("majorService");
			majorDataObjectList=majorService.getMajorListForDepartment(department.getmDepartmentId());
			majorMap.put("majorMap", majorDataObjectList);
			result=objectMapper.writeValueAsString(majorMap);
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601",be.getMessage());
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (JsonProcessingException e) {
			errorMessage=ErrorMessage.getErrorMessage("603","JSON Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(result).build();
	}

	@POST
	@Path(RestResourcePaths.MajorPath.GET_MAJOR)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getMajor(Major major) {
		String errorMessage=null;
		String result=null;
		Major majorDataObj=null;
		try{
			ObjectMapper objectMapper=new ObjectMapper();
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			majorService=(MajorService)ctx.getBean("majorService");
			majorDataObj=majorService.getMajor(major.getmMajorId());
			result=objectMapper.writeValueAsString(majorDataObj);
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601",be.getMessage());
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (JsonProcessingException e) {
			errorMessage=ErrorMessage.getErrorMessage("603","JSON Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(result).build();
	}

}

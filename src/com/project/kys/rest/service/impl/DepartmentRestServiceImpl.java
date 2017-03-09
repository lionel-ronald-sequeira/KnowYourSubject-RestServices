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
import com.project.data.objects.Department;
import com.project.data.objects.Discipline;
import com.project.data.objects.Major;
import com.project.kys.constants.StringConstants;
import com.project.kys.constants.Constants.Keys;
import com.project.kys.constants.Constants.RestResourcePaths;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.rest.service.DepartmentRestService;
import com.project.kys.service.DepartmentService;
import com.project.kys.service.DisciplineService;
import com.project.kys.utility.ErrorMessage;
import com.project.kys.utility.WebAppContext;


@Path(RestResourcePaths.DepartmentPath.CLASS)
public class DepartmentRestServiceImpl implements DepartmentRestService {

	private DepartmentService departmentService=null;
	
	@POST
	@Path(RestResourcePaths.DepartmentPath.ADD_DEPARTMENT)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response addDepartment(Department department) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			departmentService=(DepartmentService)ctx.getBean("departmentService");
			departmentService.addDepartment(department);
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
	@Path(RestResourcePaths.DepartmentPath.UPDATE_DEPARTMENT)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response updateDepartment(Department department) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			departmentService=(DepartmentService)ctx.getBean("departmentService");
			departmentService.updateDepartment(department);
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
	@Path(RestResourcePaths.DepartmentPath.DELETE_DEPARTMENT)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response deleteDepartment(Department department) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			departmentService=(DepartmentService)ctx.getBean("departmentService");
			departmentService.deleteDepartment(department.getmDepartmentId());
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
	@Path(RestResourcePaths.DepartmentPath.GET_DEPARTMENT_LIST_4_DISCIPLINE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getDepartmentListForDiscipline(Discipline discipline) {
		List<Department>departmentDataObjectList=null;
		Map<String,List<Department>>disciplineMap=new HashMap<String,List<Department>>();
		String result=null;
		String errorMessage=null;
		try{
			ObjectMapper objectMapper=new ObjectMapper();
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			departmentService=(DepartmentService)ctx.getBean("departmentService");
			departmentDataObjectList=departmentService.getDepartmentListForDiscipline(discipline.getmDisciplineId());
			disciplineMap.put("departmentMap", departmentDataObjectList);
			result=objectMapper.writeValueAsString(disciplineMap);
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
	@Path(RestResourcePaths.DepartmentPath.GET_DEPARTMENT)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getDepartment(Department department) {
		Department departmentDataObj=null;
		String result=null;
		String errorMessage=null;
		try{
			ObjectMapper objectMapper=new ObjectMapper();
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			departmentService=(DepartmentService)ctx.getBean("departmentService");
			departmentDataObj=departmentService.getDepartment(department.getmDepartmentId());
			result=objectMapper.writeValueAsString(departmentDataObj);
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601",be.getMessage());
			return Response.status(StringConstants.ERROR_CODE).entity(be.getMessage()).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(db.getMessage()).build();
		} catch (JsonProcessingException e) {
			errorMessage=ErrorMessage.getErrorMessage("603","JSON Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(result).build();
	}

	@POST
	@Path(RestResourcePaths.DepartmentPath.GET_ALL_DEPARTMENT)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getAllDepartments() {
		List<Department>departmentDataObjectList=null;
		Map<String,List<Department>>departmentMap=new HashMap<String,List<Department>>();
		String result=null;
		String errorMessage=null;
		try{
			ObjectMapper objectMapper=new ObjectMapper();
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			departmentService=(DepartmentService)ctx.getBean("departmentService");
			departmentDataObjectList=departmentService.getAllDepartments();
			departmentMap.put("departmentMap", departmentDataObjectList);
			result=objectMapper.writeValueAsString(departmentMap);
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

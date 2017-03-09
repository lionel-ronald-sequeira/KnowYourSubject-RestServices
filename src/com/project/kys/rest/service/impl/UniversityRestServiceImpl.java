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
import com.project.data.objects.Department;
import com.project.data.objects.University;
import com.project.kys.constants.StringConstants;
import com.project.kys.constants.Constants.RestResourcePaths.UniversityPath;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.rest.service.UniversityRestService;
import com.project.kys.service.UniversityService;
import com.project.kys.utility.WebAppContext;

@Path(UniversityPath.CLASS)
public class UniversityRestServiceImpl implements UniversityRestService {

	private UniversityService universityService=null;
	
	@POST
	@Path(UniversityPath.ADD_UNIVERSITY)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response addUniversity(University university) {
		String result=null;
		Map<String,String>statusResult=new HashMap<String,String>();
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			universityService=(UniversityService)ctx.getBean("universityService");
			universityService.addUniversity(university);
			ObjectMapper mapper=new ObjectMapper();
			statusResult.put("code", "200");
			statusResult.put("status", "SUCCESS");
			result=mapper.writeValueAsString(statusResult);
		}catch(BusinessException be ){
			statusResult.put("code", "601");
			statusResult.put("status", "Business Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(be.getMessage()).build();
		} catch (DBException db) {
			statusResult.put("code", "602");
			statusResult.put("status", "DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(db.getMessage()).build();
		}catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(result).build();
	}

	@POST
	@Path(UniversityPath.GET_UNIVERSITY)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getUniversity(University university) {
		String result=null;
		University univ=null;
		Map<String,String>statusResult=new HashMap<String,String>();
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			universityService=(UniversityService)ctx.getBean("universityService");
			univ=universityService.getUniversity(university.getmUniversityName());
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(univ);
		}catch(BusinessException be ){
			statusResult.put("code", "601");
			statusResult.put("status", "Business Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(statusResult).build();
		} catch (DBException db) {
			statusResult.put("code", "602");
			statusResult.put("status", "DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(statusResult).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(result).build();
	}
	

	@POST
	@Path(UniversityPath.UPDATE_UNIVERSITY)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response updateUniversity(University university) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Path(UniversityPath.DELETE_UNIVERSITY)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response deleteUniversity(University university) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Path(UniversityPath.GET_UNIVERSITY_LIST)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getUniversityList() {
		String result=null;
		List<University> univList=null;
		Map<String,List<University>>disciplineMap=new HashMap<String,List<University>>();
		Map<String,String>statusResult=new HashMap<String,String>();
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			universityService=(UniversityService)ctx.getBean("universityService");
			univList=universityService.getUniversityList();
			disciplineMap.put("universityMap",univList);
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(disciplineMap);
		}catch(BusinessException be ){
			statusResult.put("code", "601");
			statusResult.put("status", "Business Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(be.getMessage()).build();
		} catch (DBException db) {
			statusResult.put("code", "602");
			statusResult.put("status", "DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(db.getMessage()).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(result).build();
	}

}

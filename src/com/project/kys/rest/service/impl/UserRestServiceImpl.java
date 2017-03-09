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
import com.project.data.objects.User;
import com.project.kys.constants.StringConstants;
import com.project.kys.constants.Constants.RestResourcePaths.AuthenticationPath;
import com.project.kys.constants.Constants.RestResourcePaths.UserPath;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.rest.service.UserRestService;
import com.project.kys.service.UserService;
import com.project.kys.utility.ErrorMessage;
import com.project.kys.utility.WebAppContext;

@Path(UserPath.CLASS)
public class UserRestServiceImpl implements UserRestService {

	private UserService userService=null;
	
	@POST
	@Path(UserPath.UPDATE_USER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response updateUser(User user) {
		String errorMessage=null;
		User userDataObj=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			userService=(UserService)ctx.getBean("userService");
			userDataObj=userService.updateUser(user);
			errorMessage=ErrorMessage.getErrorMessageForUser("200","SUCCESS",userDataObj);
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
    @Path(UserPath.DELETE_USER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response deleteUser(User user) {
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			userService=(UserService)ctx.getBean("userService");
			userService.deleteUser(user);
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
    @Path(UserPath.GET_USER)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response getUser(User user) {
    	User userDataObj=null;
		String result=null;
		String errorMessage=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			userService=(UserService)ctx.getBean("userService");
			userDataObj=userService.getUser(user);
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(userDataObj);
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
    @Path(UserPath.GET_USER_LIST_4_DEPARTMENT)
    @Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response getUserList4Department(Department  department){
    	String errorMessage=null;
		List<User>userDataObjList=null;
		Map<String,List<User>>userDataMap=new HashMap<String, List<User>>();
		String result=null;
		try{
			ApplicationContext ctx = WebAppContext.getApplicationContext();
			userService=(UserService)ctx.getBean("userService");
			userDataObjList=userService.getUserListForDepartment(department);
			userDataMap.put("userMap", userDataObjList);
			ObjectMapper mapper=new ObjectMapper();
			result=mapper.writeValueAsString(userDataMap);
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
	@Path(AuthenticationPath.CHANGE_PASSWORD)
	@Consumes(MediaType.APPLICATION_JSON) 
	@Override
	public Response changePassword(User user) {
		String errorMessage=null;
		User userDataObj=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		userService=(UserService)ctx.getBean("userService");
		try{
			userDataObj=userService.changePassword(user);
			errorMessage=ErrorMessage.getErrorMessageForUser("200","SUCCESS",userDataObj);
		}catch(BusinessException be ){
			errorMessage=ErrorMessage.getErrorMessage("601",be.getMessage());
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		} catch (DBException db) {
			errorMessage=ErrorMessage.getErrorMessage("602","DB Exception");
			return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
		}
		return Response.status(StringConstants.ERROR_CODE).entity(errorMessage).build();
	}

    

}

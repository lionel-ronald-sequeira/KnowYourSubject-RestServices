package com.project.kys.rest.service.impl;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.data.objects.User;
import com.project.kys.constants.Constants.RestResourcePaths.AuthenticationPath;
import com.project.kys.constants.StringConstants;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.rest.service.AuthenticationRestService;
import com.project.kys.service.UserService;
import com.project.kys.utility.ErrorMessage;
import com.project.kys.utility.WebAppContext;

@Path(AuthenticationPath.CLASS)
public class AuthenticationRestServiceImpl implements AuthenticationRestService {

	private UserService userService=null;
	
	@POST
	@Path(AuthenticationPath.LOGIN)
	@Consumes(MediaType.APPLICATION_JSON) 
	@Override
	public Response login(User user) {
		String errorMessage=null;
		User userDataObj=null;
		String result=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		userService=(UserService)ctx.getBean("userService");
		try{
			userDataObj=userService.checkUserExists(user.getmEmailId(), user.getmPassword());
			errorMessage=ErrorMessage.getErrorMessageForUser("200", "SUCCESS", userDataObj);
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
	@Path(AuthenticationPath.RETRIEVE_PASSWORD)
	@Consumes(MediaType.APPLICATION_JSON) 
	@Override
	public Response retrievePassword(User user) {
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		userService=(UserService)ctx.getBean("userService");
		ObjectMapper mapper=new ObjectMapper();
		User userDataObj=null;
		String errorMessage=null;
		String result=null;
		try{
			userDataObj=userService.retrievePassword(user);
			result=mapper.writeValueAsString(userDataObj);
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

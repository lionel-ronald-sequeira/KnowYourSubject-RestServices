package com.project.kys.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;

import com.project.data.objects.User;
import com.project.kys.constants.StringConstants;
import com.project.kys.constants.Constants.RestResourcePaths.RegistrationPath;
import com.project.kys.exception.BusinessException;
import com.project.kys.exception.DBException;
import com.project.kys.rest.service.RegistrationRestService;
import com.project.kys.service.UserService;
import com.project.kys.utility.ErrorMessage;
import com.project.kys.utility.WebAppContext;

@Path(RegistrationPath.CLASS)
public class RegistrationRestServiceImpl implements RegistrationRestService {
	private UserService userService=null;
	
	@POST
	@Path(RegistrationPath.REGISTER_USER)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response registerUser(User user) {
		String errorMessage=null;
		User userDataObj=null;
		ApplicationContext ctx = WebAppContext.getApplicationContext();
		userService=(UserService)ctx.getBean("userService");
		try{
			userDataObj=userService.registerUser(user);
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

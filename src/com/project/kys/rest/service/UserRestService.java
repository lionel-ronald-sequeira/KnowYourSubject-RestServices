package com.project.kys.rest.service;




import javax.ws.rs.core.Response;

import com.project.data.objects.Department;
import com.project.data.objects.User;


public interface UserRestService {

	public Response updateUser(User user);
	
	public Response deleteUser(User user);
	
	public Response getUser(User user);
	
	public Response getUserList4Department(Department deparment);
	
	public Response changePassword(User user);
	 
}

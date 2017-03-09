package com.project.kys.rest.service;

import javax.ws.rs.core.Response;

import com.project.data.objects.User;

public interface AuthenticationRestService {
	Response login(User user);
	
	Response retrievePassword(User user);
}

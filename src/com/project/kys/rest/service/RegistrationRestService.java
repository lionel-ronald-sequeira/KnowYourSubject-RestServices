package com.project.kys.rest.service;

import javax.ws.rs.core.Response;
import com.project.data.objects.User;
public interface RegistrationRestService {
	Response registerUser(User user);
}

package com.project.kys.utility;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.data.objects.User;

public class ErrorMessage {

	public static String getErrorMessage(String codeNo,String message){
		Map<String,String>statusResult=new HashMap<String,String>();
		ObjectMapper mapper=new ObjectMapper();
		String result=null;
		statusResult.put("code", codeNo);
		statusResult.put("status", message);
		try {
		 result=mapper.writeValueAsString(statusResult);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String getErrorMessageForUser(String codeNo,String message,User user){
		Map<String,Object>statusResult=new HashMap<String,Object>();
		ObjectMapper mapper=new ObjectMapper();
		String result=null;
		statusResult.put("code", codeNo);
		statusResult.put("status", message);
		statusResult.put("userMap", user);
		try {
		 result=mapper.writeValueAsString(statusResult);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
}

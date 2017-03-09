package com.project.kys.utility;

import org.springframework.context.ApplicationContext;

public class WebAppContext {
	private static ApplicationContext ctx;
	
	public static void setApplicationContext(ApplicationContext applicationContext) {
        ctx = applicationContext;
    }
	
	public static ApplicationContext getApplicationContext() {
        return ctx;
    }

}

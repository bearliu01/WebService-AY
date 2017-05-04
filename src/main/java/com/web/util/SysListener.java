package com.web.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class SysListener extends HttpServlet implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {		

	}

	public void contextInitialized(ServletContextEvent sce) {		
		String socketIp = sce.getServletContext().getInitParameter("socketIp");
		int socketPort = Integer.parseInt(sce.getServletContext().getInitParameter("socketPort"));
		new ConstParam(socketIp, socketPort);
	}

}

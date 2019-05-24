package com.chainsys.bug.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bug.exception.BugTrackingException;
import com.chainsys.bug.model.Project;
import com.chainsys.bug.services.ProjectServices;

@WebServlet("/ViewProjectServlet")
public class ViewProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewProjectServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Project> projectList = new ArrayList<>();
		ProjectServices projectServices = new ProjectServices();
		projectServices = new ProjectServices();
		try
		{
		projectList = projectServices.viewProjectServices();
		request.setAttribute("projectList", projectList);
		RequestDispatcher rd = request.getRequestDispatcher("ViewProjects.jsp");
		rd.forward(request, response);
	
	}
	catch(BugTrackingException e)
	{
		String a=e.getMessage();
		request.setAttribute("projectList", projectList);
		RequestDispatcher rd = request.getRequestDispatcher("ViewProjects.jsp");
		rd.forward(request, response);
	}}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

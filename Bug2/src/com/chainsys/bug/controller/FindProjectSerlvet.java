package com.chainsys.bug.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bug.exception.ProjectException;
import com.chainsys.bug.model.Project;
import com.chainsys.bug.services.ProjectServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/FindProjectSerlvet")
public class FindProjectSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public FindProjectSerlvet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		ArrayList<Project> projectList = new ArrayList<>();
		ProjectServices projectServices = new ProjectServices();
		try {
			projectList = projectServices.viewProjectServices();
		} catch (ProjectException e) {
			
			e.printStackTrace();
		}
		request.setAttribute("projectList", projectList);
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
		String project=gson.toJson(projectList);
		response.getWriter().write(project);
	}
}

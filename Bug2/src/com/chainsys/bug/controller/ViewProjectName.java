package com.chainsys.bug.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.bug.exception.ProjectException;
import com.chainsys.bug.model.Project;
import com.chainsys.bug.services.ProjectServices;

@WebServlet("/ViewProjectName")
public class ViewProjectName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewProjectName() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession(false);
		Long n = (Long) session.getAttribute("username");
		ArrayList<Project> projectList = new ArrayList<>();
		ProjectServices projectServices = new ProjectServices();
		try {
			projectList = projectServices.viewProjectName(n);
		} catch (ProjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("projectList", projectList);
		RequestDispatcher rd = request.getRequestDispatcher("ViewAllocatedProject.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}

package com.chainsys.bug.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.bug.model.Team;
import com.chainsys.bug.model.TeamMembers;
import com.chainsys.bug.services.EmployeeServices;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Team team = new Team();
		team.setName(request.getParameter("teamname"));
		EmployeeServices employeeServices = new EmployeeServices();
		ArrayList<TeamMembers> employeeList = new ArrayList<>();
		ArrayList<TeamMembers> employeeList2 = new ArrayList<>();
		try {
			employeeList = employeeServices.viewEmployeeServices(team);
			employeeList2 = employeeServices.viewLeaderServices(team);
			request.setAttribute("employeeList", employeeList);
			request.setAttribute("employeeList2", employeeList2);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewProject.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

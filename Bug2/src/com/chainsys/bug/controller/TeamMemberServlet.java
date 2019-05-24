package com.chainsys.bug.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.bug.model.Project;
import com.chainsys.bug.model.TeamMembers;
import com.chainsys.bug.services.EmployeeServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TeamMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public TeamMemberServlet() {
		super();

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * doGet(request, response); System.out.println("kdf");
		 * 
		 * // TeamMembers teammembers = new TeamMembers(); // TeamMembersDAO
		 * teammembersDAO = new TeamMembersDAO(); TeamDAO teamDAO = new TeamDAO();
		 * 
		 * // ArrayList<TeamMembers> teamMembers = new ArrayList<TeamMembers>();
		 * ArrayList<Team> teams = new ArrayList<Team>();
		 * 
		 * Team team = new Team();
		 * 
		 * // String member = request.getParameter("leader"); // String leader =
		 * request.getParameter("member");
		 * 
		 * try {
		 * 
		 * RequestDispatcher rd = request.getRequestDispatcher("team.jsp");
		 * rd.forward(request, response);
		 * 
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * try {
		 * 
		 * } catch (Exception e1) {
		 * 
		 * }
		 * 
		 */

		Project project = new Project();
		EmployeeServices employeeServices = new EmployeeServices();
		project.setId(Long.parseLong(request.getParameter("second")));
		ArrayList<TeamMembers> teamMemberslist = new ArrayList<>();
		try {
			teamMemberslist = employeeServices.viewTeamServices(project);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jsonteam = gson.toJson(teamMemberslist);
			response.getWriter().write(jsonteam);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
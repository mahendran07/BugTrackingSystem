package com.chainsys.bug.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bug.dao.TeamDAO;
import com.chainsys.bug.model.Team;

public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TeamServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		doGet(request, response);
		Team team = new Team();
		TeamDAO teamDAO = new TeamDAO();
		ArrayList<Team> teams = new ArrayList<Team>();
		team.setName(request.getParameter("name"));
		int button = Integer.parseInt(request.getParameter("buttonn"));
		System.out.println(button);

		switch (button) {

		case 1:
			try {
				teams = teamDAO.selectTeam();
				teamDAO.addTeam(team);
				;
				String status = "Team Details Added";
				request.setAttribute("status", status);

				RequestDispatcher rd = request.getRequestDispatcher("team.jsp");
				rd.forward(request, response);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;

		case 2:
			try {

				teams = teamDAO.selectTeam();
				request.setAttribute("teams", teams);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("team.jsp");
				requestDispatcher.forward(request, response);
			} catch (Exception e) {
				System.out.println("Failed");
			}

			break;
		}
	}
}

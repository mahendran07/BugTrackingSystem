package com.chainsys.bug.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bug.dao.TeamDAO;
import com.chainsys.bug.model.Team;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/ViewTeamServlet")
public class ViewTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewTeamServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			TeamDAO teamDAO = new TeamDAO();
			ArrayList<Team> teams = new ArrayList<Team>();
			teams = teamDAO.selectTeam();
			System.out.println("d"+teams);
			request.setAttribute("teams", teams);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String buglist = gson.toJson(teams);
			response.getWriter().write(buglist);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
